package com.ljm.java.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljm.java.entity.User;
import com.ljm.java.service.IUserService;
import com.ljm.java.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lijiaming
 * @since 2021-12-21
 */
@Api("user")
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Resource
    IUserService userService;




    @GetMapping("query/{id}")
    public User getUser(@PathVariable Long id){
        log.info("查询的ID:{}",id);
        User clause = new User();
        clause.setId(id);
        return userService.getOne(new QueryWrapper<>(clause));
    }



    @PostMapping("adduser")
    public Boolean addUser(@RequestBody User user){
        if (user.getUserNo() == null){
            // TODO: 2021/12/21  后续做异常处理
            return false;
        }
        User clause = new User();
        clause.setUserNo(user.getUserNo());
        User userOne = userService.getOne(new QueryWrapper<>(clause));
        if(userOne != null){
            return false;
        }
        user.setGmtCreate(new Date(System.currentTimeMillis()));
        user.setGmtModified(new Date(System.currentTimeMillis()));
        return userService.save(user);
    }




}

