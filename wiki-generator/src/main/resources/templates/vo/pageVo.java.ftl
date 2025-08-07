package ${cfg.vo};

<#-- 导入类 -->
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
* @Description: ${table.name} page vo 类
* @version 1.0
*/
<#if entityLombokModel?? && entityLombokModel>
@Data
@NoArgsConstructor
@AllArgsConstructor
</#if>
<#if springdoc?? && springdoc>
@Schema(name = "${entity}PageVo", description = "${table.comment!}")
<#elseif swagger?? && swagger>
@ApiModel(value = "${entity}PageVo 对象", description = "${table.comment!}")
</#if>
<#if entitySerialVersionUID?? && entitySerialVersionUID>
public class ${entity}PageVo implements Serializable {
<#else>
public class ${entity}PageVo {
</#if>

<#if entitySerialVersionUID?? && entitySerialVersionUID>
private static final long serialVersionUID = 1L;
</#if>
<#-- 字段循环：仅主键字段 -->
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
}