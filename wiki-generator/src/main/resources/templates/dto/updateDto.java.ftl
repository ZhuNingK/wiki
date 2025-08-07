package ${cfg.dto};

import lombok.Data;

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${cfg.dto}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} 更新 DTO 类
* @version 1.0
*/
@Data
public class ${entity}UpdateDto extends ${entity}CreateDto{

    /**
    * id值
    */
    private Long Id;
}
