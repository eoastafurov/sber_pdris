package ru.sbt.mipt;

import com.google.gson.*;
import java.util.Objects;

public class PersonIndividual implements Person{
    private final String name;
    private final int age;
    private final boolean married;
    private final ClientType clientType;
    private final String company;

    public PersonIndividual(
            String name,
            int age,
            boolean married,
            String company,
            ClientType clientType) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.company = company;
        this.clientType = clientType;
    }

    public PersonIndividual(String jsonString) {
        Gson gson = new Gson();
        PersonIndividual temp = gson.fromJson(jsonString, PersonIndividual.class);
        this.name = temp.name;
        this.age = temp.age;
        this.married = temp.married;
        this.company = temp.company;
        this.clientType = temp.clientType;
    }

    public PersonIndividual(PersonIndividual other) {
        this.name = other.name;
        this.age = other.age;
        this.married = other.married;
        this.company = other.company;
        this.clientType = other.clientType;
    }

    @Override
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public int hashCode() {
        return ((((age * 31) + Objects.hashCode(name) * 31) + Objects.hashCode(company) * 31)
                + Objects.hashCode(married) * 31) + Objects.hashCode(clientType) * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersonIndividual) {
            PersonIndividual p = (PersonIndividual) obj;
            return this.name.equals(p.name) && this.age == p.age && this.married == p.married
                    && this.company.equals(p.company) && this.clientType == p.clientType;
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getName() + " = " + this.getJson();
    }

    @Override
    public ClientType getClientType() {
        return this.clientType;
    }
}
