package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.OrderEntity;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.log.PayLog;
import cn.itcast.core.pojo.order.Order;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    public void add(Order order);

    public PayLog getPayLogByUserName(String userName);

    public void updatePayStatus(String userName);

    //分页差询订单数据
    public PageResult findPage(String sellerId,Integer page,Integer rows);

    //根据id差
    // 查询定单实体获取订单物流信息
    public Order findOne(String id);

    //修改订单表中的物流信息
    public void updateShipping(Order order);
}
