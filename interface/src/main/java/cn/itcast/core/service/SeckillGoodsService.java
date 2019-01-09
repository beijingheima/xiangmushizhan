package cn.itcast.core.service;

import cn.itcast.core.pojo.seckill.SeckillGoods;

import java.util.List;

public interface SeckillGoodsService {
    public List<SeckillGoods> findList();
    public SeckillGoods findOneFromRedis(Long id);
    public void submitOrder(Long seckillId,String userId);
}
