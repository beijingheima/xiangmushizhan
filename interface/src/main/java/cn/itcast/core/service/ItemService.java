package cn.itcast.core.service;

import cn.itcast.core.pojo.item.Item;

import java.util.List;

public interface ItemService {

    List<Item> findByGoodsId(Long goodsId);
}
