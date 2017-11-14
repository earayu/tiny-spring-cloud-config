package cn.eovie.environment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 *
 * 一个简单的POJO，可以看成一个配置文件的DTO
 *
 * Created by earayu on 2017/11/13.
 */
public class PropertySourceDTO {

    /**
     * 配置文件名
     */
    private String name;

    /**
     * 配置文件的key-value
     */
    private Map<?, ?> source;

    @JsonCreator
    public PropertySourceDTO(@JsonProperty("name") String name,
                             @JsonProperty("source") Map<?, ?> source) {
        this.name = name;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public Map<?, ?> getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "PropertySourceDTO [name=" + name + "]";
    }


}
