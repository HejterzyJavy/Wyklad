/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Adrian
 */
public class Car {
    
    private Integer carId;
    private String marka;
    private String model;
    private Integer rocznik;
    private Integer przebieg;
    private String pojemnoscSilnika;
    private Integer cenaDoba;
    
    
    public Integer getId()
    {
        return carId;
    }
    
    public void setID(int id)
    {
        this.carId=id;
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
    
    public Integer getCenaDoba()
    {
        return cenaDoba;
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
