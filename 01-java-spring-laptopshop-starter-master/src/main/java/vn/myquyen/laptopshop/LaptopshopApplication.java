package vn.myquyen.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication

//@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
@SpringBootApplication
public class LaptopshopApplication {
    public static void main(String[] args) {
        ApplicationContext abc = SpringApplication.run(LaptopshopApplication.class, args);
        for (String name : abc.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}

