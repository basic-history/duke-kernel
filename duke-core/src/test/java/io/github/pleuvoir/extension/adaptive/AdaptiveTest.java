package io.github.pleuvoir.extension.adaptive;

import io.github.pleuvoir.core.URL;
import io.github.pleuvoir.core.extension.ExtensionLoader;

public class AdaptiveTest {

	/*
 	@SPI
	public interface AdaptiveExt {
		@Adaptive({"test1","test2","test3"}) String extName = url.getParameter("test1", url.getParameter("test2", url.getParameter("test3")));
	    String echo(URL url, String s);
		@Adaptive
	    String echo2(URL url, String s);  String extName = url.getParameter("adaptive.ext");
		void print(URL url); // 如果用动态生成的类调用会抛出异常
	}
	  impl1=io.github.pleuvoir.extension.adaptive.AdaptiveExtImpl1
	  impl2=io.github.pleuvoir.extension.adaptive.AdaptiveExtImpl2
	 */
	
	
	public static void main(String[] args) {
		
		AdaptiveExt defaultAdaptiveExt = ExtensionLoader.getExtensionLoader(AdaptiveExt.class).getDefaultExtension();
		System.out.println(defaultAdaptiveExt == null);
		
		//@Adaptive({"test1","test2","test3"}) 
		AdaptiveExt adaptiveExt = ExtensionLoader.getExtensionLoader(AdaptiveExt.class).getAdaptiveExtension();
		System.out.println(adaptiveExt != null);
		
		// 当调用适配方法时会获取实际的实现类
		URL url = new URL("p", "1.2.3.4", 1010, "path").addParameters("test3", "impl2");
		// 将 extName 设置为 impl2
		System.out.println("extName=" + url.getParameter("test1", url.getParameter("test2", url.getParameter("test3"))));
		
		
		// 调用没被适配注解标记的方法会抛出异常
		try {
			adaptiveExt.print(url);
		} catch (UnsupportedOperationException e) {
			//e.printStackTrace();
			// The method public abstract void io.github.pleuvoir.extension.adaptive.AdaptiveExt.print(io.github.pleuvoir.URL) 
			// of interface io.github.pleuvoir.extension.adaptive.AdaptiveExt is not adaptive method!
		}
		
		// 调用适配方法
		adaptiveExt.echo(url, "1");
		
		url = url.addParameter("adaptive.ext", "impl1");
		// 将 extName 设置为 impl1
		System.out.println("extName=" + url.getParameter("adaptive.ext"));
		adaptiveExt.echo2(url, "2");
	}
}
