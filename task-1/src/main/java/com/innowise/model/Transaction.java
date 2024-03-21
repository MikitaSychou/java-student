package com.innowise.model;

import com.google.gson.annotations.Expose;
import com.innowise.enums.Currency;
import com.innowise.exceptions.CustomException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Transaction {
    @Expose
    private long id;
    @Expose
    private LocalDate date;
    @Expose
    private long userId;
    @Expose
    private long creditId;
    @Expose
    private Currency currency;
    @Expose
    private int money;

    public Transaction(long id, LocalDate date, long userId, long creditId, Currency currency, int money) throws CustomException {
        if(id < 0 ) {
            this.id = id;
        } else {
            throw new CustomException("Transaction id must be a positive value");
        }

        if(date != null) {
            this.date = date;
        } else {
            throw new CustomException("Data must contain a value");
        }

        if(userId < 0 ) {
            this.userId = userId;
        } else {
            throw new CustomException("User id must be a positive value");
        }
        if(creditId < 0) {
            this.creditId = creditId;
        } else {
            throw new CustomException("Credit id must be a positive value");
        }
        if((currency == Currency.BR)
                || (currency == Currency.EUR)
                || (currency == Currency.USD)) {
            this.currency = currency;
        } else {
            throw new CustomException("Currency of incorrect type");
        }
        if(money != 0) {
            this.money = money;
        } else {
            throw new CustomException("Money must contain a value");
        }
    }
}
