package com.example.springbootstep04.config;

import com.example.springbootstep04.component.LoginHandleInterceptor;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 类说明:
 * 使用WebMvcConfigurerAdapter可以扩展SpringMvc功能
 *
 * @author : 黄刚
 * @date : 2020/5/5 22:03
 */
//全面接管springMvc
//@EnableWebMvc
//扩展 springMvc
@Configuration
public class MyMvconfig extends WebMvcConfigurerAdapter implements WebServerFactoryCustomizer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/sunvirgo请求来到success页面
        registry.addViewController("/sunvirgo").setViewName("success");
        //super.addViewControllers(registry);
    }

    //所有的WebMvcConfigurerAdapter组件会一起起作用
    @Bean//将组件祖册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源：*.css,*.js
                //springboot已经做好了静态资源映射,然而世纪被拦截了
                //这样对于利用HandlerInterceptor来处理访问权限或其他相关的功能就会受影响，跟踪源码查看原因，是因为spring boot 2.x依赖的spring 5.x版本，
                // 相对于spring boot 1.5.x依赖的spring 4.3.x版本而言，针对资源的拦截器初始化时有区别,
                //从源码当中可以看出，使用spring 5.x时，静态资源也会执行自定义的拦截器，因此在配置拦截器的时候需要指定排除静态资源的访问路径.
                registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login", "/docs/**", "/webjars/**");
                //super.addInterceptors(registry);
            }

        };

        return webMvcConfigurerAdapter;
    }

    /**
     * 方法说明:springboot2.已经改为implements WebServerFactoryCustomizer
     * @author : 黄刚
     * @date : 2020/5/30 11:29
     * @param : [factory]
     * @return : void
     */
    @Override
    public void customize(WebServerFactory factory) {
        ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
            //定制嵌入式servlet容器相关规则
            @Override
            public void customize(Connector connector) {
                connector.setPort(8088);
            }
        });
    }
}
