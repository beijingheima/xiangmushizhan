package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.pojo.template.TypeTemplate;

import java.util.List;
import java.util.Map;

public interface ItemCatService {

    public List<ItemCat> findByParentId(Long parentId);

    public ItemCat findOne(Long id);

    public List<ItemCat> findAll();


    void updateStatus(Long id, String icstatus);

    PageResult findPage(ItemCat itemCat, Integer page, Integer rows);

}
