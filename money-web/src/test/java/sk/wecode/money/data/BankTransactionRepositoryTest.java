package sk.wecode.money.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Slafko Žiak on 28.3.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration("classpath:/WEB-INF/spring/data.xml")
public class BankTransactionRepositoryTest {

    @Autowired
    BankTransactionRepository bankTransactionRepository;

    @Test
    public void testCreateAndFindByCategory() throws Exception {
        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setData("asdf");
        bankTransaction.setAmount(BigDecimal.valueOf(1.1));
        bankTransactionRepository.save(bankTransaction);

        System.out.println(bankTransaction);
        System.out.println(bankTransactionRepository.findNoncategorisedBankTransactions());

        Assert.isTrue(bankTransactionRepository.findNoncategorisedBankTransactions().size() > 0);

        BankTransaction bankTransaction1 = bankTransactionRepository.findNoncategorisedBankTransactions().get(0);

        bankTransaction1.setCategory("groceries");

        bankTransactionRepository.save(bankTransaction1);

    }

    @Test
    public void testUpdateCategory(){
        List<BankTransaction> groceries = bankTransactionRepository.findByCategory("groceries");
        Assert.notEmpty(groceries);
        System.out.println(groceries);
    }



}