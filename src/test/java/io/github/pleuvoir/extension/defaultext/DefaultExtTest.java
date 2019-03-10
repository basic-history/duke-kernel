package io.github.pleuvoir.extension.defaultext;

import io.github.pleuvoir.extension.ExtensionLoader;

public class DefaultExtTest {

	/*
	 * @SPI("defaultImpl")		
	 * defaultImpl=io.github.pleuvoir.extension.defaultext.DefaultExtImpl
	 */
	
	public static void main(String[] args) {
		
		DefaultExt defaultExt = ExtensionLoader.getExtensionLoader(DefaultExt.class).getDefaultExtension();
		
		System.out.println(defaultExt instanceof io.github.pleuvoir.extension.defaultext.DefaultExtImpl);
	}
}
