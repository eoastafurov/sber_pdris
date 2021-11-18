package ru.sbt.mipt;
import java.util.ArrayList;
import java.util.List;


public class SwitchCaseParsing implements Parsing {

    @Override
    public Person createPerson(String path) {
        List<String> typeAndJson= StringProcessing.getClientTypeAndJson(path);
        if (typeAndJson.size() != 2) {
            return null;
        }
        ClientType type = ClientType.valueOf(typeAndJson.get(0));
        String jsonString = typeAndJson.get(1);
        return switch (type) {
            case INDIVIDUAL -> new PersonIndividual(jsonString);
            case LEGAL_ENTITY -> new PersonLegalEntity(jsonString);
            case HOLDING -> new PersonHolding(jsonString);
        };
    }
}
