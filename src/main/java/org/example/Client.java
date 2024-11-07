package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class Client {
    @Getter
    @Setter
    private String nom,prenom,adresse,phone,email;
    @Getter
    @Setter
    private Compte compte;
    Client(String nom, String prenom, String adresse, String phone, String email) {
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.phone = phone;
    this.email = email;

}


}
