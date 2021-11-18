package ru.sbt.mipt;

import java.util.ArrayList;
import java.util.List;

public class AbstractEnumParsing implements Parsing {
    @Override
    public Person createPerson(String path) {
        ClientType type = ClientType.HOLDING;
        String jsonString = "";
        try {
            List<String> typeAndJson = StringProcessing.getClientTypeAndJson(path);
            type = ClientType.valueOf(typeAndJson.get(0));
            jsonString = typeAndJson.get(1);
            return type.createPerson(jsonString);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
