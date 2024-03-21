package com.innowise.dao.implementations;

import com.google.gson.Gson;
import com.innowise.dao.interfaces.TransactionDAO;
import com.innowise.model.DataBase;
import com.innowise.model.Transaction;
import com.innowise.model.TransactionList;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import static com.innowise.utils.constants.Constants.DATA_DIRECTORY;
import static com.innowise.utils.constants.Constants.TARGET_DIRECTORY;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TransactionDaoImpl implements TransactionDAO {
    @Override
    public List<Transaction> getAllTransactions(String dbFileName, Gson gson) {
        final String pathToFile = TARGET_DIRECTORY + dbFileName;
        Path pathToRead= Paths.get(pathToFile);
        List<Transaction> transactionList = null;
        try(Reader reader = Files.newBufferedReader(pathToRead, StandardCharsets.UTF_8)) {
            DataBase dataBase = gson.fromJson(reader, DataBase.class);
            transactionList = dataBase.getData().getTransactions();
        } catch (IOException e) {
           System.err.println(e.getMessage());
        }

        return transactionList;
    }

    @Override
    public List<Transaction> getTransactionsByUserId(int userId, String dbFileName, Gson gson) {
        final String pathToFile = TARGET_DIRECTORY + dbFileName;
        Path pathToRead= Paths.get(pathToFile);
        List<Transaction> transactionsById = null;
        try(Reader reader = Files.newBufferedReader(pathToRead, StandardCharsets.UTF_8)) {
            DataBase dataBase = gson.fromJson(reader, DataBase.class);
            transactionsById = dataBase.getData().getTransactions()
                    .stream()
                    .filter((transaction) -> transaction.getUserId() == userId)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactionsById;
    }

    public List<Transaction> getTransactionsFromDepartmentsFile(String departmentFileName, Gson gson) {
        final String pathToFile = DATA_DIRECTORY + departmentFileName;
        TransactionList transactionList = null;
        try(InputStream is = TransactionDaoImpl.class.getResourceAsStream(pathToFile);
            BufferedReader reader = new BufferedReader((new InputStreamReader(is, StandardCharsets.UTF_8)))) {
            transactionList = gson.fromJson(reader, TransactionList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactionList.getTransactions();
    }
}
