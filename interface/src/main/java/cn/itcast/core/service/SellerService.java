package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.seller.Seller;

import java.util.List;

public interface SellerService {

    public void add(Seller seller);

    public Seller findOne(String id);

    public PageResult findPage(Seller seller, Integer page, Integer rows);

    public void updateStatus(String sellerId, String status);


    //查询用户人数
    public Integer findUserNum();

    //查询用户活跃度
    public List<Integer> findUserLoginNum();

}
