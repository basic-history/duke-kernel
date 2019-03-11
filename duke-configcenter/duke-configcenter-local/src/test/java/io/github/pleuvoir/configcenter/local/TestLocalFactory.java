package io.github.pleuvoir.configcenter.local;

import java.util.concurrent.TimeUnit;

import io.github.pleuvoir.configcenter.ConfigChangeEvent;
import io.github.pleuvoir.configcenter.ConfigConstants;
import io.github.pleuvoir.configcenter.ConfigurationListener;
import io.github.pleuvoir.configcenter.DynamicConfig;
import io.github.pleuvoir.configcenter.DynamicConfigFactory;
import io.github.pleuvoir.core.URL;
import io.github.pleuvoir.core.extension.ExtensionLoader;

public class TestLocalFactory {

	public static void main(String[] args) throws InterruptedException {
		
		
		String defaultExtensionName = ExtensionLoader.getExtensionLoader(DynamicConfigFactory.class).getDefaultExtensionName();
		System.out.println("默认动态配置：" + defaultExtensionName);
		DynamicConfigFactory dynamicConfigFactory = ExtensionLoader.getExtensionLoader(DynamicConfigFactory.class).getAdaptiveExtension();
		
		URL url = new URL("p", "1.2.3.4", 1010, "path").addParameter("config.key", "local").
				addParameter(ConfigConstants.CONFIG_NAME_KEY, "test.properties");
		DynamicConfig dynamicConfig = dynamicConfigFactory.get(url); 
		dynamicConfig.addListener(new ConfigurationListener() {
			@Override
			public void trigger(ConfigChangeEvent event) {
			System.out.println("文件刷新了。。");
			System.out.println(dynamicConfig.toString());
			}
		});
		
		for(;;){
			TimeUnit.SECONDS.sleep(5);
		}
	}
	
	
}
