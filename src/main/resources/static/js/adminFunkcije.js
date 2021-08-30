
function obrisiOglas(objButton)
{
    //console.log(objButton.value);

    var url = "http://localhost:8080/admin/oglas=" + objButton.value ;
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", url, true);
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            alert("Obrisan je oglas sa ID :" + objButton.value);
            location.reload();
        } else {
            console.error("GRESKA!!!");
        }
    }
    xhr.send(null);

}


function obrisiRadnika(objButton)
{
    //console.log(objButton.value);

    var url = "http://localhost:8080/admin/radnik=" + objButton.value ;
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", url, true);
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            alert("Obrisan je radnik sa ID :" + objButton.value);
            location.reload();
        } else {
            console.error("GRESKA!!!");
        }
    }
    xhr.send(null);

}

function obrisiPoslodavca(objButton)
{
    //console.log(objButton.value);

    var url = "http://localhost:8080/admin/poslodavac=" + objButton.value ;
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", url, true);
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            alert("Obrisan je poslodavac sa ID :" + objButton.value);
            location.reload();
        } else {
            console.error("GRESKA!!!");
        }
    }
    xhr.send(null);

}