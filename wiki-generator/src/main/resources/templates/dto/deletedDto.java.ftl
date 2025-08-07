package ${cfg.dto};

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${cfg.dto}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} 删除 DTO 类
* @version 1.0
*/
@Data
public class ${entity}DeletedDto {

    /**
    * 身份标识
    */
    @NotNull(message = "身份标识不能为空")
    private Long Id;
}
