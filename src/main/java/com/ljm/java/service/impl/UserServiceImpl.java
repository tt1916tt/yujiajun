package com.ljm.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljm.java.entity.User;
import com.ljm.java.mapper.UserMapper;
import com.ljm.java.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pustian
 * @since 2021-12-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public List<User> selectList(QueryWrapper<User> entityWrapper) {
        return baseMapper.selectList(entityWrapper);
    }
}
