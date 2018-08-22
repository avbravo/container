package container.driver.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContainerDriverConfiguration {
	
	@Lazy
	@Bean("logger")
	@Scope("prototype")
	public Logger getLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
	}
	
	@Bean("shutdownToken")
	public String getShutdownToken() {
	    return "elmo";
	}
	
	@Bean("port")
	public int getPort() {
	    return Integer.getInteger("wc.port", 8888);
	}
}
