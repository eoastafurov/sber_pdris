package ru.sbt.mipt;

public enum ClientType {
    INDIVIDUAL {
        public Person createPerson(String jsonString) {
            return new PersonIndividual(jsonString);
        }
    },
    LEGAL_ENTITY {
        public Person createPerson(String jsonString) {
            return new PersonLegalEntity(jsonString);
        }
    },
    HOLDING {
        public Person createPerson(String jsonString) {
            return new PersonHolding(jsonString);
        }
    };

    public abstract Person createPerson(String jsonString);
}
