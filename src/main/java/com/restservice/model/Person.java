package com.restservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@Entity
@Table(name = "persons")
public class Person extends AuditModel {

    @Id
    @GeneratedValue(generator = "person_generator")
    @SequenceGenerator(
            name = "person_generator",
            sequenceName = "person_sequence",
            initialValue = 1000
    )
    private Long id;


    @Column(name = "imya", nullable = false, length = 50)
    private String imya;
    @Column(name = "familiya", nullable = false, length = 50)
    private String familiya;
    @Column(name = "born", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date born;
    @Column(name = "reputation", nullable = false)
    private int reputation;

    public Person(String imya, String familiya, Date born, int reputation) {
        this.imya = imya;
        this.familiya = familiya;
        this.born = born;
        this.reputation = reputation;
    }

    public Person() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}


