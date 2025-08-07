package ${package.Controller};

import javax.validation.Valid;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import ${cfg.dto}.${entity}CreateDto;
import ${cfg.dto}.${entity}SearchDto;
import ${cfg.dto}.${entity}UpdateDto;
import ${package.Entity}.${entity};
import ${package.Service}.${entity}Service;
import ${cfg.vo}.${entity}DetailVo;
import ${cfg.vo}.${entity}PageVo;
import com.wiki.utils.ExcelUtil;

<#if !restControllerStyle?? || !restControllerStyle>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import javax.annotation.Resource;
import com.wiki.core.page.PageResult;
import com.wiki.core.model.CommonResult;
import ${package.Service}.${entity}Service;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${package.Controller}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} 控制器
* @version 1.0
*/
@Slf4j
<#if restControllerStyle?? && restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName?length gt 0>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle?? && controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@RequiredArgsConstructor
<#if kotlin?? && kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${entity}Service ${table.entityPath}Service;

    /**
    * 新增
    *
    * @param createDto 创建dto
    * @return id
    */
    @PostMapping
    public CommonResult<Long> create(@RequestBody @Valid ${entity}CreateDto createDto) {
        return CommonResult.success(${table.entityPath}Service.create(createDto));
    }

    /**
    * 更新
    *
    * @param updateDto 更新dto
    * @return true/false
    */
    @PutMapping
    public CommonResult<Boolean> update(@RequestBody @Valid ${entity}UpdateDto updateDto) {
        ${table.entityPath}Service.update(updateDto);
        return CommonResult.success(true);
    }

    /**
    * 删除
    *
    * @param id id
    * @return true/false
    */
    @DeleteMapping
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        ${table.entityPath}Service.delete(id);
        return CommonResult.success(true);
    }

    /**
    * 查询详情
    *
    * @param id id
    * @return vo
    */
    @GetMapping
    public CommonResult<${entity}DetailVo> get(@RequestParam("id") Long id) {
        ${entity} ${table.entityPath} = ${table.entityPath}Service.get(id);
        return CommonResult.success(BeanUtil.copyProperties(${table.entityPath}, ${entity}DetailVo.class));
    }

    /**
    * 分页查询
    *
    * @param searchDto 分页Dto
    * @return pageResult
    */
    @GetMapping("/page")
    public CommonResult<PageResult<${entity}PageVo>> page(@Valid ${entity}SearchDto searchDto) {
        PageResult<${entity}> page = ${table.entityPath}Service.page(searchDto);
        PageResult<${entity}PageVo> result = new PageResult<>();
        result.setTotal(page.getTotal());
        result.setList(BeanUtil.copyToList(page.getList(), ${entity}PageVo.class));
        return CommonResult.success(result);
    }

    /**
    * 导出
    *
    * @param searchDto 导出dto
    * @param response response
    * @throws IOException IO异常
    */
    @GetMapping("/export")
    public void exportExcel(@Valid ${entity}SearchDto searchDto, HttpServletResponse response) throws IOException {
        ExcelUtil.write(response, "${entity}PageVo.xls", "数据", ${entity}PageVo.class,
        BeanUtil.copyToList(${table.entityPath}Service.page(searchDto).getList(), ${entity}PageVo.class));
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
        List<${entity}CreateDto> read = ExcelUtil.read(file, ${entity}CreateDto.class);
        // do something
        return CommonResult.success(true);
    }
}
</#if>