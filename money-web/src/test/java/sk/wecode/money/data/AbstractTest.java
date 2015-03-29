package sk.wecode.money.data;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Slafko Žiak on 29.3.2015.
 */
@Transactional
public abstract class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Configuration
    static class TestConfig {

    }

    @BeforeTransaction
    public void setupData() throws Exception {

        //deleteFromTables("account", "customer");
       // executeSqlScript("classpath:data.sql", false);
    }
}