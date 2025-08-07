package ${package.Service};

import ${package.Entity}.${entity};
import ${cfg.dto}.${entity}CreateDto;
import ${cfg.dto}.${entity}UpdateDto;
import ${cfg.dto}.${entity}SearchDto;
import com.wiki.core.page.PageResult;

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${package.Service}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} Service 接口
* @version 1.0
*/
public interface ${table.serviceName} {

    /**
    * 新建
    *
    * @param createDto 新建Dto
    * @return id
    */
    Long create(${entity}CreateDto createDto);

    /**
    * 更新
    *
    * @param updateDto 更新Dto
    */
    void update(${entity}UpdateDto updateDto);

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
    ${entity} get(Long id);

    /**
    * 分页查询
    *
    * @param searchDto 分页Dto
    * @return pageResult
    */
    PageResult<${entity}> page(${entity}SearchDto searchDto);

}