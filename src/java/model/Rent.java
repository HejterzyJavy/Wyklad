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
public class Rent {
    private Integer idWypozyczenie;
    private Integer id; //id samochod
    private Integer idUser;
    private long doZaplaty;
    private Date dataWypozyczenia;
    private Date dataZwrotu;
    private String status;
    private String opis;
    private String tmpMarka;
    private String tmpModel;
    private String tmpImie;
    private String tmpNazwisko;
    
    public void setIdWypozyczenie(Integer idWypozyczenie)
    {
        this.idWypozyczenie=idWypozyczenie;
    }
    
  public Integer getIdWypozyczenie()
  {
      return this.idWypozyczenie;
  }
  
   public String getTmpMarka()
  {
      return this.tmpMarka;
  }
   
   public void setTmpMarka(String tmpMarka)
   {
       this.tmpMarka=tmpMarka;
   }
   
   public String getTmpModel()
           {
               return this.tmpModel;
           }
   
   public void setTmpModel(String tmpModel)
   {
       this.tmpModel=tmpModel;
   }
   
   
   public String getTmpImie()
  {
      return this.tmpImie;
  }
  
  public void setTmpImie(String tmpImie)
  {
      this.tmpImie=tmpImie;
  }
   
  
  public String getTmpNazwisko()
  {
      return this.tmpNazwisko;
  }
  
    
  public void setTmpNazwisko(String tmpNazwisko)
  {
      this.tmpNazwisko=tmpNazwisko;
  }
  
  
  /////////
    
  public void setIdSamochod(Integer idSamochod)
  {
      this.id=idSamochod;
  }
    
  public Integer getIdSamochod()
  {
      return this.id;
  }
  
  public void setIdUser(Integer idUser)
  {
      this.idUser=idUser;
  }
  
  public Integer getIdUser()
  {
      return this.idUser;
  }
  
  public void setDoZaplaty(long doZaplaty)
  {
      this.doZaplaty=doZaplaty;
  }
  
  public long getDoZaplaty()
  {
      return this.doZaplaty;
  }
  
  public void setDataWypozyczenia(Date dataW)
  {
      this.dataWypozyczenia=dataW;
  }
    
  public Date getDataWypozyczenia()
  {
      return this.dataWypozyczenia;
  }
  
  public void setDataZwrotu (Date dataZ)
  {
      this.dataZwrotu=dataZ;
  }
  public Date getDataZwrotu()
  {
      return this.dataZwrotu;
  }
  
  public void setStatus (String status)
  {
      this.status=status;
  }
  
  public String getStatus()
  {
      return this.status;
  }
  
  public void setOpis(String opis)
  {
      this.opis=opis;
  }
  
  public String getOpis()
  {
      return this.opis;
  }
  
}
