package ${package.ServiceImpl};

import cn.hutool.core.bean.BeanUtil;
import ${cfg.dto}.${entity}CreateDto;
import ${cfg.dto}.${entity}UpdateDto;
import ${cfg.dto}.${entity}SearchDto;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
<#if table.serviceInterface??>
import ${package.Service}.${table.serviceName};
</#if>
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wiki.core.page.PageResult;

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${package.ServiceImpl}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} 实体类
* @version 1.0
*/
@Slf4j
@Service
public class ${table.serviceImplName} implements ${table.serviceName} {

        @Resource
        private ${entity}Mapper ${table.entityPath}Mapper;

        @Override
        @Transactional(rollbackFor = Exception.class)
        public Long create(${entity}CreateDto createDto) {
            ${entity} ${table.entityPath} = BeanUtil.copyProperties(createDto, ${entity}.class);
            ${table.entityPath}Mapper.insert(${table.entityPath});
            return ${table.entityPath}.getId();
        }

        @Override
        @Transactional(rollbackFor = Exception.class)
        public void update(${entity}UpdateDto updateDto) {
            ${entity} ${table.entityPath} = BeanUtil.copyProperties(updateDto, ${entity}.class);
            ${table.entityPath}Mapper.updateById(${table.entityPath});
        }

        @Override
        @Transactional(rollbackFor = Exception.class)
        public void delete(Long id) {
            ${table.entityPath}Mapper.deleteById(id);
        }

        @Override
        public ${entity} get(Long id) {
            return ${table.entityPath}Mapper.selectById(id);
        }

        @Override
        public PageResult<${entity}> page(${entity}SearchDto searchDto) {
            return ${table.entityPath}Mapper.selectPage(searchDto);
        }

}