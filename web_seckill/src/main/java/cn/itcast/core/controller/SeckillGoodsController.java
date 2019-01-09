package cn.itcast.core.controller;

import cn.itcast.core.pojo.seckill.SeckillGoods;
import cn.itcast.core.service.SeckillGoodsService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seckillGoods")
public class SeckillGoodsController {

    @Reference(timeout=10000)
    private SeckillGoodsService seckillGoodsService;


    @RequestMapping("/findList")
    public List<SeckillGoods> findList(){
        return seckillGoodsService.findList();
    }
    @RequestMapping("/findOneFromRedis")
    public SeckillGoods findOneFromRedis(Long id){
        SeckillGoods seckillGoods = seckillGoodsService.findOneFromRedis(id);
        return seckillGoods;
    }


}
