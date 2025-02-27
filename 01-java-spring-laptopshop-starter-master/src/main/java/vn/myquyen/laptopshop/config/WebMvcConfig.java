package vn.myquyen.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");

        String uploadDir = "file:D:/JAVAMVC/01-java-spring-laptopshop-starter-master/01-java-spring-laptopshop-starter-master/src/main/resources/static/images/";
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadDir);

        registry.addResourceHandler("/client/**").addResourceLocations("classpath:/static/client/");
//        registry.addResourceHandler("/client/css/**").addResourceLocations("classpath:/static/client/css/");
//        registry.addResourceHandler("/client/js/**").addResourceLocations("classpath:/static/client/js/");
//        registry.addResourceHandler("/client/img/**").addResourceLocations("classpath:/static/client/img/");
//        registry.addResourceHandler("/client/lib/**").addResourceLocations("classpath:/static/client/lib/");

//        registry.addResourceHandler("/uploads/**").addResourceLocations("file:uploads/");

    }
}
