package io.github.pleuvoir.extension;

import io.github.pleuvoir.URL;

public class ExtensionLoaderTest {

	public static void main(String[] args) {

		Ext ext = ExtensionLoader.getExtensionLoader(Ext.class).getAdaptiveExtension();

		URL url = new URL("p1", "1.2.3.4", 1010, "path1");
		url = url.addParameters("ext", "impl1");

		// 获取 impl1
		ext.echo2(url, "ha");
		
		// 增加 test3
		url = url.addParameters("test3", "impl2");
		
		// 依次根据  test1","test2","impl2
		ext.echo(url, "ha");
	}
}
