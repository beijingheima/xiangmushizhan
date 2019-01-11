package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.seckill.SeckillGoods;
import cn.itcast.core.service.SeckillGoodsService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
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
        System.out.println("进入列表查询");
        System.out.println(seckillGoodsService.findList());
        return seckillGoodsService.findList();
    }
    @RequestMapping("/findOneFromRedis")
    public SeckillGoods findOneFromRedis(Long id){

        SeckillGoods seckillGoods = seckillGoodsService.findOneFromRedis(id);
        return seckillGoods;
    }
    @RequestMapping("/submitOrder")
    public Result submitOrder(Long seckillId){
        System.out.println("进入sub方法");
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        if("anonymousUser".equals(userId)){//如果未登录
            return new Result(false, "用户未登录");
        }
        try {
            seckillGoodsService.submitOrder(seckillId,userId);
            return new Result(true,"提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"提交失败");
        }

    }

}
