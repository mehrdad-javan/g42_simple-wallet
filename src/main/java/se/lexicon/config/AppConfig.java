package se.lexicon.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.impl.AccountDaoImpl;
import se.lexicon.dao.impl.CustomerDaoImpl;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class AppConfig {

  /*@Bean
  public AccountDao accountDao(){
    return new AccountDaoImpl();
  }

  @Bean
  public CustomerDao customerDao(){
    return new CustomerDaoImpl();
  }*/

}
