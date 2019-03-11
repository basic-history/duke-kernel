package io.github.pleuvoir.configcenter;

import io.github.pleuvoir.core.URL;
import io.github.pleuvoir.core.extension.Adaptive;
import io.github.pleuvoir.core.extension.SPI;

@SPI("local")
public interface DynamicConfigFactory {

	@Adaptive({"config.key"})
	DynamicConfig get(URL url);
}
