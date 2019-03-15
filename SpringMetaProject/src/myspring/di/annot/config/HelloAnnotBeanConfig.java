package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"myspring.di.annot"})
public class HelloAnnotBeanConfig {

}
