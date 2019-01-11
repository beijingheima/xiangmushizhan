package cn.itcast.core.service;

import cn.itcast.core.dao.user.UserDao;
import cn.itcast.core.pojo.entity.PageResult;

import cn.itcast.core.pojo.template.TypeTemplate;
import cn.itcast.core.pojo.user.User;
import cn.itcast.core.pojo.user.UserQuery;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class ByUserServiceImpl implements ByUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageResult findPage(User user, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        UserQuery userQuery = new UserQuery();
        UserQuery.Criteria criteria = userQuery.createCriteria();
        if (user != null) {
            if (user.getUsername()!= null && !"".equals(user.getUsername())) {
                criteria.andUsernameEqualTo(user.getUsername());
            }
        }
        Page<User> specList = (Page<User>)userDao.selectByExample(userQuery);
        return new PageResult(specList.getTotal(), specList.getResult());
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User findOne(Long id) {
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }


    @Override
    public List<Map> findUserList(User user) {
        return null;
    }
}
