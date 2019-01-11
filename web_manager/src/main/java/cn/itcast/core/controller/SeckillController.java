package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.seckill.SeckillGoods;
import cn.itcast.core.service.SeckillService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:TianZT
 * @date:2019/1/11
 * @description:
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {
    @Reference
    private SeckillService seckillService;

    @RequestMapping("/searchSeckill")
    public PageResult searchSeckill(@RequestBody SeckillGoods seckillGoods, Integer page, Integer rows) {
        return seckillService.searchSeckill(seckillGoods, page, rows);
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids, String status) {
        try {
            if (ids != null) {
                for (Long id : ids) {
                    //1. 更改数据库中商品的审核状态
                    seckillService.updateStatus(id, status);
                }
            }
            return new Result(true, "状态修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "状态修改失败!");
        }
    }
}
