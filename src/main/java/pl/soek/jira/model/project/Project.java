package pl.soek.jira.model.project;

import java.util.Map;

public class Project {
    String expand;
    String self;
    String id;
    String key;
    String name;
    Map<String, String> avatarUrls;
    String projectTypeKey;
    boolean simplified;
    String style;
    String isPrivate;
    Map<String, String> properties;
    String entityId;
    String uuid;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(Map<String, String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getProjectTypeKey() {
        return projectTypeKey;
    }

    public void setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    }

    public boolean isSimplified() {
        return simplified;
    }

    public void setSimplified(boolean simplified) {
        this.simplified = simplified;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        isPrivate = isPrivate;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
