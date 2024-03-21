package com.innowise.utils.deserializers;

import com.google.gson.Gson;
import com.innowise.model.DataBase;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.innowise.utils.constants.Constants.DATA_DIRECTORY;

public class DataBaseSerializer {

    private DataBaseSerializer() {

    }

        public static void serializeDataBase(Gson gson, DataBase dataBase, String dbFileName) {
        final String dataBaseFilePath = DATA_DIRECTORY + dbFileName;
        Path pathToWrite= Paths.get(dataBaseFilePath);
        try(Writer writer = Files.newBufferedWriter(pathToWrite, StandardCharsets.UTF_8)) {
            gson.toJson(dataBase, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
