package ${cfg.dto};

<#-- 导入包 -->
<#list table.importPackages as pkg>
import ${pkg};
</#list>

<#if springdoc?? && springdoc>
import io.swagger.v3.oas.annotations.media.Schema;
<#elseif swagger?? && swagger>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>

<#if entityLombokModel?? && entityLombokModel>
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
</#if>

<#if entitySerialVersionUID?? && entitySerialVersionUID>
import java.io.Serializable;
</#if>

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${cfg.dto}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} Create DTO 类
* @version 1.0
*/
<#if entityLombokModel?? && entityLombokModel>
@Data
@NoArgsConstructor
@AllArgsConstructor
</#if>
<#if springdoc?? && springdoc>
@Schema(name = "${entity}CreateDto", description = "${table.comment!}")
<#elseif swagger?? && swagger>
@ApiModel(value = "${entity}CreateDto 对象", description = "${table.comment!}")
</#if>
<#if entitySerialVersionUID?? && entitySerialVersionUID>
public class ${entity}CreateDto implements Serializable {
<#else>
public class ${entity}CreateDto {
</#if>

<#if entitySerialVersionUID?? && entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
<#-- 字段遍历 -->
<#list table.fields as field>

    <#if field.comment?? && field.comment?length gt 0>
    <#if springdoc?? && springdoc>
    @Schema(description = "${field.comment}")
    <#elseif swagger?? && swagger>
    @ApiModelProperty("${field.comment}")
    <#else>
    /**
    * ${field.comment}
    */
    </#if>
    </#if>
    <#if field.versionField>
    @Version
    </#if>
    <#if field.logicDeleteField>
    @TableLogic
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>

<#-- 如果不启用 Lombok，生成 getter/setter -->
<#if !entityLombokModel?? || !entityLombokModel>
    <#list table.fields as field>

        public ${field.propertyType} get${field.capitalName}() {
        return ${field.propertyName};
        }

        public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        this.${field.propertyName} = ${field.propertyName};
        }
    </#list>
</#if>

<#-- 字段常量 -->
<#if entityColumnConstant?? && entityColumnConstant>
    <#list table.fields as field>

        public static final String ${field.name?upper_case} = "${field.name}";
    </#list>
</#if>

<#-- toString 方法 -->
<#if !entityLombokModel?? || !entityLombokModel>
    @Override
    public String toString() {
    return "${entity}CreateDto{" +
    <#list table.fields as field>
        <#if field?index == 0>
            "${field.propertyName}=" + ${field.propertyName}
        <#else>
            ", ${field.propertyName}=" + ${field.propertyName}
        </#if>
    </#list> +
    "}";
    }
</#if>

}