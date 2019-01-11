package cn.itcast.core.controller;

import cn.itcast.core.pojo.ad.Content;
import cn.itcast.core.pojo.item.Item;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.service.ContentService;
import cn.itcast.core.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 展示广告
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    @Reference
    ItemCatService itemCatService;

    /**
     * 根据分类id查询广告集合
     * @param categoryId
     * @return
     */
    @RequestMapping("/findByCategoryId")
    public List<Content> findByCategoryId(Long categoryId) {
        return contentService.findByCategoryIdFromRedis(categoryId);
    }


    /**
     * 商品分类
     */
    @RequestMapping("/findAllItenCat")
    public List<ItemCat> findByItemCat(){
        List<ItemCat> itemList1 = itemCatService.findByParentId(0l);
        return itemList1;
    }

    @RequestMapping("/findAllItenCat2")
    public List<ItemCat> findAllItenCat2(Long id){
        List<ItemCat> byParentId = itemCatService.findByParentId(id);
        return byParentId;
    }
}
