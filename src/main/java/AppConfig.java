import com.yash.repository.HibernateCustomerRepo;
import com.yash.repository.HibernateCustomerRepoImpl;
import com.yash.service.CustomerService;
import com.yash.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "customerService")
    public CustomerService getCustomerService() {
        CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepo());
        return service;
    }

    @Bean(name = "customerRepo")
    public HibernateCustomerRepo getCustomerRepo(){
        return new HibernateCustomerRepoImpl();
    }
}