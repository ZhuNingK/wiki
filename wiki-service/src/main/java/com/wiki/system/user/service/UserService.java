package com.wiki.system.user.service;

import com.wiki.system.user.entity.User;
import com.wiki.system.user.dto.UserCreateDto;
import com.wiki.system.user.dto.UserUpdateDto;
import com.wiki.system.user.dto.UserSearchDto;
import com.wiki.core.page.PageResult;

/**
* @BelongsProject: wiki
* @BelongsPackage: com.wiki.system.user.service
* @Author zhuningkang
* @CreateTime 2025-08-07 20:36:34
* @Description: sys_user Service 接口
* @version 1.0
*/
public interface UserService {

    /**
    * 新建
    *
    * @param createDto 新建Dto
    * @return id
    */
    Long create(UserCreateDto createDto);

    /**
    * 更新
    *
    * @param updateDto 更新Dto
    */
    void update(UserUpdateDto updateDto);

    /**
    * 删除
    *
    * @param id id
    */
    void delete(Long id);

    /**
    * 查询单个
    *
    * @param id id
    * @return po
    */
    User getDetail(Long id);

    /**
    * 分页查询
    *
    * @param searchDto 分页Dto
    * @return pageResult
    */
    PageResult<User> page(UserSearchDto searchDto);

}