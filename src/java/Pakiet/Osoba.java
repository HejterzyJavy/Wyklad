/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pakiet;

/**
 *
 * @author Adrian
 */
public class Osoba {
    
    String imie,nazwisko,login,haslo,adres,nrdowodu,email;
    
    Osoba(String imie,String nazwisko,String login,String haslo,
            String adres,String nrdowodu,String email)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.login=login;
        this.haslo=haslo;
        this.adres=adres;
        this.nrdowodu=nrdowodu;
        this.email=email;
    }
}
