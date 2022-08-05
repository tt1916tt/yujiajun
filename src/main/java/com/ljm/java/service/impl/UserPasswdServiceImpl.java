package com.ljm.java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljm.java.entity.UserPasswd;
import com.ljm.java.mapper.UserPasswdMapper;
import com.ljm.java.service.IUserPasswdService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pustian
 * @since 2021-12-21
 */
@Service
public class UserPasswdServiceImpl extends ServiceImpl<UserPasswdMapper, UserPasswd> implements IUserPasswdService {

}
