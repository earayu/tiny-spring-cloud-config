package cn.eovie.client;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by earayu on 2017/11/13.
 */
@ConfigurationProperties("spring.cloud.config")
public class ConfigClientProperties {

    /**
     * 启用spring cloud config
     */
    private boolean enabled = true;

    /**
     * 当前环境，默认default
     */
    private String profile = "default";

    /**
     * 应用名
     */
    private String name;

    /**
     * 配置文件分支
     */
    private String label;

    /**
     * 配置服务器地址
     */
    private String uri = "http://localhost:8888";

//    public ConfigClientProperties(Environment environment){
//    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
