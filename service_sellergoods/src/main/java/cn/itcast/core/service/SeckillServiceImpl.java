package cn.itcast.core.service;

import cn.itcast.core.dao.seckill.SeckillGoodsDao;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.seckill.SeckillGoods;
import cn.itcast.core.pojo.seckill.SeckillGoodsQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

/**
 * @author:TianZT
 * @date:2019/1/11
 * @description:
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillGoodsDao seckillGoodsDao;
    @Override
    public PageResult searchSeckill(SeckillGoods seckillGoods, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        SeckillGoodsQuery seckillGoodsQuery = new SeckillGoodsQuery();
        SeckillGoodsQuery.Criteria criteria = seckillGoodsQuery.createCriteria();
        if (seckillGoods != null) {
            if (seckillGoods.getStatus() != null && !"".equals(seckillGoods.getStatus())) {
                criteria.andStatusEqualTo(seckillGoods.getStatus());
            }
        }
        Page<SeckillGoods> goodsPage = (Page<SeckillGoods>) seckillGoodsDao.selectByExample(seckillGoodsQuery);
        return new PageResult(goodsPage.getTotal(),goodsPage.getResult());
    }

    @Override
    public void updateStatus(Long id, String status) {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setId(id);
        seckillGoods.setStatus(status);
        seckillGoods.setCheckTime(new Date());
        seckillGoodsDao.updateByPrimaryKeySelective(seckillGoods);
        /*redisTemplate.boundHashOps("seckillGoods").put();*/
    }
}
