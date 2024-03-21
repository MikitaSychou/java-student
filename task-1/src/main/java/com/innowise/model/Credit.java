package com.innowise.model;

import com.google.gson.annotations.Expose;
import com.innowise.enums.Period;
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
public class Credit {

    @Expose
    private Long id;
    @Expose
    private Long userId;
    @Expose
    private LocalDate date;
    @Expose
    private Period period;
    @Expose
    private int money;
    @Expose
    private double rate;

    public Credit(Long id, Long userId, LocalDate date, Period period, int money, double rate) throws CustomException {
        this.id = id;
        this.userId = userId;
        this.date = date;
        if((period == Period.DAY)
                || (period == Period.WEEK)
                || (period == Period.MONTH)
                || (period == Period.YEAR)) {
            this.period = period;
        } else {
            throw new CustomException("Incorrect period type");
        }
        this.money = money;
        this.rate = rate;
    }
}
