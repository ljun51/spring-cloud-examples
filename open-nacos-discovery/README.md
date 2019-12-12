# open-nacos-discovery

## 单机模式 - 用于测试和开发

### 单机模式 - 不保留配置

```
    $ sh startup.sh -m standalone
```

### 单机模式 + mysql

* 安装数据库，版本要求：5.6.5+；如果使用8.0+的数据库，需要修改程序中的数据库驱动，自己重新编译。
* 初始化mysql数据库，数据库初始化文件：nacos-mysql.sql
* 修改conf/application.properties文件，增加支持mysql数据源配置（目前只支持mysql），添加mysql数据源的url、用户名和密码。

下面是mysql8.0.X的配置，比官方新增了一行`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`。

```properties
    spring.datasource.platform=mysql
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    db.num=1
    db.url.0=jdbc:mysql://118.118.116.142:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
    db.user=abc12366
    db.password=Abc@12366
```

## 集群模式

参考[官方集群配置](https://nacos.io/zh-cn/docs/cluster-mode-quick-start.html)