package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.config.AppConfig;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.service.CustomerService;
import se.lexicon.service.TransactionService;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {

    //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    CustomerService customerService = context.getBean(CustomerService.class);
    Account account = new Account(10.00);
    Customer customer = new Customer("test", "test", "test.test@test.se", account);

    customerService.registerCustomer(customer);

    Account account2 = new Account(50.00);
    Customer customer2 = new Customer("mehrdad", "javan", "ehrdad.javan@lexicon.se", account2);

    customerService.registerCustomer(customer2);


    customerService.getAllCustomers().forEach(System.out::println);
    System.out.println("------------------------");

    TransactionService transactionService = context.getBean(TransactionService.class);
    try {
      transactionService.deposit(2L, 50.00);
    } catch (DataNotFoundException e) {
      System.out.println("Exception: " + e.getMessage());
    }
    System.out.println("------------------------");
    customerService.getAllCustomers().forEach(System.out::println);


  }
}
