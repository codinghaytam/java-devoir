package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Banque {
    private int id;
    @Getter
    @Setter
    private String pays;
    @Getter
    @Setter
    private List<Compte> comptes=new ArrayList<>();
    Banque(int id, String pays) {
        this.id = id;
        this.pays = pays;
    }
}
