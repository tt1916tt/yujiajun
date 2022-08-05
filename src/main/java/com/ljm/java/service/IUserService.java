package com.ljm.java.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljm.java.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author pustian
 * @since 2021-12-21
 */
public interface IUserService extends IService<User> {

    List<User> selectList(QueryWrapper<User> entityWrapper);
}
