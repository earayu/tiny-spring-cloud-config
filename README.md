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