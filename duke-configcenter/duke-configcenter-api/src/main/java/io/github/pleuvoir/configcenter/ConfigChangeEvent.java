package io.github.pleuvoir.configcenter;

/**
 * 配置变更事件
 *
 */
public class ConfigChangeEvent {
    private final String key;

    private final String value;
    private final ConfigChangeType changeType;

    public ConfigChangeEvent(String key, String value) {
        this(key, value, ConfigChangeType.MODIFIED);
    }

    public ConfigChangeEvent(String key, String value, ConfigChangeType changeType) {
        this.key = key;
        this.value = value;
        this.changeType = changeType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public ConfigChangeType getChangeType() {
        return changeType;
    }

}