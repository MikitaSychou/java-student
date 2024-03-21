package com.innowise.utils.configs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innowise.utils.deserializers.LocalDateDeserializer;
import com.innowise.utils.serializers.LocalDateSerializer;
import java.time.LocalDate;

public class GsonConfig {
    private GsonConfig() {

    }

    public static Gson createGsonInstance() {
       return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .create();
    }
}
