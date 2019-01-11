package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.service.ItemCatService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类管理
 *
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService catService;

    /**
     * 根据父级id查询它对应的子集数据
     * @param parentId   父级id
     * @return
     */
    @RequestMapping("/findByParentId")
    public List<ItemCat> findByParentId(Long parentId) {
        List<ItemCat> list = catService.findByParentId(parentId);

        return list;
    }

    @RequestMapping("/findAll")
    public List<ItemCat> findAll(){
        return catService.findAll();
    }

    /**
     * 修改商品状态
     * @param ids       模板id
     * @param icstatus    模板状态: 0未审核, 1审核通过, 2驳回
     * @return
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids, String icstatus) {
        try {
            if (ids != null) {
                for (Long id : ids) {
                    //1. 更改数据库中分类的审核状态
                    catService .updateStatus(id, icstatus);
                }
            }
            return new Result(true, "状态修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "状态修改失败!");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody ItemCat itemCat, Integer page, Integer rows) {
        PageResult result = catService.findPage(itemCat, page, rows);
        return result;
    }


}
