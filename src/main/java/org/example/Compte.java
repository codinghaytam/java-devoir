package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte {
    private String nom;
    private Date DateCreation,DateUpdate;
    private int Devise;
    private List<Transaction> transactions;
    @Setter
    @Getter
    private Banque banque;

    public Compte(String nom, Date DateCreation, Date DateUpdate, int Devise) {
        this.nom = nom;
        this.DateCreation = DateCreation;
        this.DateUpdate = DateUpdate;
        this.Devise = Devise;
        this.transactions = new ArrayList<Transaction>();
    }
}
