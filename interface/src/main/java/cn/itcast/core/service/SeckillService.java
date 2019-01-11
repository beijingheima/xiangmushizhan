package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.seckill.SeckillGoods;

public interface SeckillService {

    PageResult searchSeckill(SeckillGoods seckillGoods, Integer page, Integer rows);

    void updateStatus(Long id, String status);
}
