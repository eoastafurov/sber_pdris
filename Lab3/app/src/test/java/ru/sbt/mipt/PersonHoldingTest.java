package ru.sbt.mipt;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonHoldingTest {
    private String parseArgsToJsonString(String name, String headquarterCity, int first_inn, int second_inn) {
        return "{\"name\":\"" + name + "\",\"headquarterCity\":\"" + headquarterCity
                + "\",\"members\":[{\"name\":\"Matreshka\",\"inn\":" + first_inn
                + ",\"clientType\":\"LEGAL_ENTITY\",\"isSanctioned\":true},{\"name\":\"Perekrestok\",\"inn\":"
                + second_inn + ",\"clientType\":\"LEGAL_ENTITY\",\"isSanctioned\":true}]}";
    }

    @Test
    public void testConstructFromJsonOnce() {
        String jsonString = parseArgsToJsonString(
                "Prtk",
                "Saint.P",
                353453,
                42423423);
        PersonHolding person = new PersonHolding(jsonString);
        assertEquals(person.getJson(), jsonString);
    }

    @Test
    public void testEquals() {
        String firstJsonString = parseArgsToJsonString(
                "Prtk",
                "Saint.P",
                353453,
                42423423);
        String secondJsonString = parseArgsToJsonString(
                "sbt",
                "Moscow",
                798789,
                6543234);

        PersonHolding firstPerson = new PersonHolding(firstJsonString);
        PersonHolding secondPerson = new PersonHolding(secondJsonString);
        PersonHolding copyOfFirstPerson = new PersonHolding(firstJsonString);

        assertEquals(copyOfFirstPerson, firstPerson);
    }

    @Test
    public void testHashEqualsContract() {
        String firstJsonString = parseArgsToJsonString(
                "Prtk",
                "Saint.P",
                353453,
                42423423);

        PersonHolding firstPerson = new PersonHolding(firstJsonString);
        PersonHolding copyOfFirstPerson = new PersonHolding(firstJsonString);

        assertEquals(copyOfFirstPerson.hashCode(), firstPerson.hashCode());
    }
}