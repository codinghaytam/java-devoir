package org.example;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

import static java.lang.System.exit;

enum Type{
    VIRINT, // 1 banque 1pays
    VIREST, // 2 banque 1 pays
    VIRCHAR, // 2 pays 2 banque
    VIRMULTA, // 1 banque * compte
    UNVALID
}

@Getter
@Setter
public class Transaction {
    private final Type type;
    private final Timestamp timestamp ;
    private final String Reference;
    private final List<Compte> compte;

    Transaction(Timestamp timestamp, String Reference, List<Compte> compte) {
        this.timestamp = timestamp;
        this.Reference = Reference;
        this.compte = compte;
        if(compte.size()<2){
            System.out.println("Compte length should be greater than 2");
            exit(1);
        }
        if(compte.size() > 2){
            boolean is_valid = true;
            for (Compte c : compte) {
                if(c.getBanque() != compte.get(0).getBanque()){
                    is_valid = false;
                    break;
                }

            }
            if(is_valid){
                this.type = Type.VIRMULTA;
            }else{
                this.type = Type.UNVALID;
                System.out.println("opperation unvalid");
                exit(1);
            }
        } else if (compte.get(0).getBanque().getPays().equals(compte.get(1).getBanque().getPays())) {
            if(compte.get(0).getBanque() == compte.get(1).getBanque()){
                this.type = Type.VIRINT;
            }
            else{
                this.type = Type.VIREST;
            }
        } else if (compte.get(0).getBanque() != compte.get(1).getBanque()) {
            this.type = Type.VIRCHAR;
        }
        else {
            this.type = Type.UNVALID;
            System.out.println("opperation unvalid");
        }

    }
}
