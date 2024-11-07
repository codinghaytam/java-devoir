package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionTest {

    private Banque banque1;
    private Banque banque2;
    private Compte compte1;
    private Compte compte2;
    private Compte compte3;
    private Client client1;
    private Client client2;
    private Client client3;


    private void setup() {
      this.banque1 = new Banque(1, "CountryA");
      this.banque2 = new Banque(2, "CountryB");
        this.client1 = new Client("haytam","soukrati","kfndjsmx123","0775668899","hello@gmail.com");
        this.client2 = new Client("do","soukrati","kfsmx123","0775665661","hello@gmail.com");
        this.client3 = new Client("hamid","soukrat","kfmfgmx123","0775668899","hello@gmail.com");
      this.compte1 = new Compte("Account1", new Date(), new Date(), 100,banque1,client1);
      this.compte2 = new Compte("Account2", new Date(), new Date(), 200,banque1,client2);
      this.compte3 = new Compte("Account3", new Date(), new Date(), 300,banque2,client3);
      this.compte1.setBanque(banque1);
      this.compte2.setBanque(banque1);
      this.compte3.setBanque(banque2);
    }

    @Test
    public void testTransactionWithTwoSameBankAndCountryAccounts() {
        setup();
        List<Compte> comptes = new ArrayList<>();
        comptes.add(this.compte1);
        comptes.add(this.compte2);
        Transaction transaction = new Transaction(new Timestamp(System.currentTimeMillis()), comptes);
        assertEquals(Type.VIRINT, transaction.getType(), "Expected type to be VIRINT for two accounts in the same bank and country");
    }

    @Test
    public void testTransactionWithTwoDifferentBanksSameCountryAccounts() {
        setup();
        Banque banque3 = new Banque(3, "CountryA");
        Compte compte4 = new Compte("Account4", new Date(), new Date(), 150,banque3,client1);
        compte4.setBanque(banque3);
        List<Compte> comptes = List.of(compte1, compte4);
        Transaction transaction = new Transaction(new Timestamp(System.currentTimeMillis()), comptes);
        assertEquals(Type.VIREST, transaction.getType(), "Expected type to be VIREST for accounts in different banks but the same country");
    }

    @Test
    public void testTransactionWithTwoDifferentBanksDifferentCountries() {
        setup();
        List<Compte> comptes = List.of(compte1, compte3);
        Transaction transaction = new Transaction(new Timestamp(System.currentTimeMillis()), comptes);
        assertEquals(Type.VIRCHAR, transaction.getType(), "Expected type to be VIRCHAR for accounts in different banks and countries");
    }

    @Test
    public void testTransactionWithMultipleAccountsSameBank() {
        setup();
        List<Compte> comptes = List.of(compte1, compte2, compte1);
        Transaction transaction = new Transaction(new Timestamp(System.currentTimeMillis()), comptes);
        assertEquals(Type.VIRMULTA, transaction.getType(), "Expected type to be VIRMULTA for multiple accounts in the same bank");
    }

    @Test
    public void testTransactionInvalidWithLessThanTwoAccounts() {
        setup();
        List<Compte> comptes = List.of(compte1);
        assertThrows(IllegalStateException.class, () -> new Transaction(new Timestamp(System.currentTimeMillis()), comptes), "Expected exception for transactions with less than two accounts");
    }

    @Test
    public void testTransactionInvalidWithMultipleBanks() {
        setup();
        List<Compte> comptes = List.of(compte1, compte2, compte3);
        assertThrows(IllegalStateException.class, () -> new Transaction(new Timestamp(System.currentTimeMillis()), comptes), "Expected exception for transactions with accounts in multiple banks");
    }
}
