package com.innowise;

import com.google.gson.Gson;
import com.innowise.dao.implementations.DataBaseDaoImpl;
import com.innowise.dao.implementations.TransactionDaoImpl;
import com.innowise.dao.interfaces.DataBaseDAO;
import com.innowise.dao.interfaces.TransactionDAO;
import com.innowise.model.DataBase;
import com.innowise.model.FormattedCredit;
import com.innowise.model.Transaction;
import com.innowise.services.CreditService;
import com.innowise.utils.configs.GsonConfig;
import com.innowise.utils.deserializers.DataBaseSerializer;
import com.innowise.utils.fileSystem.FileSystemUtils;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import static com.innowise.utils.constants.Constants.DB_FILE_NAME;
import static com.innowise.utils.constants.Constants.DB_GOMEL_FILE_NAME;

public class Main {
    public static void main(String[] args) {

         try {
            Gson gson = GsonConfig.createGsonInstance();
            DataBaseDAO dataBaseDAO = new DataBaseDaoImpl();
            TransactionDAO transactions = new TransactionDaoImpl();
            List<Transaction> transactionList = transactions.getTransactionsFromDepartmentsFile(DB_GOMEL_FILE_NAME, gson);
            DataBase updatedDataBase = dataBaseDAO.updateDataBase(DB_FILE_NAME, transactionList, gson);
            DataBaseSerializer.serializeDataBase(gson, updatedDataBase, DB_FILE_NAME);
            FileSystemUtils.flushTheFile(DB_GOMEL_FILE_NAME);
            DataBase dataBase = dataBaseDAO.loadDataBase(DB_FILE_NAME, gson);
            CreditService service = new CreditService();
            List<FormattedCredit> formattedCredit = service.buildCredit(dataBase);
            formattedCredit.sort(Comparator.comparing(FormattedCredit::getLoanBalance));
            service.printFormattedCredit(formattedCredit);
        } catch (IOException e) {
           System.err.println(e.getMessage());
        }
    }}
