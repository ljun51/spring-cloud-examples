package io.github.ljun51.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.jta-user")
public class JTAUserConfig {

    @Value("${xa-properties.url}")
    private String url;

    @Value("${xa-properties.user}")
    private String user;

    @Value("${xa-properties.password}")
    private String password;

    @Value("${xa-data-source-class-name}")
    private String xaDataSourceClassName;

    @Value("${unique-resource-name}")
    private String uniqueResourceName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXaDataSourceClassName() {
        return xaDataSourceClassName;
    }

    public void setXaDataSourceClassName(String xaDataSourceClassName) {
        this.xaDataSourceClassName = xaDataSourceClassName;
    }

    public String getUniqueResourceName() {
        return uniqueResourceName;
    }

    public void setUniqueResourceName(String uniqueResourceName) {
        this.uniqueResourceName = uniqueResourceName;
    }
}
