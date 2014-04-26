/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.InputStream;

/**
 *
 * @author Adrian
 */
public class Car {
    
    private Integer carId;
    private String marka;
    private String model;
    private Integer rocznik;
    private String rodzajPaliwa;
    private Integer mocSilnika;
    private Integer przebieg;
    private String pojemnoscSilnika;
    private String skrzyniaBiegow;
    private String typNadwozia;
    private Integer dostepnosc;
    private Integer cenaDoba;
    private InputStream zdjecie;
    private String tmp;
    
    
    
    public void setZdjecie(InputStream zdjecie)
    {
        this.zdjecie=zdjecie;
    }
    
     public InputStream getZdjecie()
    {
        return this.zdjecie;
    }
    
    
    public Integer getId()
    {
        return carId;
    }
    
    public void setID(Integer id)
    {
        this.carId=id;
    }
    
    
    public String getTmp()
    {
        return tmp;
    }
    
    public void setTmp(Integer id)
    {
        this.tmp=id.toString();
    }
    
    
    public String getMarka()
    {
        return marka;
    }
    
    public void setMarka(String marka)
    {
        this.marka=marka;
    }
    
    public String getModel()
    {
        return model;
    }
    
       public void setModel(String model)
    {
        this.model=model;
    }
       
        public Integer getRocznik()
    {
        return rocznik;
    } 
        
    public void setRocznik(Integer rocznik)
    {
        this.rocznik=rocznik;
    } 
       
    public String getRodzajPaliwa()
    {
        return this.rodzajPaliwa;
    }
    
    public void setRodzajPaliwa(String rodzajPaliwa)
    {
        this.rodzajPaliwa=rodzajPaliwa;
    }
    
    public Integer getMocSilnika()
    {
        return this.mocSilnika;
    }
    
    public void setMocSilnika(Integer mocSilnika)
    {
        this.mocSilnika=mocSilnika;
    }
    
    
    public Integer getPrzebieg()
    {
        return przebieg;
    }
    
    public void setPrzebieg(Integer przebieg)
    {
        this.przebieg=przebieg;
    }
    
    public String getPojemnoscSilnika()
    {
        return pojemnoscSilnika;
    }
    
    public void setPojemnoscSilnika(String pojemnoscSilnika)
    {
        
        this.pojemnoscSilnika=pojemnoscSilnika;
    }
    
    public String getSkrzyniaBiegow()
    {
        return this.skrzyniaBiegow;
    }
    
    public void setSkrzyniaBiegow(String skrzyniaBiegow)
    {
        this.skrzyniaBiegow=skrzyniaBiegow;
    }
    
    public String getTypNadwozia()
    {
        return this.typNadwozia;
    }
    
    public void setTypNadwozia(String typNadwozia)
    {
        this.typNadwozia=typNadwozia;
    }
    
    
     public Integer getDostepnosc()
    {
        return this.dostepnosc;
    }
    
    public void setDostepnosc(Integer dostepnosc)
    {
        this.dostepnosc=dostepnosc;
    }
    
    public Integer getCenaDoba()
    {
        return this.cenaDoba;
    }
    
    public void setCenaDoba(Integer cenaDoba)
    {
        this.cenaDoba=cenaDoba;
    }
    
    /*@Override
    public String toString() {

        return "Samochod [Carid=" + carId + ", marka=" + marka
                + ", model=" + model + ", rocznik=" + rocznik + ", przebieg="
                + przebieg + ",pojemnoscSilnika= "+pojemnoscSilnika+"cena za dobe="+cenaDoba+"]";

    }*/
    
    
    
}
