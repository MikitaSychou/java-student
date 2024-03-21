package com.innowise.dao.interfaces;

import com.google.gson.Gson;
import com.innowise.model.Transaction;
import java.io.IOException;
import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAllTransactions(String dbFileName, Gson gson) throws IOException;

    List<Transaction> getTransactionsByUserId(int userId, String dbFileName, Gson gson);

    List<Transaction> getTransactionsFromDepartmentsFile(String departmentFileName, Gson gson);
}
