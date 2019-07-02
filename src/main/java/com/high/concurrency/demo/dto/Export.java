package com.high.concurrency.demo.dto;

import java.util.Date;

/**
 * @Author chenhe
 * @Date 2019/7/2 14:27
 * @Description 保留秒杀地址DTO
 */
public class Export {

    private boolean exposed;

    private String md5;

    private Long seckillId;

    //系统当前时间 毫秒
    private long now;

    private long start;

    private long end;

    public Export(boolean exposed, String md5, Long seckillId) {
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Export(boolean exposed, Long seckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Export(boolean exposed, Long seckillId) {
        this.exposed = exposed;
        this.md5=md5;
        this.seckillId = seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
