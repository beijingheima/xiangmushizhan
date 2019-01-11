package cn.itcast.core.controller;

import cn.itcast.core.pojo.item.Item;
import cn.itcast.core.service.ItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:TianZT
 * @date:2019/1/10
 * @description:
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @Reference
    ItemService itemService;

    @RequestMapping("/findByGoodsId")
    public List<Item> findByGoodsId(Long goodsId) {
        return itemService.findByGoodsId(goodsId);
    }

}
