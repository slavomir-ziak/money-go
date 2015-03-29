package sk.wecode.money.data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Slafko Žiak on 28.3.2015.
 */
@Entity
@Table(name = "BANK_TRANSACTION")
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data;

    private String category;

    private BigDecimal amount;

    public BankTransaction(){}

    public BankTransaction(String data, String category, BigDecimal amount) {
        this.data = data;
        this.category = category;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
