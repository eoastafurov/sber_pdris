package ru.sbt.mipt;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonLegalEntityTest {
    private String parseArgsToJsonString(String name, int inn, boolean isSanctioned) {
        return "{\"name\":\"" + name + "\",\"inn\":" + inn
                + ",\"clientType\":\"LEGAL_ENTITY\",\"isSanctioned\":" + isSanctioned + "}";
    }

    @Test
    public void testConstructFromJsonOnce() {
        String jsonString = parseArgsToJsonString("Matreshka", 41554345, true);
        PersonLegalEntity person = new PersonLegalEntity(jsonString);
        assertEquals(person.getJson(), jsonString);
    }

    @Test
    public void testEquals() {
        String firstJsonString = parseArgsToJsonString("Matreshka", 41554345, true);
        String secondJsonString = parseArgsToJsonString("Boltay", 87676887, true);

        PersonLegalEntity firstPerson = new PersonLegalEntity(firstJsonString);
        PersonLegalEntity secondPerson = new PersonLegalEntity(secondJsonString);
        PersonLegalEntity copyOfFirstPerson = new PersonLegalEntity(firstJsonString);

        assertEquals(copyOfFirstPerson, firstPerson);
    }

    @Test
    public void testHashEqualsContract() {
        String firstJsonString = parseArgsToJsonString("Matreshka", 41554345, true);

        PersonLegalEntity firstPerson = new PersonLegalEntity(firstJsonString);
        PersonLegalEntity copyOfFirstPerson = new PersonLegalEntity(firstJsonString);

        assertEquals(copyOfFirstPerson.hashCode(), firstPerson.hashCode());
    }
}