import com.yash.service.CustomerService;
import com.yash.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService service = applicationContext.getBean("customerService", CustomerService.class);

        CustomerService service2 = applicationContext.getBean("customerService", CustomerService.class);

        System.out.println("1. > "+ service + "\n2. > "+ service2);
        System.out.println(service.findAll().get(0).getFirstName());
    }
}
