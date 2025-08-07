package ${cfg.vo};

<#-- 导入包 -->
<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#-- Jackson only when needed -->
<#assign hasLongField = false>
<#list table.fields as field>
    <#if !field.keyFlag && field.propertyType == "Long">
        <#assign hasLongField = true>
    </#if>
</#list>

<#if hasLongField>
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
</#if>

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
* @BelongsPackage: ${cfg.vo}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} detail vo 类
* @version 1.0
*/
<#if entityLombokModel?? && entityLombokModel>
@Data
@NoArgsConstructor
@AllArgsConstructor
</#if>
<#if springdoc?? && springdoc>
@Schema(name = "${entity}", description = "${table.comment!}")
<#elseif swagger?? && swagger>
@ApiModel(value = "${entity} 对象", description = "${table.comment!}")
</#if>
<#if entitySerialVersionUID?? && entitySerialVersionUID>
public class ${entity} implements Serializable {
<#else>
public class ${entity}DetailVo {
</#if>
<#if entitySerialVersionUID?? && entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

<#-- 字段定义：只生成非主键字段 -->
<#list table.fields as field>

    <#if !field.keyFlag>
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
    <#if field.propertyType == "Long">
    @JsonSerialize(using = ToStringSerializer.class)
    </#if>
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>

<#-- 如果不启用 Lombok，补充 getter/setter -->
<#if !entityLombokModel?? || !entityLombokModel>
<#list table.fields as field>
<#if !field.keyFlag>
    public ${field.propertyType} get${field.capitalName}() {
        return ${field.propertyName};
    }

    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        this.${field.propertyName} = ${field.propertyName};
    }
</#if>
</#list>
</#if>
}