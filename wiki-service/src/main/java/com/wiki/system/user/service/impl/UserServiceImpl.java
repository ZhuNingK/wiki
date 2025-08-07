package com.wiki.system.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wiki.core.page.PageResult;
import com.wiki.system.user.dto.UserCreateDto;
import com.wiki.system.user.dto.UserSearchDto;
import com.wiki.system.user.dto.UserUpdateDto;
import com.wiki.system.user.entity.User;
import com.wiki.system.user.mapper.UserMapper;
import com.wiki.system.user.service.UserService;
import com.wiki.utils.SnowUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.system.user.service.impl
 * @Author zhuningkang
 * @CreateTime 2025-08-07 20:36:34
 * @Description: sys_user 实体类
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long create(UserCreateDto createDto) {
        User user = BeanUtil.copyProperties(createDto, User.class);
        user.setId(SnowUtil.getSnowflakeNextId());
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserUpdateDto updateDto) {
        User user = BeanUtil.copyProperties(updateDto, User.class);
        userMapper.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public User getDetail(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public PageResult<User> page(UserSearchDto searchDto) {
        return userMapper.selectPage(searchDto);
    }

}