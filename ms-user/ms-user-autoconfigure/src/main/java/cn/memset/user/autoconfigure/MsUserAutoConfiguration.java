package cn.memset.user.autoconfigure;

import cn.memset.user.api.feign.UserFeignClient;
import cn.memset.user.api.feign.UserFeignMarker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(UserFeignMarker.class)
@EnableFeignClients(basePackageClasses = UserFeignMarker.class) //UserFeignMarker这个类定义的目的就是标识出 basePackage 是什么，避免写具体的basePackage
@EnableConfigurationProperties(MsUserConfiguration.class)
@Import({UserFeignClient.UserFallbackFactory.class})
public class MsUserAutoConfiguration {

}




