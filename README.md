# tiny-spring-cloud-config

spring-cloud-config-client的简单实现

### 使用方法：
将`tiny-spring-cloud-config`部署到本地maven仓库
```
mvn install
```

然后就可以在项目中使用了，方式和使用spring-cloud-config-client一样。注意不要额外引入spring-cloud-config-client的jar包，要不然启动的时候会冲突。
```xml
<dependency>
    <groupId>cn.eovie</groupId>
    <artifactId>tiny-spring-cloud-config</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### 说明

spring-cloud-config-client做的工作非常简单，仅仅是从spring-cloud-config-server处通过HTTP获取一些配置信息，它的总体代码也很少。阅读它的源码，主要问题在于它嵌入了spring cloud框架，代码逻辑、执行顺序比较复杂。

流程主要为：

1. 自动配置（读取application.yml中的配置信息）
2. 启动配置（初始化功能类，加入spring容器）
3. 在springboot启动阶段，PropertySourceBootstrapConfiguration类使用第二部初始化的功能类，从远程服务器拉取配置信息

其中第1和第2部分就是spring-cloud-config-client的源码，第3步是spring-cloud-context的源码。
