/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author Adrian
 */
public class Oplaty {

    
    private Integer idOplaty;
    private Date rozpoczecieOc;
    private Date zakonczenieOc;
    private Date rozpoczecieAc;
    private Date zakonczenieAc;
    private String tmpMarkaSamochodu;
    private String tmpModelSamochodu;
    private String tmpRejestracjaSamochodu;

    public String getTmpMarkaSamochodu() {
        return tmpMarkaSamochodu;
    }

    public void setTmpMarkaSamochodu(String tmpMarkaSamochodu) {
        this.tmpMarkaSamochodu = tmpMarkaSamochodu;
    }

    public String getTmpModelSamochodu() {
        return tmpModelSamochodu;
    }

    public void setTmpModelSamochodu(String tmpModelSamochodu) {
        this.tmpModelSamochodu = tmpModelSamochodu;
    }

    public String getTmpRejestracjaSamochodu() {
        return tmpRejestracjaSamochodu;
    }

    public void setTmpRejestracjaSamochodu(String tmpRejestracjaSamochodu) {
        this.tmpRejestracjaSamochodu = tmpRejestracjaSamochodu;
    }

  
    
    public Integer getIdOplaty() {
        return idOplaty;
    }

    public void setIdOplaty(Integer idOplaty) {
        this.idOplaty = idOplaty;
    }

    public Date getRozpoczecieOc() {
        return rozpoczecieOc;
    }

    public void setRozpoczecieOc(Date rozpoczecieOc) {
        this.rozpoczecieOc = rozpoczecieOc;
    }

    public Date getZakonczenieOc() {
        return zakonczenieOc;
    }

    public void setZakonczenieOc(Date zakonczenieOc) {
        this.zakonczenieOc = zakonczenieOc;
    }

    public Date getRozpoczecieAc() {
        return rozpoczecieAc;
    }

    public void setRozpoczecieAc(Date rozpoczecieAc) {
        this.rozpoczecieAc = rozpoczecieAc;
    }

    public Date getZakonczenieAc() {
        return zakonczenieAc;
    }

    public void setZakonczenieAc(Date zakonczenieAc) {
        this.zakonczenieAc = zakonczenieAc;
    }
 
    
    
}
