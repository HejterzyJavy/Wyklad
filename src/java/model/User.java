package model;

import java.util.Date;

public class User {

    private int userid;
    private String login;
    private String haslo;
    private String adres;
    private String kodPocztowy;
    private String telefon;
    private String imie;
    private String nazwisko;
    private String pesel;
    private Date dob;
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

      ////////////////////////
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String  haslo) {
        this.haslo =  haslo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    ////////////
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override

    public String toString() {

        return "User [userid=" + userid + ", imie=" + imie
                + ", nazwisko=" + nazwisko + ", dob=" + dob + ", email="
                + email + "]";

    }

}
