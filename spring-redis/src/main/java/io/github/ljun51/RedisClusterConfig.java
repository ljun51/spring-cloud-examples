package io.github.ljun51;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Redis集群配置
 *
 * @author lijun <ljun51@outlook.com>
 * @create 2017-03-15 1:53 PM
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.sentinel")
public class RedisClusterConfig {

    String master;

    List<String> nodes;

    String password;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
