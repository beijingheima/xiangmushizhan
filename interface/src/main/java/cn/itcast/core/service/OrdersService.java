package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.OrderEntity;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import cn.itcast.core.pojo.order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdersService {


    public List<OrderEntity> findAll();
    public PageResult findPage(OrderEntity order, Integer page, Integer rows);

    public Brand findOne(Long id);


    public List<Map> selectOptionList();



}
