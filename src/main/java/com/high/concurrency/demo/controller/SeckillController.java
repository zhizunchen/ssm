package com.high.concurrency.demo.controller;

import com.high.concurrency.demo.constants.ExceptionEnum;
import com.high.concurrency.demo.domain.Seckill;
import com.high.concurrency.demo.dto.Export;
import com.high.concurrency.demo.dto.SeckillExecution;
import com.high.concurrency.demo.dto.SeckillMessage;
import com.high.concurrency.demo.exception.SeckillException;
import com.high.concurrency.demo.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author chenhe
 * @Date 2019/7/3 10:24
 * @Description
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        //获取列表页
        List<Seckill> list = seckillService.queryAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail" ,method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model){
        if(null == seckillId){
            return "redirect:/seckill/list";//seckill不存在请求重定向到list接口
        }
        Seckill seckill = seckillService.queryById(seckillId);
        if(null == seckill){
            return "redirect:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    @RequestMapping("/{seckillId}/export")
    @ResponseBody
    public SeckillMessage<Export> export(@PathVariable("seckillId") Long seckillId, Model model){
        if(null == seckillId){
            return new SeckillMessage<>(false,ExceptionEnum.ACCOUNT_NOT_EXIT.getCode(), ExceptionEnum.ACCOUNT_NOT_EXIT.getDesc());
        }
        try {
            Export export = seckillService.exportSeckillUrl(seckillId);
            if(null == export){
                return new SeckillMessage<>(false, ExceptionEnum.GOODS_FAILED.getCode(), ExceptionEnum.GOODS_FAILED.getDesc());
            }
            return new SeckillMessage<>(true, export);

        }catch (SeckillException se){
            logger.error(se.getMessage());
            return new SeckillMessage<>(false, se.getCode(), se.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage());
            return new SeckillMessage<>(false, 1000, e.getMessage());
        }
    }

    @RequestMapping("/{seckillId}/{md5}/executeSeckill")
    @ResponseBody
    public SeckillMessage<SeckillExecution> executeSeckill(@PathVariable("seckillId") Long seckillId,
                                                           @PathVariable("md5") String md5,
                                                           @RequestParam("userPhone") Long userPhone){
        if(null == seckillId || null == md5){
            return new SeckillMessage<>(false, ExceptionEnum.ACCOUNT_NOT_EXIT.getCode(), ExceptionEnum.ACCOUNT_NOT_EXIT.getDesc());
        }
        try {
            SeckillExecution result = seckillService.executeSeckill(seckillId, userPhone, md5);
            return new SeckillMessage<>(true, result);
        }catch (SeckillException se){
            return new SeckillMessage<>(false, se.getCode(), se.getMessage());
        } catch(Exception e){
            return new SeckillMessage<>(false, 1000, e.getMessage());
        }
    }
}
