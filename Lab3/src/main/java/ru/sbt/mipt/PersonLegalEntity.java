package ru.sbt.mipt;

import com.google.gson.Gson;

import java.util.Objects;

public class PersonLegalEntity implements Person{
    private final String name;
    private final int inn;
    private final ClientType clientType;
    private final boolean isSanctioned;

    public PersonLegalEntity(String jsonString) {
        Gson gson = new Gson();
        PersonLegalEntity temp = gson.fromJson(jsonString, PersonLegalEntity.class);
        this.name = temp.name;
        this.inn = temp.inn;
        this.clientType = temp.clientType;
        this.isSanctioned = temp.isSanctioned;
    }

    public PersonLegalEntity (PersonLegalEntity other) {
        this.name = other.name;
        this.inn = other.inn;
        this.clientType = other.clientType;
        this.isSanctioned = other.isSanctioned;
    }

    public PersonLegalEntity(
            String name,
            int inn,
            ClientType clientType,
            boolean isSanctioned) {
        this.name = name;
        this.inn = inn;
        this.clientType = clientType;
        this.isSanctioned = isSanctioned;
    }

    @Override
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public int hashCode() {
        return (((inn * 31) + Objects.hashCode(name) * 31) + Objects.hashCode(clientType) * 31)
                + Objects.hashCode(isSanctioned) * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersonLegalEntity) {
            PersonLegalEntity p = (PersonLegalEntity) obj;
            return this.name.equals(p.name) && this.inn == p.inn && this.clientType == p.clientType
                    && this.isSanctioned == p.isSanctioned;
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
