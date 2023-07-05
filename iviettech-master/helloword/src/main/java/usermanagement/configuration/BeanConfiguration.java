package usermanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import usermanagement.app.ManagementApp;
import usermanagement.repository.IUserRepository;
import usermanagement.repository.UserRepository;
import usermanagement.service.IUserService;
import usermanagement.service.UserService;
import usermanagement.validator.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "usermanagement")
public class BeanConfiguration {
    @Bean
    public IUserService userService(){
        IUserService bean = new UserService();
        return bean;
    }

    @Bean
    public IUserRepository userRepository(){
        IUserRepository bean = new UserRepository();
        return bean;
    }

    @Bean
    public ManagementApp managementApp(){
        ManagementApp bean = new ManagementApp();
        return bean;
    }

    @Bean
    public List<IValidator> validators(){
        List<IValidator> bean = new ArrayList<>();
        bean.add(new ValidateUserId());
        bean.add(new ValidateUserName());
        bean.add(new ValidateUserAge());
        bean.add(new ValidateUserPhone());
        bean.add(new ValidateUserEmail());
        bean.add(new ValidateUserPassword());
        return bean;
    }
}
