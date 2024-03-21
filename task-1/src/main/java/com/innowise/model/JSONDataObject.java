package com.innowise.model;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class JSONDataObject {

    @Expose
    private List<User> users;

    @Expose
    private List<Credit> credits;

    @Expose
    private List<Discount> discounts;

    @Expose
    private List<Event> events;

    @Expose
    private List<Transaction> transactions;
}
