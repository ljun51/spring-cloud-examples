# spring-jta

使用JTA处理分布式事务，本示例使用Atomikos事务管理器。

## 使用步骤

### 创建数据库

参见资源目录下的schema.sql脚本，默认2张数据表都不存在数据。

### 启动应用

```
    $ mvn spring-boot:run
```

### 事务正常

访问`http://localhost:8080/income/addincome/1?name=user1&amount=10`，正常在两个数据库各插入一条数据。

### 事务异常

访问`http://localhost:8080/income/addincome/2?name=user2&amount=20`，程序中会抛出一个运行时异常，事务失败，两个库都不会插入数据成功。