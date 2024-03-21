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
public class Event {
    @Expose
    private Long id;
    @Expose
    private Currency currency;
    @Expose
    private int cost;
    @Expose
    private LocalDate date;

    public Event(Long id, Currency currency, int cost, LocalDate date) throws CustomException {
        this.id = id;
        if((currency == Currency.BR)
                || (currency == Currency.EUR)
                || (currency == Currency.USD)) {
            this.currency = currency;
        } else {
            throw new CustomException("Incorrect currency type");
        }
        this.cost = cost;
        this.date = date;
    }
}
