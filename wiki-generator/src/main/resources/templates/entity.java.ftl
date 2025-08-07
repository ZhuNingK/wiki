package ${package.Entity};

<#-- 导入包 -->
<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#-- Lombok -->
<#if entityLombokModel?? && entityLombokModel>
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
</#if>

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${package.Entity}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} 实体类
* @version 1.0
*/
<#if entityLombokModel?? && entityLombokModel>
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
</#if>
<#if superEntityClass??>
public class ${entity} extends ${superEntityClass}
<#if activeRecord?? && activeRecord><${entity}></#if> {
<#elseif activeRecord?? && activeRecord>
public class ${entity} extends Model<${entity}> {
<#elseif entitySerialVersionUID?? && entitySerialVersionUID>
public class ${entity} implements Serializable {
<#else>
public class ${entity} {
</#if>

<#-- 字段定义 -->
<#list table.fields as field>
<#-- 跳过 BaseEntity 中已存在的字段 -->
    <#if !(field.propertyName == "id"
    || field.propertyName == "createTime"
    || field.propertyName == "createById"
    || field.propertyName == "createBy"
    || field.propertyName == "updateTime"
    || field.propertyName == "updateById"
    || field.propertyName == "updateBy"
    || field.propertyName == "isDeleted"
    || field.propertyName == "tenantId  "
    || field.propertyName == "version")>
    <#if field.comment?? && field.comment?length gt 0>
    /**
    * ${field.comment}
    */
    </#if>
    <#if field.keyFlag>
    <#if field.keyIdentityFlag>
        @TableId(value = "${field.annotationColumnName}", type = IdType.AUTO)
    <#elseif idType?? && idType?length gt 0>
        @TableId(value = "${field.annotationColumnName}", type = IdType.${idType})
    <#elseif field.convert>
        @TableId("${field.annotationColumnName}")
    </#if>
    <#elseif field.fill??>
    <#if field.convert>
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.${field.fill})
    <#else>
    @TableField(fill = FieldFill.${field.fill})
    </#if>
    <#elseif field.convert>
    @TableField("${field.annotationColumnName}")
    </#if>
    <#if field.versionField>
    @Version
    </#if>
    <#if field.logicDeleteField>
    @TableLogic
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#if>
</#list>

<#-- 字段常量 -->
<#if entityColumnConstant?? && entityColumnConstant>
    <#list table.fields as field>

        public static final String ${field.name?upper_case} = "${field.name}";
    </#list>
</#if>

}