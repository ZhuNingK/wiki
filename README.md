# Wiki 基础框架

```Tip
 这是一个基于 Springboot + mybatis-plus + mysql 的 Wiki 基础框架。
```
### 开发环境
```kotlin notebook
1. JDK 11 
2. Spring Boot 2.7.18
3. Mybatis-Plus 3.5.12
4. MySQL 8.0
```
### 项目结构
```kotlin notebook  
├── wiki
│   ├── wiki-admin        # 管理端模块
│   ├── wiki-common       # 公共模块
│   ├── wiki-generator    # 代码生成模块
│   ├── wiki-service      # 服务模块    
│   ├── wiki-auth         # 认证模块
│   ├── wiki-member       # 用户模块
│   └── web               # 前端模块
```
## wiki-generator
```Tip
 代码生成模块，使用 Mybatis-Plus 提供的代码生成器。
```
### 使用方法
1. 在 `wiki-generator` 模块中，修改 `CodeGenerator.java` 中的相关配置文件，启动代码生成器。

## wiki-common
```Tip
 公共模块，包含一些公共的工具类和配置。
```