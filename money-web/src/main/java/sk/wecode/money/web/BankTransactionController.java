package sk.wecode.money.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.wecode.money.data.BankTransaction;
import sk.wecode.money.data.BankTransactionRepository;

import java.util.List;

/**
 * Created by Slafko Žiak on 11.4.2015.
 */
@RestController
public class BankTransactionController {

    @Autowired
    BankTransactionRepository bankTransactionRepository;

    @RequestMapping(value = "/NoncategorisedBankTransactions", method = RequestMethod.GET)
    public List<BankTransaction> listNoncategorisedBankTransactions() {
        return bankTransactionRepository.findNoncategorisedBankTransactions();
    }

    @RequestMapping(value = "/BankTransaction/{id}", method = RequestMethod.POST)
    public BankTransaction updateBankTransaction(@PathVariable Long id,
                                                 @RequestBody BankTransaction bankTransaction) {
        return bankTransactionRepository.save(bankTransaction);
    }

    @RequestMapping(value = "/BankTransaction", method = RequestMethod.POST)
    public BankTransaction createBankTransaction(@RequestBody BankTransaction bankTransaction) {
        return bankTransactionRepository.save(bankTransaction);
    }


}
