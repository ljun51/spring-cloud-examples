package io.github.ljun51.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@MapperScan(basePackages = "io.github.ljun51.mapper.income", sqlSessionTemplateRef = "jtaIncomeSqlSessionTemplate")
public class DataSourceJTAIncomeConfig {

    @Bean
    @ConfigurationProperties(prefix = "stomp.jta.atomikos.datasource.jta-income")
    public DataSource dataSourceJTAIncome() {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public SqlSessionFactory jtaIncomeSqlSessionFactory(@Qualifier("dataSourceJTAIncome") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setTypeAliasesPackage("io.github.ljun51.mapper.income");
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate jtaIncomeSqlSessionTemplate(
            @Qualifier("jtaIncomeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
