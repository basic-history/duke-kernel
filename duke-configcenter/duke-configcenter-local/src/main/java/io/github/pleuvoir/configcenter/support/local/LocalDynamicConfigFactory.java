package io.github.pleuvoir.configcenter.support.local;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import io.github.pleuvoir.configcenter.ConfigConstants;
import io.github.pleuvoir.configcenter.DynamicConfig;
import io.github.pleuvoir.configcenter.DynamicConfigFactory;
import io.github.pleuvoir.core.URL;
import io.github.pleuvoir.core.util.StringUtils;

public class LocalDynamicConfigFactory implements DynamicConfigFactory {

	@Override
	public DynamicConfig get(URL url, boolean fastfail) {

		String configName = url.getParameter(ConfigConstants.CONFIG_NAME_KEY);
		if (fastfail && StringUtils.isBlank(configName)) {
			throw new IllegalStateException("cannot find config file configName=null");
		}
		return this.doCreate(configName, fastfail);
	}

	private final ConfigWatcher watcher = new ConfigWatcher();
	private final ConcurrentMap<String, LocalDynamicConfig> configs = new ConcurrentHashMap<>();

	private DynamicConfig doCreate(final String name, final boolean fastfail) {
		final LocalDynamicConfig prev = configs.putIfAbsent(name, new LocalDynamicConfig(name, fastfail));
		final LocalDynamicConfig config = configs.get(name);
		if (prev == null) {
			watcher.addWatch(config);
			config.onConfigModified();
		}
		return config;
	}
}
