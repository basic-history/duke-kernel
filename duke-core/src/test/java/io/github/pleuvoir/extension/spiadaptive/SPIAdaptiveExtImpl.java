package io.github.pleuvoir.extension.spiadaptive;

import io.github.pleuvoir.core.URL;
import io.github.pleuvoir.core.extension.Adaptive;

@Adaptive
public class SPIAdaptiveExtImpl implements SPIAdaptiveExt {

	@Override
	public String echo(URL url, String s) {
		System.out.println("SPIAdaptiveExtImpl echo..");
		return null;
	}

	@Override
	public String echo2(URL url, String s) {
		System.out.println("SPIAdaptiveExtImpl echo2..");
		return null;
	}

	@Override
	public void print(URL url) {

	}

}
