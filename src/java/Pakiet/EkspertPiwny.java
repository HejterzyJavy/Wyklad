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
import dao.UserDao;

public class EkspertPiwny {

    private UserDao dao;

    public EkspertPiwny() {
        this.dao = new UserDao();
    }


    public String sprawdzLogowanie(String login, String haslo) {
        String logowanie;

        if (login.equals("Adrian") && haslo.equals("Wojton")) {
            logowanie = "ok";
        } else {
            logowanie = "zle";
        }
        return (logowanie);
    }
}
