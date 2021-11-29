package ru.sbt.mipt;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonHolding implements Person{
    private final String name;
    private final String headquarterCity;
    private final ArrayList<PersonLegalEntity> members;
    public final ClientType clientType;


    public PersonHolding(String jsonString) {
        Gson gson = new Gson();
        PersonHolding temp = gson.fromJson(jsonString, PersonHolding.class);
        this.name = temp.name;
        this.headquarterCity = temp.headquarterCity;
        this.members = temp.members;
        this.clientType = temp.clientType;
    }

    public PersonHolding (PersonHolding other) {
        this.name = other.name;
        this.headquarterCity = other.headquarterCity;
        this.members = other.members;
        this.clientType = other.clientType;
    }

    public PersonHolding(
            String name,
            String headquarterCity,
            List<PersonLegalEntity> members,
            ClientType clientType) {
        this.name = name;
        this.headquarterCity = headquarterCity;
        this.members = (ArrayList<PersonLegalEntity>) members;
        this.clientType = clientType;
    }

    @Override
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


    @Override
    public int hashCode() {

        return (((Objects.hashCode(name) * 31) + Objects.hashCode(clientType) * 31)
                + Objects.hashCode(headquarterCity) * 31) + Objects.hashCode(members) * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersonHolding) {
            PersonHolding p = (PersonHolding) obj;
            return this.name.equals(p.name) && this.clientType == p.clientType
                    && this.headquarterCity.equals(p.headquarterCity);
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
