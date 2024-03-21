package com.innowise.services;

import com.google.gson.Gson;
import com.innowise.enums.Status;
import com.innowise.model.Credit;
import com.innowise.model.DataBase;
import com.innowise.model.FormattedCredit;
import com.innowise.model.Transaction;
import com.innowise.model.User;
import com.innowise.model.settings.Settings;
import com.innowise.utils.configs.GsonConfig;
import com.innowise.utils.deserializers.SettingsDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.innowise.utils.constants.Constants.DELIMITER;

@Getter
@Setter
@NoArgsConstructor
public class CreditService {

    private static int DEFAULT_PAYMENT = 100;

    public List<Transaction> getTransactionList(DataBase dataBase) {
        return new ArrayList<>(dataBase.getData()
                .getTransactions());
    }

    public List<Credit> getCreditList(DataBase dataBase) {
        return new ArrayList<>(dataBase.getData().getCredits());
    }

    public List<User> getUserList(DataBase dataBase) {
        return new ArrayList<>(dataBase.getData().getUsers());
    }


    public List<FormattedCredit> buildCredit(DataBase dataBase) {
        List<User> users = getUserList(dataBase);
        List<Credit> credits = getCreditList(dataBase);

        return credits.stream()
                .map(credit -> getBuild(dataBase, users, credit))
                .collect(Collectors.toList());

    }

    public int sumOfHandledTransactionsByUser(DataBase dataBase, int userId) {
        List<Transaction> transactions = getTransactionList(dataBase);
        return (int) transactions
                .stream()
                .filter((tr) -> tr.getUserId() == userId)
                .count();
    }

    public int getLoanBalance(Credit credit, int payment) {
         return credit.getMoney() - payment;
    }


    public int getPeriod() {
        Gson gson = GsonConfig.createGsonInstance();
        Settings setting = SettingsDeserializer.deserializeSettingsFromJSON(gson);
        return Period.between(LocalDate.from(setting.getSettings().getDateFrom()),
                        LocalDate.from(setting.getSettings().getDateTo()))
                .getYears();
    }


    public Status getStatus(Credit credit, int payment) {
        return (getLoanBalance(credit, DEFAULT_PAYMENT) > 0) ?
            Status.IN_PROGRESS :
                Status.DONE;
    }

    private FormattedCredit getBuild(DataBase dataBase, List<User> users, Credit credit) {
        return FormattedCredit.builder()
                .creditId(credit.getId())
                .userId(credit.getUserId())
                .userName(users.stream()
                        .filter(user -> user.getId() == credit.getUserId())
                        .findFirst()
                        .get().getFullName())
                .handledTransactions(sumOfHandledTransactionsByUser(dataBase, Math.toIntExact(users.stream()
                        .filter(user -> user.getId() == credit.getUserId())
                        .findFirst()
                        .get()
                        .getId())))
                .loanBalance(getLoanBalance(credit, DEFAULT_PAYMENT))
                .creditPeriod(getPeriod())
                .status(getStatus(credit, DEFAULT_PAYMENT))
                .build();
    }

    public void printFormattedCredit(List<FormattedCredit> formattedCredits) {
        formattedCredits.forEach((credit) -> {
            String creditString = String.valueOf(credit.getCreditId()) +
                    DELIMITER +
                    credit.getUserId() +
                    DELIMITER +
                    credit.getUserName() +
                    DELIMITER +
                    credit.getHandledTransactions() +
                    DELIMITER +
                    credit.getLoanBalance() +
                    DELIMITER +
                    credit.getCreditPeriod() +
                    DELIMITER +
                    credit.getStatus() +
                    System.lineSeparator();
            System.out.println(creditString);
        });
    }
}
