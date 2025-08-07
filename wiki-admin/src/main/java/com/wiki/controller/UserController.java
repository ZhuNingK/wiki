package com.wiki.controller;

import javax.validation.Valid;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.wiki.system.user.dto.UserCreateDto;
import com.wiki.system.user.dto.UserSearchDto;
import com.wiki.system.user.dto.UserUpdateDto;
import com.wiki.system.user.entity.User;
import com.wiki.system.user.service.UserService;
import com.wiki.system.user.vo.UserDetailVo;
import com.wiki.system.user.vo.UserPageVo;
import com.wiki.utils.ExcelUtil;

import com.wiki.core.controller.BaseController;

import javax.annotation.Resource;

import com.wiki.core.page.PageResult;
import com.wiki.core.model.CommonResult;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * @version 1.0
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.system.user.controller
 * @Author zhuningkang
 * @CreateTime 2025-08-07 20:27:16
 * @Description: sys_user 控制器
 */
@Slf4j
@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 新增
     *
     * @param createDto 创建dto
     * @return id
     */
    @PostMapping("/add")
    public CommonResult<Long> create(@RequestBody @Valid UserCreateDto createDto) {
        return CommonResult.success(userService.create(createDto));
    }

    /**
     * 更新
     *
     * @param updateDto 更新dto
     * @return true/false
     */
    @PostMapping("/update")
    public CommonResult<Boolean> update(@RequestBody @Valid UserUpdateDto updateDto) {
        userService.update(updateDto);
        return CommonResult.success(true);
    }

    /**
     * 删除
     *
     * @param id id
     * @return true/false
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return CommonResult.success(true);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return vo
     */
    @GetMapping("/getDetail")
    public CommonResult<UserDetailVo> getDetail(@RequestParam("id") Long id) {
        User user = userService.getDetail(id);
        return CommonResult.success(BeanUtil.copyProperties(user, UserDetailVo.class));
    }

    /**
     * 分页查询
     *
     * @param searchDto 分页Dto
     * @return pageResult
     */
    @GetMapping("/page")
    public CommonResult<PageResult<UserPageVo>> page(@Valid UserSearchDto searchDto) {
        PageResult<User> page = userService.page(searchDto);
        PageResult<UserPageVo> result = new PageResult<>();
        result.setTotal(page.getTotal());
        result.setList(BeanUtil.copyToList(page.getList(), UserPageVo.class));
        return CommonResult.success(result);
    }

    /**
     * 导出
     *
     * @param searchDto 导出dto
     * @param response  response
     * @throws IOException IO异常
     */
    @GetMapping("/export")
    public void exportExcel(@Valid UserSearchDto searchDto, HttpServletResponse response) throws IOException {
        ExcelUtil.write(response, "UserPageVo.xls", "数据", UserPageVo.class,
                BeanUtil.copyToList(userService.page(searchDto).getList(), UserPageVo.class));
    }

    /**
     * 导入
     *
     * @param file 文件
     * @return 结果
     * @throws IOException IO异常
     */
    @PostMapping("/import")
    public CommonResult<Boolean> importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        List<UserCreateDto> read = ExcelUtil.read(file, UserCreateDto.class);
        // do something
        return CommonResult.success(true);
    }
}
