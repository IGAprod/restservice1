package com.restservice.validation;

import com.restservice.model.Person;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class PersonCreateRequest {


    @NotBlank
    private String imya;
    @NotBlank
    private String familiya;
    @Min(0)
    private int reputation;

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public PersonCreateRequest(@Min(0) Long id, @NotBlank String imya, @NotBlank String familiya, @Min(0) int reputation) {
        this.imya = imya;
        this.familiya = familiya;
        this.reputation = reputation;
    }

    public Person toPerson(){

        Date d = new java.util.Date();
        return new Person(getImya(),getFamiliya(),d,getReputation());
    }

}
