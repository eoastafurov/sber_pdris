package ru.sbt.mipt;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonIndividualTest {
    private String parseArgsToJsonString(String name, int age, boolean married, String company) {
        return "{\"name\":\"" + name + "\",\"age\":" + age + ",\"married\":" + married
                + ",\"clientType\":\"INDIVIDUAL\",\"company\":\"" + company + "\"}";
    }

    @Test
    public void testConstructFromJsonOnce() {
        String jsonString = parseArgsToJsonString("Igor", 41, false, "mipt");
        PersonIndividual person = new PersonIndividual(jsonString);

        assertEquals(person.getJson(), jsonString);
    }

    @Test
    public void testEquals() {
        String firstJsonString = parseArgsToJsonString("Igor", 41, false, "mipt");
        String secondJsonString = parseArgsToJsonString("Masha", 27, true, "sber");

        PersonIndividual firstPerson = new PersonIndividual(firstJsonString);
        PersonIndividual secondPerson = new PersonIndividual(secondJsonString);
        PersonIndividual copyOfFirstPerson = new PersonIndividual(firstJsonString);

        assertEquals(copyOfFirstPerson, firstPerson);
    }

    @Test
    public void testHashEqualsContract() {
        String firstJsonString = parseArgsToJsonString("Igor", 41, false, "mipt");

        PersonIndividual firstPerson = new PersonIndividual(firstJsonString);
        PersonIndividual copyOfFirstPerson = new PersonIndividual(firstJsonString);

        assertEquals(copyOfFirstPerson.hashCode(), firstPerson.hashCode());
    }
}