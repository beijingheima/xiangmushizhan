package cn.itcast.core.service;

import cn.itcast.core.dao.order.OrderDao;
import cn.itcast.core.pojo.entity.OrderEntity;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import cn.itcast.core.pojo.order.Order;
import cn.itcast.core.pojo.order.OrderItemQuery;
import cn.itcast.core.pojo.order.OrderQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.Query;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    private OrderDao orderDao;


    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> entityList = orderDao.findAllOrder(null);
        return entityList;
    }



    @Override
    public PageResult findPage(OrderEntity order, Integer page, Integer rows) {
        //使用分页助手, 传入当前页和每页查询多少条数据
        PageHelper.startPage(page, rows);
        OrderQuery orderQuery = new OrderQuery();
        OrderQuery.Criteria criteria1 = orderQuery.createCriteria();
        if (order!=null){
            if (order.getCreateTime()!=null && !"".equals(order.getCreateTime())){
                criteria1.andCreateTimeEqualTo(order.getCreateTime());
            }
        }
        //使用分页助手的page对象接收查询到的数据, page对象继承了ArrayList所以可以接收查询到的结果集数据.
        Page<OrderEntity> orders = (Page<OrderEntity>)orderDao.findAllOrder(orderQuery);
        return new PageResult(orders.getTotal(), orders.getResult());
    }


    @Override
    public Brand findOne(Long id) {
        return null;
    }



    @Override
    public List<Map> selectOptionList() {
        return null;
    }


}
