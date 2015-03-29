package sk.wecode.money.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Slafko Žiak on 28.3.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("classpath:/WEB-INF/spring/appServlet/data.xml")
public class TransactionRepositoryTest  {

    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void testFindByCategory() throws Exception {
        System.out.println(transactionRepository.findUnassignedCategories());
    }
}