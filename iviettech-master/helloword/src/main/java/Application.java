import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import usermanagement.app.ManagementApp;
import usermanagement.configuration.BeanConfiguration;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ManagementApp managementApp = applicationContext.getBean("managementApp", ManagementApp.class);
        managementApp.run();
    }
}
