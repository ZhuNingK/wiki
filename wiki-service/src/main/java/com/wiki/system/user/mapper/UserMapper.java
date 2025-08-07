package com.wiki.system.user.mapper;

import com.wiki.system.user.entity.User;
import com.wiki.system.user.dto.UserSearchDto;
import com.wiki.mybatis.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import com.wiki.core.page.PageResult;
import com.wiki.mybatis.LambdaQueryWrapperX;


/**
* @BelongsProject: wiki
* @BelongsPackage: com.wiki.system.user.mapper
* @Author zhuningkang
* @CreateTime 2025-08-07 20:36:34
* @Description: sys_user Mapper 接口
* @version 1.0
*/
@Mapper
public interface UserMapper extends BaseMapperX<User> {

    default PageResult<User> selectPage(UserSearchDto searchDto) {
        return selectPage(searchDto, new LambdaQueryWrapperX<User>());
    }
}
