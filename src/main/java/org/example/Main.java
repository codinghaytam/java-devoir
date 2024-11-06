package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Client c1= new Client("haytam","soukrati","kfndjsmx123","0775668899","hello@gmail.com");
        Compte compte1= new Compte("first ct",new Date(),new Date(),12);
        c1.setCompte(compte1);
        JsonUtils converter = new JsonUtils();
        System.out.println(converter.toJson(c1));
    }
}