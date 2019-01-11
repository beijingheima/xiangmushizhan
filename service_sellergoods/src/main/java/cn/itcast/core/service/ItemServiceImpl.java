package cn.itcast.core.service;

import cn.itcast.core.dao.item.ItemDao;
import cn.itcast.core.pojo.item.Item;
import cn.itcast.core.pojo.item.ItemQuery;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author:TianZT
 * @date:2019/1/10
 * @description:
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;
    @Override
    public List<Item> findByGoodsId(Long goodsId) {
        ItemQuery itemQuery = new ItemQuery();
        ItemQuery.Criteria criteria = itemQuery.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        return itemDao.selectByExample(itemQuery);
    }
}
