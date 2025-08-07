package com.wiki.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.model.ClassAnnotationAttributes;
import com.wiki.core.controller.BaseController;
import com.wiki.core.entity.BaseEntity;
import com.wiki.mybatis.BaseMapperX;
import com.wiki.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @BelongsProject: wiki
 * @BelongsPackage: com.wiki.config
 * @Author: zhuningkang
 * @CreateTime: 2025-07-31  14:49:44
 * @Description: 代码生成器配置类
 * @Version: 1.0
 */
@Slf4j
public class CodeGenerator {

    // 生成器配置
    /**
     * 生成器配置 - DB HOST
     */
    private final static String DB_HOST = "106.54.205.33";
    /**
     * 生成器配置 - DB PORT
     */
    private final static Integer DB_PORT = 3306;
    /**
     * 生成器配置 - DB USER
     */
    private final static String DB_USER = "root";
    /**
     * 生成器配置 - DB PASSWORD
     */
    private final static String DB_PASSWORD = "WQO6D9ax#f*QPJup";
    /**
     * 生成器配置 - DB NAME
     */
    private final static String DB_NAME = "wiki_blog";
    /**
     * 生成器配置 - CODE AUTHOR
     */
    private final static String AUTHOR = "zhuningkang";
    /**
     * 生成器配置 - CONTROLLER MODULE NAME
     */
    private final static String CONTROLLER_MODULE_NAME = "wiki-common";
    /**
     * 生成器配置 - MODULE NAME
     */
    private final static String MODULE_NAME = "test";
    /**
     * 生成器配置 - PACKAGE NAME
     */
    private final static String PACKAGE_NAME = "com.wiki";

    /**
     * 生成器配置 - PROJECT NAME
     */
    private final static String PROJECT_NAME = "wiki";

    /**
     * 生成器配置 - TABLE PREFIX
     */
    private final static String TABLE_PREFIX = "sys_,tb_";

    /**
     * 生成器配置 - TABLE NAME
     */
    private final static String[] TABLE_NAMES = {"sys_user"};

    /**
     * 生成器配置 - DIR NAME
     */
    public static void main(String[] args) {
        DataSourceConfig.Builder dataSourceConfig = DbUtil.getDataSourceConfig(DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD);
        // 1.配置数据源
        FastAutoGenerator.create(dataSourceConfig)
                // 2、全局配置
                .globalConfig(builder -> builder
                        // 输出目录
                        .outputDir(CONTROLLER_MODULE_NAME + "/src/main/java")
                        // 设置作者
                        .author(AUTHOR)
                        .disableOpenDir()
                        // .enableKotlin() //开启 kotlin 模式 默认false
                        // .enableSwagger()   // 开启 swagger 模式 默认false
                        .dateType(DateType.TIME_PACK) // 设置时间类型对应策略（默认值），数据库时间类型 到 实体类时间类型 对应策略
                        .commentDate(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))) // 设置注释日期（默认值）,example: () -> LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
                // 3、包配置
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_NAME) // 设置父包名（默认值 com.baomidou）
                            .moduleName(MODULE_NAME) // 设置父包模块名（默认值）
                            .entity("entity") // 设置 Entity 包名（默认值）
                            .service("service") // 设置 Service 包名（默认值）
                            .serviceImpl("service.impl") // 置 Service Impl 包名（默认值）设
                            .mapper("mapper") // 设置 Mapper 包名（默认值）
                            .xml("mapper") // 设置 Mapper XML 包名（默认值）
                            .controller("controller") // 设置 Controller 包名（默认值）
                            .pathInfo(Collections.singletonMap(OutputFile.xml, CONTROLLER_MODULE_NAME + "/src/main/resources/mapper"));    //配置 mapper.xml 路径信息：项目的 resources 目录下
                })
                // 4.模版配置
                .templateConfig(builder -> {
                    builder.entity("/templates/entity.java")
                            .mapper("/templates/mapper.java")
                            .xml("/templates/mapper.xml")
                            .service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java")
                            .controller("/templates/controller.java");
                })
                //5、策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAMES) // 设置需要生成的数据表名
                            .addTablePrefix(TABLE_PREFIX.split(",")) // 设置过滤表前缀

                            //5.1、实体类策略配置
                            .entityBuilder()
                            .enableFileOverride() // 覆盖entity
                            .superClass(BaseEntity.class)
                            //.superClass("com.wiki.core.entity.BaseEntity") // 设置父类实体类
                            .disableSerialVersionUID() // 禁用生成 serialVersionUID 默认值 true
                            //.disableSerialVersionUID()  // 禁用生成 serialVersionUID 默认值 true
                            //.enableLombok() // 开启 Lombok 默认值:false
                            .enableLombok(new ClassAnnotationAttributes("@Data", "lombok.Data")) // 开启lombok模型（默认 false），会把注解属性都加入进去，无论是否启用GlobalConfig的isKotlin()，同时get,set,toString都将不会生成，需自行控制添加
                            .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解 默认值 false
                            //.logicDeleteColumnName("deleted")   // 逻辑删除字段名
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    // 数据库表字段映射到实体的命名策略：下划线转驼峰命
                            // .addSuperEntityColumns("creator", "create_time", "updater", "update_time")
                            // .addTableFills(
                            //  new Column("creator", FieldFill.INSERT),
                            //  new Column("updater", FieldFill.INSERT_UPDATE)
                            // )   // 添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                            .formatFileName("%s")

                            //5.2、Mapper策略配置
                            .mapperBuilder()
                            .enableFileOverride() // 覆盖mapper
                            .superClass(BaseMapperX.class)   // 设置父类
                            .mapperAnnotation(org.apache.ibatis.annotations.Mapper.class)      // 开启 @Mapper 注解
                            // .enableBaseResultMap() //启用 BaseResultMap 生成
                            .formatMapperFileName("%sMapper")   // 格式化 mapper 文件名称
                            .formatXmlFileName("%sMapper") // 格式化 Xml 文件名称

                            //5.3、service 策略配置
                            .serviceBuilder()
                            .enableFileOverride() // 覆盖service
                            .formatServiceFileName("%sService") // 格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl

                            //5.4、Controller策略配置
                            .controllerBuilder()
                            .enableFileOverride() // 覆盖controller
                            .enableRestStyle()  // 开启生成 @RestController 控制器
                            .superClass(BaseController.class)
                            //.enableHyphenStyle() //开启驼峰转连字符 默认false
                            .formatFileName("%sController"); // 格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                })
                //6、自定义配置
                .injectionConfig(consumer -> {
                    Map<String, Object> customMap = new HashMap<>();
                    customMap.put("projectName", PROJECT_NAME);
                    customMap.put("dto", PACKAGE_NAME + "." + MODULE_NAME + ".dto");
                    customMap.put("vo", PACKAGE_NAME + "." + MODULE_NAME + ".vo");
                    consumer.customMap(customMap);

                    List<CustomFile> customFiles = new ArrayList<>();
                    // 增加dto类
                    customFiles.add(new CustomFile.Builder().packageName("dto").fileName("CreateDto.java")
                            .templatePath("/templates/dto/createDto.java.ftl").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().packageName("dto").fileName("UpdateDto.java")
                            .templatePath("/templates/dto/updateDto.java.ftl").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().packageName("dto").fileName("DeletedDto.java")
                            .templatePath("/templates/dto/deletedDto.java.ftl").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().packageName("dto").fileName("SearchDto.java")
                            .templatePath("/templates/dto/searchDto.java.ftl").enableFileOverride().build());
                    // 增加vo类
                    customFiles.add(new CustomFile.Builder().packageName("vo").fileName("DetailVo.java")
                            .templatePath("/templates/vo/detailVo.java.ftl").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().packageName("vo").fileName("ListVo.java")
                            .templatePath("/templates/vo/listVo.java.ftl").enableFileOverride().build());
                    customFiles.add(new CustomFile.Builder().packageName("vo").fileName("PageVo.java")
                            .templatePath("/templates/vo/pageVo.java.ftl").enableFileOverride().build());

                    // 增加convert类
                    consumer.customFile(customFiles);

                })

                // 6、选择模板引擎
                // 设置使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                // 7、执行
                .execute();
        log.info("代码生成完成。");

    }

}
