package cn.itcast.core.service;

import cn.itcast.core.pojo.item.ItemCat;

import java.util.List;
import java.util.Map;

public interface ItemCatService {

    public List<ItemCat> findByParentId(Long parentId);

    public ItemCat findOne(Long id);

    public List<ItemCat> findAll();

    //商品分类
    public List<Map> findAllMap();
}
