package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.OrderEntity;
import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.order.Order;

import cn.itcast.core.service.OrdersService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Reference
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public List<OrderEntity> findAll() {
        List<OrderEntity> list = ordersService.findAll();
        return list;

    }

    /**
     * 品牌分页查询
     * @param page  当前页
     * @param rows  每页查询多少条数据
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(Integer page, Integer rows) {
        PageResult result = ordersService.findPage(null, page, rows);
        return result;
    }

    /**
     * 根据id查询品牌对象
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Brand findOne(Long id) {
        Brand one = ordersService.findOne(id);
        return one;
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody OrderEntity order, Integer page, Integer rows) {
        PageResult result = ordersService.findPage(order, page, rows);
        return result;
    }


    /**
     * 获取模板下拉选择框所需要的数据
     * [{id:1,text:xxx},{id:2, text: asdfasdfsa}]
     * @return
     */

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        List<Map> list = ordersService.selectOptionList();
        return list;
    }

}
