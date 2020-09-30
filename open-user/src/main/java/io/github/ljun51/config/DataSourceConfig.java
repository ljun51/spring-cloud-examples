package io.github.ljun51.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
//@EnableConfigurationProperties
//@EnableAutoConfiguration
@MapperScan(basePackages = "io.github.ljun51.mapper", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "userDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "stomp.datasource.druid")
    public DruidDataSource userDataSource() {
        return new DruidDataSource();
    }

    @Bean(name="userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(userDataSource());
        bean.setTypeAliasesPackage("io.github.ljun51.mapper");
        try {
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate userSqlSessionTemplate() {
        return new SqlSessionTemplate(userSqlSessionFactory());
    }
}
