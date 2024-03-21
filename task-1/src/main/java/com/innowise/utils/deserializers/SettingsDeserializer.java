package com.innowise.utils.deserializers;

import com.google.gson.Gson;
import com.innowise.dao.implementations.TransactionDaoImpl;
import com.innowise.model.settings.Settings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.innowise.utils.constants.Constants.DATA_DIRECTORY;
import static com.innowise.utils.constants.Constants.SETTINGS_FILE_NAME;
import static com.innowise.utils.constants.Constants.TARGET_DIRECTORY;

public class SettingsDeserializer {

    private SettingsDeserializer() {

    }

    public static Settings deserializeSettingsFromJSON(Gson gson) {

        final String settingsFileName = DATA_DIRECTORY + SETTINGS_FILE_NAME;
        Settings settings = null;
        try(InputStream is = TransactionDaoImpl.class.getResourceAsStream(settingsFileName);
            BufferedReader reader = new BufferedReader((new InputStreamReader(is, StandardCharsets.UTF_8)))) {
            settings = gson.fromJson(reader, Settings.class);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return settings;
    }
}
