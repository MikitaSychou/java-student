package com.innowise.dao.implementations;

import com.google.gson.Gson;
import com.innowise.dao.interfaces.DataBaseDAO;
import com.innowise.model.DataBase;
import com.innowise.model.Transaction;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import static com.innowise.utils.constants.Constants.DATA_DIRECTORY;



@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DataBaseDaoImpl implements DataBaseDAO {
    @Override
    public DataBase updateDataBase(String dbFileName, List<Transaction> table, Gson gson) {
        final String pathToFile = DATA_DIRECTORY + dbFileName;
        List<Transaction> updatedTable;
        DataBase dataBase = null;
        try(InputStream is = DataBaseDaoImpl.class.getResourceAsStream(pathToFile);
            BufferedReader reader = new BufferedReader((new InputStreamReader(is, StandardCharsets.UTF_8)))) {
            dataBase = gson.fromJson(reader, DataBase.class);
            updatedTable = Stream.concat(dataBase.getData().getTransactions().stream(), table.stream())
                    .collect(Collectors.toList());
            dataBase.getData().setTransactions(updatedTable);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dataBase;
    }

    @Override
    public DataBase loadDataBase(String dbFileName, Gson gson) {
        final String pathToFile = DATA_DIRECTORY + dbFileName;
        DataBase dataBase = null;
        try(InputStream is = DataBaseDaoImpl.class.getResourceAsStream(pathToFile);
            BufferedReader reader = new BufferedReader((new InputStreamReader(is, StandardCharsets.UTF_8)))) {
            dataBase = gson.fromJson(reader, DataBase.class);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dataBase;
    }
}
