function dodaj_element(kontener){
    var znacznik = document.createElement('input');
    var znacznik2= document.createElement('input');
    var d = document.getElementById("paczka");
    var d_nested = document.getElementById("usun");
    var throwawayNode = d.removeChild(d_nested);
    znacznik2.setAttribute('type', 'submit');
    znacznik2.setAttribute('value', 'zatwierdz');
    znacznik2.setAttribute('name', 'marka');
    znacznik.setAttribute('text', 'file');
    znacznik.setAttribute('name', 'pole');
    znacznik.setAttribute('value', 'Podaj marke');
    znacznik.className = 'upload';
    var kontener = document.getElementById(kontener);
    kontener.appendChild(znacznik);
    kontener.appendChild(znacznik2);
    kontener.removeChild("usun");
}

function dodaj_element2(kontener){
    var znacznik = document.createElement('input');
    var znacznik2= document.createElement('input');
    var znacznik3= document.createElement('input');
    var d = document.getElementById("paczka2");
    var d_nested = document.getElementById("usun2");
    var throwawayNode = d.removeChild(d_nested);
    znacznik2.setAttribute('type', 'submit');
    znacznik2.setAttribute('value', 'zatwierdz');
    znacznik2.setAttribute('name', 'rocznik');
    znacznik.setAttribute('text', 'file');
    znacznik.setAttribute('name', 'rokOd');
    znacznik.setAttribute('value', 'Od');
    znacznik.className = 'upload';
    znacznik3.setAttribute('text', 'file');
    znacznik3.setAttribute('name', 'rokDo');
    znacznik3.setAttribute('value', 'Do');
    znacznik3.className = 'upload';
    
    var kontener = document.getElementById(kontener);
    kontener.appendChild(znacznik);
    kontener.appendChild(znacznik3);
    kontener.appendChild(znacznik2);
    //kontener.removeChild("usun");
} 