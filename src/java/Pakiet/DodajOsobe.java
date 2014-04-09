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
public class DodajOsobe {
    
public String sprawdzDane( Osoba osoba )
{
String rejestracja;

if( osoba.login.equals( "Adrian" ) )
{
rejestracja="zle";
}
else
{
rejestracja="ok";
}
return rejestracja;
}
}
