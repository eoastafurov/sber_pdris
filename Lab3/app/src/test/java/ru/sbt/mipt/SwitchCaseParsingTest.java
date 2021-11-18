package ru.sbt.mipt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchCaseParsingTest {
    @Test
    public void testConstructTypeOfPersonAreEqualsIndividual() {
        SwitchCaseParsing parser = new SwitchCaseParsing();
        PersonIndividual person = (PersonIndividual) parser.createPerson("individual.json");
        assertEquals(person.getClientType(), ClientType.INDIVIDUAL);
    }

    @Test
    public void testConstructTypeOfPersonAreEqualsLegalEntity() {
        SwitchCaseParsing parser = new SwitchCaseParsing();
        PersonLegalEntity person = (PersonLegalEntity) parser.createPerson("legal_entity.json");
        assertEquals(person.getClientType(), ClientType.LEGAL_ENTITY);
    }

    @Test
    public void testConstructTypeOfPersonAreEqualsHolding() {
        SwitchCaseParsing parser = new SwitchCaseParsing();
        PersonHolding person = (PersonHolding) parser.createPerson("holding.json");
        assertEquals(person.getClientType(), ClientType.HOLDING);
    }

}