package com.innowise.model;

import com.innowise.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class FormattedCredit {

    private Long creditId;

    private Long userId;

    private String userName;

    private  int handledTransactions;

    private int loanBalance;

    private int creditPeriod;

    private Status status;
}
