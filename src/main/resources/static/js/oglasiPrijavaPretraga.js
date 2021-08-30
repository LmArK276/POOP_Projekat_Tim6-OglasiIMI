function oglasSearch()
{
    var string = document.getElementById("pretragaPolje").value;
    if(string == null || string== "")
        alert("Unesite tekst u polje pretrage !!!");
    else
        window.location.replace("http://localhost:8080/oglasi_pozicija="+string);
}

function nazadNaOglase()
{
    window.location.replace("http://localhost:8080/oglasi");
}

var kategorijeSave = [];

function ucitajKategorije()
{

    var url  = "http://localhost:8080/sviOglasi";
    var xhr  = new XMLHttpRequest()
    xhr.open('GET', url, true)
    xhr.onload = function () {
        var kat = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {

            var kategorije=[];
            for(var i = 0; i < kat.length ; i++)
            {
                kategorije[i] = kat[i].kategorija;
            }

            kategorije = [...new Set(kategorije)];

            kategorijeSave = kategorije;

            var opcije="<option>Sve Kategorije</option>";

            for(var i = 0 ; i < kategorije.length ; i++)
            {
                opcije += "<option value='"
                opcije += kategorije[i]+"'>";
                opcije += kategorije[i];
                opcije += "</option>";
            }

            document.getElementById("dropDown").innerHTML = opcije;

        } else {
            console.error(kat);
        }
    }
    xhr.send(null);
}

function filterKategorije()
{
    var kategorija = document.getElementById("dropDown").value;


    for(var i = 0  ; i < kategorijeSave.length ; i++)
    {

            var objekti = document.getElementsByClassName(kategorijeSave[i]);

            for(var j = 0 ; j < objekti.length ; j++)
            {
                objekti[j].style.display = "block";
            }

    }

    if(kategorija == "Sve Kategorije")
        return;
    else
    {
        for(var i = 0  ; i < kategorijeSave.length ; i++)
        {
            if(kategorijeSave[i] != kategorija)
            {
               var objekti = document.getElementsByClassName(kategorijeSave[i]);

               for(var j = 0 ; j < objekti.length ; j++)
               {
                   objekti[j].style.display = "none";
               }
            }
        }
    }
}

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function prijaviMe(objButton)
{
    var oglasID = objButton.value;

    var radnik = getCookie("radnik");

    if(radnik == "false" || radnik=="")
    {
        alert("Samo Radnici se mogu prijaviti na oglase");
        return;
    }

    var radnikID = getCookie("userID");

    // Get a user
    var url  = "http://localhost:8080/radnik/oglas="+oglasID+"&radnik="+radnikID;
    var xhr  = new XMLHttpRequest()
    xhr.open('GET', url, true)
    xhr.onload = function () {
        //var users = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200")
            alert("Uspesno ste se prijavili na oglas " + oglasID);
            location.reload();
            //console.table(users);

    }
    xhr.send(null);



}


function buttonDisable()
{
    var radnik = getCookie("radnik");

    if(radnik == "false" || radnik=="")
    {
        var dugmad = [];
        dugmad = document.getElementsByClassName('oglasPrijavaDugme');
        for(var i = 0 ; i < dugmad.length ; i++)
            dugmad[i].disabled = true;
    }
    else
    {
        var radnikId = getCookie("userID");

        var url  = "http://localhost:8080/oglasiZaRadnika="+radnikId;
        var xhr  = new XMLHttpRequest()
        xhr.open('GET', url, true)
        xhr.onload = function () {
            var users = JSON.parse(xhr.responseText);
            if (xhr.readyState == 4 && xhr.status == "200")
            {
                //console.table(users);


                for(var i=0 ; i < users.length ; i++)
                {

                    if(document.getElementById("oglas"+users[i].oglasId) != null)
                        document.getElementById("oglas"+users[i].oglasId).disabled=true;

                }

            }
        }
        xhr.send(null);

    }
}