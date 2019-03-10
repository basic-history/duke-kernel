package io.github.pleuvoir.configcenter;

/**
 * 配置监听器
 * 
 */
public interface ConfigurationListener {

	void trigger(ConfigChangeEvent event);
}
