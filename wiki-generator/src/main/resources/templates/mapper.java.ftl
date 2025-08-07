package ${package.Mapper};

import ${package.Entity}.${entity};
import ${cfg.dto}.${entity}SearchDto;
import ${superMapperClassPackage};
<#if mapperAnnotationClass??>
import ${mapperAnnotationClass.name};
</#if>
import com.wiki.core.page.PageResult;
import com.wiki.mybatis.LambdaQueryWrapperX;


/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${package.Mapper}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} Mapper 接口
* @version 1.0
*/
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
<#if kotlin?? && kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    default PageResult<${entity}> selectPage(${entity}SearchDto searchDto) {
        return selectPage(searchDto, new LambdaQueryWrapperX<${entity}>());
    }
}
</#if>