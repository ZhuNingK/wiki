package ${cfg.dto};

import com.wiki.core.page.PageRequest;
import lombok.Data;

/**
* @BelongsProject: ${projectName}
* @BelongsPackage: ${cfg.dto}
* @Author ${author}
* @CreateTime ${date}
* @Description: ${table.name} 搜索 DTO 类
* @version 1.0
*/
@Data
public class ${entity}SearchDto extends PageRequest {

    /**
    * 搜索词
    */
    private String word;
}