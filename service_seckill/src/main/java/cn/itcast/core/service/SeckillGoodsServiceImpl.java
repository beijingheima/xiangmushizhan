package cn.itcast.core.service;

import cn.itcast.core.dao.seckill.SeckillGoodsDao;
import cn.itcast.core.pojo.seckill.SeckillGoods;
import cn.itcast.core.pojo.seckill.SeckillGoodsQuery;
import cn.itcast.core.pojo.seckill.SeckillOrder;
import cn.itcast.core.util.IdWorker;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.List;
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Autowired
    private SeckillGoodsDao seckillGoodsDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IdWorker idWorker;

    //支付前获取订单
    @Override
    public SeckillOrder searchOrderFromRedisByUserId(String userId) {
        SeckillOrder secKillOrder = (SeckillOrder)redisTemplate.boundHashOps("secKillOrder").get(userId);
        return secKillOrder;


    }

    //提交订单
    @Override
    public void submitOrder(Long seckillId, String userId) {
        SeckillGoods secKillGoods = (SeckillGoods)redisTemplate.boundHashOps("secKillGoods").get(seckillId);
        if (secKillGoods==null){
            throw new RuntimeException("此商品不存在");
        }
        if (secKillGoods.getStockCount()<=0){
            throw new RuntimeException("商品已抢购一空");
        }
        //有商品 从redis中获取 并数量减一后放回redis
        secKillGoods.setStockCount(secKillGoods.getStockCount()-1);
        redisTemplate.boundHashOps("seckillGoods").put(seckillId, secKillGoods);

        if(secKillGoods.getStockCount()==0){//如果已经被秒光
            seckillGoodsDao.updateByPrimaryKey(secKillGoods);//同步到数据库
            redisTemplate.boundHashOps("seckillGoods").delete(seckillId);
        }

        long orderId = idWorker.nextId();
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setId(orderId);
        seckillOrder.setCreateTime(new Date());
        seckillOrder.setMoney(secKillGoods.getCostPrice());
        seckillOrder.setSeckillId(seckillId);
        seckillOrder.setSellerId(secKillGoods.getSellerId());
        seckillOrder.setUserId(userId);
        seckillOrder.setStatus("0");
        redisTemplate.boundHashOps("secKillOrder").put(userId,seckillOrder);


    }

    //商品详情页调用 查找单个秒杀商品
    @Override
    public SeckillGoods findOneFromRedis(Long id) {
        SeckillGoods secKillGoods = (SeckillGoods)redisTemplate.boundHashOps("secKillGoods").get(id);
        return secKillGoods;
    }


    //秒杀列表页面调用 查询所有秒杀商品
    @Override
    public List<SeckillGoods> findList() {
/*        List<SeckillGoods> secKillGoods = redisTemplate.boundHashOps("secKillGoods").values();
        //如果redis没数据 去数据库查询
        if (secKillGoods==null || secKillGoods.size()==0){
            SeckillGoodsQuery query = new SeckillGoodsQuery();
            SeckillGoodsQuery.Criteria criteria = query.createCriteria();
            criteria.andStatusEqualTo("1");//审核通过
            criteria.andStockCountGreaterThan(0);//剩余库存大于0
            criteria.andStartTimeLessThanOrEqualTo(new Date());//开始时间小于等于当前时间
            criteria.andEndTimeGreaterThan(new Date());//结束时间大于当前时间
            secKillGoods = seckillGoodsDao.selectByExample(query);


            //查询结果放入缓存
            for (SeckillGoods secKillGood : secKillGoods) {
                redisTemplate.boundHashOps("secKillGoods").put(secKillGood.getId(),secKillGood);
            }
            }*/


        SeckillGoodsQuery query = new SeckillGoodsQuery();
        SeckillGoodsQuery.Criteria criteria = query.createCriteria();
        criteria.andStatusEqualTo("1");//审核通过
        criteria.andStockCountGreaterThan(0);//剩余库存大于0
        criteria.andStartTimeLessThanOrEqualTo(new Date());//开始时间小于等于当前时间
        criteria.andEndTimeGreaterThan(new Date());//结束时间大于当前时间
        List<SeckillGoods> seckillGoods = seckillGoodsDao.selectByExample(query);


        return seckillGoods;
    }
}
