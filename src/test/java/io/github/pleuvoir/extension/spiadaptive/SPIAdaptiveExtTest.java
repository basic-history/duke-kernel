package io.github.pleuvoir.extension.spiadaptive;

import io.github.pleuvoir.URL;
import io.github.pleuvoir.extension.ExtensionLoader;

public class SPIAdaptiveExtTest {

	/*
	 * 如果实现类有多个被@Adaptive标记，则会返回第一个，可以考虑增加一个优先级来配置
	 * 此时不会生成动态代码，所以url中不用增加动态参数
	 * 
	 * @SPI("impl2") 虽然设置了默认值，但依然走第一个发现的@Adaptive标记类
	 */
	
	public static void main(String[] args) {
		SPIAdaptiveExt sPIAdaptiveExt = ExtensionLoader.getExtensionLoader(SPIAdaptiveExt.class).getAdaptiveExtension();
		System.out.println(sPIAdaptiveExt instanceof io.github.pleuvoir.extension.spiadaptive.SPIAdaptiveExtImpl);
		
		URL url = new URL("p", "1.2.3.4", 1010, "path");
		
		sPIAdaptiveExt.echo2(url, null);
	}
}
