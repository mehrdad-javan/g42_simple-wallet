package se.lexicon.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Account;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountDaoTest {

  @Autowired
  AccountDao testObject;

  @BeforeEach
  public void setUp(){
    Account account1= new Account(50.00);
    Account account2= new Account(10.00);
    testObject.create(account1);
    testObject.create(account2);
  }

  @Test
  @DisplayName("test get all method from account dao with result 2")
  public void test_getAll(){
    int actualSize = testObject.findAll().size();
    int expectedSize = 2;

    assertEquals(expectedSize,actualSize);

  }

}
