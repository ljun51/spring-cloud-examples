package io.github.ljun51.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String id;

    @NotEmpty
    @Length(min = 2, max = 32)
    private String username;

    @NotEmpty
    @Length(min = 6, max = 16)
    private String password;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public User() {
    }

    private User(Builder builder) {
        setId(builder.id);
        setUsername(builder.username);
        setPassword(builder.password);
        setCreateTime(builder.createTime);
        setUpdateTime(builder.updateTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public static final class Builder {
        private String id;
        private @NotEmpty @Length(min = 2, max = 32) String username;
        private @NotEmpty @Length(min = 6, max = 16) String password;
        private Date createTime;
        private Date updateTime;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder username(@NotEmpty @Length(min = 2, max = 32) String val) {
            username = val;
            return this;
        }

        public Builder password(@NotEmpty @Length(min = 6, max = 16) String val) {
            password = val;
            return this;
        }

        public Builder createTime(Date val) {
            createTime = val;
            return this;
        }

        public Builder updateTime(Date val) {
            updateTime = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
