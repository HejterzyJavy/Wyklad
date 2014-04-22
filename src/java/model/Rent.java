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
    private Date dataWypozyczenia;
    private Date dataZwrotu;
    private String status;
    
    
    public void setIdWypozyczenie(Integer idWypozyczenie)
    {
        this.idWypozyczenie=idWypozyczenie;
    }
    
  public Integer getIdWypozyczenie()
  {
      return this.idWypozyczenie;
  }
    
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
  
    
}
