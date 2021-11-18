package ru.sbt.mipt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractEnumParsingTest {
    @Test
    public void testConstructTypeOfPersonAreEqualsIndividual() {
        AbstractEnumParsing parser = new AbstractEnumParsing();
        PersonIndividual person = (PersonIndividual) parser.createPerson("individual.json");
        assertEquals(person.getClientType(), ClientType.INDIVIDUAL);
    }

    @Test
    public void testConstructTypeOfPersonAreEqualsLegalEntity() {
        AbstractEnumParsing parser = new AbstractEnumParsing();
        PersonLegalEntity person = (PersonLegalEntity) parser.createPerson("legal_entity.json");
        assertEquals(person.getClientType(), ClientType.LEGAL_ENTITY);
    }

    @Test
    public void testConstructTypeOfPersonAreEqualsHolding() {
        AbstractEnumParsing parser = new AbstractEnumParsing();
        PersonHolding person = (PersonHolding) parser.createPerson("holding.json");
        assertEquals(person.getClientType(), ClientType.HOLDING);
    }
}