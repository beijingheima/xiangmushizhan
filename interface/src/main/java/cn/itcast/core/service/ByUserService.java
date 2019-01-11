package cn.itcast.core.service;

import cn.itcast.core.pojo.entity.PageResult;
import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.pojo.user.User;

import java.util.List;
import java.util.Map;

public interface ByUserService {
    public PageResult findPage(User user, Integer page, Integer rows);

    public void add(User user);

    public User findOne(Long id);

    public void update(User user);

    public List<Map> findUserList(User user);
}
