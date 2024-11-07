package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compte {
    @Getter
    @Setter
    private String nom;
    @Getter
    @Setter
    private Date DateCreation,DateUpdate;
    @Getter
    @Setter
    private int Devise;
    @Getter
    @Setter
    private List<Transaction> transactions;
    @Setter
    @Getter
    private Banque banque;
    private Client client;

    public Compte(String nom, Date DateCreation, Date DateUpdate, int Devise,Banque banque, Client client) {
        this.nom = nom;
        this.DateCreation = DateCreation;
        this.DateUpdate = DateUpdate;
        this.Devise = Devise;
        this.transactions = new ArrayList<>();
        this.banque= banque;
        this.banque.getComptes().add(this);
    }

}
