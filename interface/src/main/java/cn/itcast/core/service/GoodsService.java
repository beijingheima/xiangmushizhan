package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.GoodsEntity;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.good.Goods;
import cn.itcast.core.pojo.seckill.SeckillGoods;

import java.util.List;

public interface GoodsService {

    public void add(GoodsEntity goodsEntity);

    public PageResult findPage(Goods goods, Integer page, Integer rows);

    public  GoodsEntity findOne(Long id);

    public void update(GoodsEntity goodsEntity);

    public void  updateStatus(Long id, String  status);

    public void delete(Long id);

    List<Goods> selectSeckillGoodsList(String seller_id);

    void addSeckill(SeckillGoods secGoods, String sellerId);
}
