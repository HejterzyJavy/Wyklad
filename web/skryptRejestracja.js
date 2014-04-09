
	

function ustaw ()
{
for (var i=0;i<8;i++)
document.write('<br>');
}
ustaw();




function walidacja(haslo,powtorzHaslo,imie,nazwisko,email)
{
     var poprawnosc=true;
     var WzorMaila = /^[0-9a-z_.-]+@[0-9a-z.-]+\.[a-z]{2,3}$/i 

	  
	  
    if(haslo!=powtorzHaslo)
	alert('podane dwa hasla roznia sie od siebie');
	 if (imie.length<3)
	 {
	 alert('imie jest za krotkie');
	 poprawnosc=false;
	}
	if(nazwisko.length<3)
	{
	alert('nazwisko jest za krotkie');
	poprawnosc=false;
	}
	if (!WzorMaila.test(email))
	{
	alert('podales zlego emaila');
	poprawnosc=false;
	}
    
	
    return poprawnosc;
}



function sprawdz_dane()
{
    // przypisanie obiektu pola tekstowego do zmiennej
    var pole_imie = document.forms['rejestracja'].imie;
	var pole_nazwisko=document.forms['rejestracja'].nazwisko;
	var pole_login=document.forms['rejestracja'].login;
	var pole_haslo=document.forms['rejestracja'].haslo;
	var pole_powtorz_haslo=document.forms['rejestracja'].powtorzHaslo;
	var pole_email=document.forms['rejestracja'].email;
        var pole_adres=document.forms['rejestracja'].adres;
        var pole_Nrdowodu=document.forms['rejestracja'].Nrdowodu;
	
    // odczyt imienia
    var imie = pole_imie.value;
	var nazwisko=pole_nazwisko.value;
	var login=pole_login.value;
	var haslo=pole_haslo.value;
	var powtorzHaslo=pole_powtorz_haslo.value;
	var email=pole_email.value;
        var adres=pole_adres.value;
        var Nrdowodu=pole_Nrdowodu.value;
	//window.location.href = "http://localhost:8082/Hello_World/test";
	
    
	
    // sprawdzenie czy imie jest wpisane
    if (imie != '' && nazwisko !=''&& login !=''&& haslo !=''&& powtorzHaslo !=''&& email !='')
	{	 
	if(walidacja(haslo,powtorzHaslo,imie,nazwisko,email)==true)
	{
	open("http://localhost:8084/Wyklad/Rejestracja?parametr1="+imie+
                "&parametr2="+nazwisko+"&parametr3="+login+"&parametr4="
                +haslo+"&parametr5="+adres+"&parametr6="+Nrdowodu+"&parametr7="+email);
	document.write('<br>');
	}
	
	}
	else
    {
        alert('nie wypelniono wszystkich pol!');
        pole_imie.focus();
    }
    return false;
}