package com.test.jpa.user;

import java.util.List;
import javax.annotation.Resource;

import com.test.jpa.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liusven on 2016/10/25.
 */
@Transactional
@Service
public class UserService {
    // 推荐用Resource来替代AutoWrite注解
    @Qualifier("IUserDAO")
    @Resource
    private IUserDAO userDao;

    // 新增用户
    public User saveUser(User user) {
        return userDao.save(user);
    }

    // 删除用户，参数也可以为一个含有id的User对象
    public void deleteUser(String id) {
        userDao.delete(id);
    }

    // 查询所有user对象，findOne为查询单个
    public List<User> findAllUsers() {
        return (List<User>) userDao.findAll();
    }

    /**
     * 根据一个分页对象查询user集合（还可以添加一个Store排序属性）
     * PageRequest    是spring自己封装的请求分页类，实现了Pageable接口，包涵从请求中获得的分页属性（当前页和大小）和获取方法
     * 通过调用分页方法，返回一个Page<>一个泛型集合的分页对象，里面包涵了通过查询计算出的各个属性和结果集
     * 详细类结构和属性请参阅源码
     * @param page
     * @return
     */
    public Page<User> findAllUserByPage(PageRequest page) {
        return userDao.findAll(page);
    }
}
