package cn.eovie.environment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by earayu on 2017/11/13.
 */
public class EnvironmentDTO {

    private String name;

    private String[] profiles = new String[0];

    private String label;

    private List<PropertySourceDTO> propertySources = new ArrayList<>();

    private String version;

    private String state;

    public EnvironmentDTO(String name, String... profiles) {
        this(name, profiles, "master", null, null);
    }

    public EnvironmentDTO(EnvironmentDTO env) {
        this(env.getName(), env.getProfiles(), env.getLabel(), env.getVersion(), env.getState());
    }

    @JsonCreator
    public EnvironmentDTO(@JsonProperty("name") String name,
                          @JsonProperty("profiles") String[] profiles,
                          @JsonProperty("label") String label,
                          @JsonProperty("version") String version,
                          @JsonProperty("state") String state) {
        super();
        this.name = name;
        this.profiles = profiles;
        this.label = label;
        this.version = version;
        this.state = state;
    }

    public void add(PropertySourceDTO propertySourceDTO) {
        this.propertySources.add(propertySourceDTO);
    }

    public void addAll(List<PropertySourceDTO> propertySourceDTOS) {
        this.propertySources.addAll(propertySourceDTOS);
    }

    public void addFirst(PropertySourceDTO propertySourceDTO) {
        this.propertySources.add(0, propertySourceDTO);
    }

    public List<PropertySourceDTO> getPropertySources() {
        return propertySources;
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

    public String[] getProfiles() {
        return profiles;
    }

    public void setProfiles(String[] profiles) {
        this.profiles = profiles;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EnvironmentDTO [name=" + name + ", profiles=" + Arrays.asList(profiles)
                + ", label=" + label + ", propertySourceDTOS=" + propertySources
                + ", version=" + version
                + ", state=" + state + "]";
    }

}
