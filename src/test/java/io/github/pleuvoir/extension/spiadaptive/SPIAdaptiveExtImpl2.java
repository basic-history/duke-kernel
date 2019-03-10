package io.github.pleuvoir.extension.spiadaptive;

import io.github.pleuvoir.URL;
import io.github.pleuvoir.extension.Adaptive;

@Adaptive
public class SPIAdaptiveExtImpl2 implements SPIAdaptiveExt {

	@Override
	public String echo(URL url, String s) {
		System.out.println("SPIAdaptiveExtImpl2 echo..");
		return null;
	}

	@Override
	public String echo2(URL url, String s) {
		System.out.println("SPIAdaptiveExtImpl2 echo2..");
		return null;
	}

	@Override
	public void print(URL url) {

	}

}
