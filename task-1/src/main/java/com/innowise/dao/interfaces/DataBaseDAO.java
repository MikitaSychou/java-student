package com.innowise.dao.interfaces;

import com.google.gson.Gson;
import com.innowise.model.DataBase;
import com.innowise.model.Transaction;
import java.util.List;

public interface DataBaseDAO {
    DataBase updateDataBase(String dbFileName, List<Transaction> table, Gson gson);

    DataBase loadDataBase(String dbFileName, Gson gson);
}
