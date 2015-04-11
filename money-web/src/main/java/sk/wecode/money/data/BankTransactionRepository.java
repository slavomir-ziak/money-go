package sk.wecode.money.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Slafko Žiak on 28.3.2015.
 */
public interface BankTransactionRepository extends CrudRepository<BankTransaction, Long> {

    @Query("select t from BankTransaction t where category is null ")
    List<BankTransaction> findNoncategorisedBankTransactions();

    List<BankTransaction> findByCategory(String category);
}
