package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.order.Order;
import cn.itcast.core.service.OrderService;
import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;


    @RequestMapping("/findPage")
    public PageResult findPage(Integer page,Integer rows){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        PageResult result = orderService.findPage(userName, page, rows);
        return result;
    }

    @RequestMapping("/findOne")
    public Order findOne(String id){
        Order order = orderService.findOne(id);
        return order;
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Order order){
        try {
            orderService.updateShipping(order);
            return new Result(true,"上传物流信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"上传物流信息失败");
        }
    }
}
