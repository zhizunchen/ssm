package com.high.concurrency.demo.service.impl;

import com.high.concurrency.demo.constants.ExceptionEnum;
import com.high.concurrency.demo.dao.SeckillMapper;
import com.high.concurrency.demo.dao.SuccessSeckillMapper;
import com.high.concurrency.demo.domain.Seckill;
import com.high.concurrency.demo.domain.SuccessSeckill;
import com.high.concurrency.demo.dto.Export;
import com.high.concurrency.demo.dto.SeckillExecution;
import com.high.concurrency.demo.exception.SeckillException;
import com.high.concurrency.demo.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author chenhe
 * @Date 2019/7/2 15:05
 * @Description
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessSeckillMapper successSeckillMapper;

    private String slat = "1qazxdftyuijkl`.[[s";

    @Override
    public Seckill queryById(Long seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    @Override
    public List<Seckill> queryAll() {
        return seckillMapper.queryAll(0, 10);
    }

    @Override
    public Export exportSeckillUrl(Long seckillId) {
        Seckill seckill = seckillMapper.queryById(seckillId);
        if(null == seckill){
            return new Export(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if(nowTime.getTime() < startTime.getTime()
            || nowTime.getTime() > endTime.getTime()){
            return new Export(false, seckillId, nowTime.getTime(),
                                                   startTime.getTime(), endTime.getTime());
        }
        String md5 = this.getMd5(seckillId);
        return new Export(true, md5, seckillId);
    }

    private String getMd5(Long seckillId){
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) {
        if(null == md5 || !md5.equals(getMd5(seckillId))){
            throw new SeckillException(ExceptionEnum.ACCOUNT_NOT_EXIT.getCode(), ExceptionEnum.ACCOUNT_NOT_EXIT.getDesc());
        }
        //减库存
        int index = seckillMapper.reduceNumber(seckillId, new Date());
        if(0 == index){
            throw new SeckillException(ExceptionEnum.SECKILL_FAILED.getCode(), ExceptionEnum.SECKILL_FAILED.getDesc());
        }else{
            //明细
            int insertCount = successSeckillMapper.insertSuccessKill(seckillId, userPhone);
            if(0 == insertCount){
                throw new SeckillException(ExceptionEnum.SECKILL_FAILED.getCode(), ExceptionEnum.SECKILL_FAILED.getDesc());
            }else{
                SuccessSeckill seckill = successSeckillMapper.queryByIdWithSeckill(seckillId, userPhone);
                return new SeckillExecution(seckillId, ExceptionEnum.SUCCESS.getCode(), seckill);
            }
        }
    }
}
