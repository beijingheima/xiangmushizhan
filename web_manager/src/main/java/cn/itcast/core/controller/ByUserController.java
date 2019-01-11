package cn.itcast.core.controller;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.entity.Result;
import cn.itcast.core.pojo.user.User;
import cn.itcast.core.service.ByUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/byuser")
public class ByUserController {
    @Reference
    private ByUserService byUserService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody User user, Integer page, Integer rows) {
        PageResult result = byUserService.findPage(user, page, rows);
        return result;
    }

    @RequestMapping("/add")
    public Result add(@RequestBody User user) {
        try {
            byUserService.add(user);
            return new Result(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败!");
        }
    }

    @RequestMapping("/findOne")
    public User findOne(Long id) {
        System.out.println(id);
        return byUserService.findOne(id);

    }

    @RequestMapping("/update")
    public  Result update(@RequestBody User user) {
        try {
            byUserService.update(user);
            return new Result(true, "保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "保存失败!");
        }
    }

}
