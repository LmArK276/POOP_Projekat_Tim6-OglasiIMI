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


function redirPostavljanjeOglasa()
{
    window.location.replace("http://localhost:8080/dodavanje_oglasa");
}

function  redirPregledOglasa()
{
    window.location.replace("http://localhost:8080/mojiOglasi="+getCookie("userID"));
}

function redirProfil()
{
    window.location.replace("http://localhost:8080/mojProfil="+getCookie("userID"));
}

function pregled(objButton)
{

    window.location.replace("http://localhost:8080/radniciNaOglasu="+objButton.value);
}

