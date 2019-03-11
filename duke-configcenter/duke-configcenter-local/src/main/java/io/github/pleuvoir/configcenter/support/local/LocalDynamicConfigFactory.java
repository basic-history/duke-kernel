package io.github.pleuvoir.configcenter.support.local;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import io.github.pleuvoir.configcenter.ConfigConstants;
import io.github.pleuvoir.configcenter.DynamicConfig;
import io.github.pleuvoir.configcenter.DynamicConfigFactory;
import io.github.pleuvoir.core.URL;
import io.github.pleuvoir.core.util.StringUtils;

public class LocalDynamicConfigFactory implements DynamicConfigFactory {

	private final ConfigWatcher watcher = new ConfigWatcher();
	private final ConcurrentMap<String, LocalDynamicConfig> configs = new ConcurrentHashMap<>();

	@Override
	public DynamicConfig get(URL url) {
		String configName = url.getParameter(ConfigConstants.CONFIG_NAME_KEY);
		if (StringUtils.isBlank(configName)) {
			throw new IllegalStateException("cannot find config file configName=null");
		}
		return this.doCreate(configName);
	}
	
	private DynamicConfig doCreate(final String name) {
		final LocalDynamicConfig prev = configs.putIfAbsent(name, new LocalDynamicConfig(name));
		final LocalDynamicConfig config = configs.get(name);
		if (prev == null) {
			watcher.addWatch(config);
			config.onConfigModified();
		}
		return config;
	}
}
