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


function dodajOglas()
{

    var url = "http://localhost:8080/poslodavac/dodaj-oglas/";
    var data = {};
    data.radnaPozicija = document.getElementById("radnaPozicija").value;
    data.opis  = document.getElementById("opis").value;
    data.idPoslodavca= getCookie("userID");
    data.kategorija = document.getElementById("kategorija").value;
    data.podkategorija = document.getElementById("podkategorija").value;

    if(data.radnaPozicija=="" || data.opis =="" || data.kategorija == "" || data.podkategorija == "")
    {
        alert("Popunite sva polja pre postavljanja oglasa !!!");
        return;
    }

    var json = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        var users = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            alert("Oglas uspesno postavljen!!!");
            console.table(users);

        } else {
            console.error(users);
        }
    }
    //console.log(json);
    xhr.send(json);
}

function redirProfil()
{
    window.location.replace("http://localhost:8080/mojProfil="+getCookie("userID"));
}