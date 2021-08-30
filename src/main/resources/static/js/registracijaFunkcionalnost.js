var poslodavci = []

function ucitajPos()
{
    var url  = "http://localhost:8080/poslodavac/sviPoslodavci";
    var xhr  = new XMLHttpRequest()
    xhr.open('GET', url, true)
    xhr.onload = function () {
        var users = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            //console.table(users);
            for(var i = 0 ; i < users.length ; i++)
            {
                poslodavci[i] = users[i].username;

            }

        }
        else
        {
            console.error(users);
        }
    }
    xhr.send(null);
}



var radnici = []

function ucitajRad()
{
    var url  = "http://localhost:8080/radnik/sviRadnici";
    var xhr  = new XMLHttpRequest()
    xhr.open('GET', url, true)
    xhr.onload = function () {
        var users = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            //console.table(users);
            for(var i = 0 ; i < users.length ; i++)
            {
                radnici[i] = users[i].username;

            }

        }
        else
        {
            console.error(users);
        }
    }
    xhr.send(null);
}




function setCookie(cname, cvalue) {
    document.cookie = cname + "=" + cvalue + ";path=/";
}



function pokupiInfo()
{
    //console.table(radnici);
    //console.table(poslodavci);


    var selected = document.getElementById("users1").value;

    if(selected == "poslodavac")
    {
        var data = {};

        data.naziv = document.getElementById("nz").value;
        data.opis = document.getElementById("op").value;
        data.delatnost = document.getElementById("del").value;
        data.sediste = document.getElementById("sed").value;
        data.username = document.getElementById("usr1").value;
        data.password = document.getElementById("psw1").value;

        if(data.naziv=="" || data.opis =="" || data.delatnost == "" || data.sediste == "" || data.username == "" || data.password == "")
        {
            alert("Popunite sva polja pre registracije !!!");
            return;
        }


        var json = JSON.stringify(data);

        console.table(json);

        if(poslodavci.includes(data.username))
        {
            alert("Username je zauzet, odaberite neki drugi");
            return;
        }
        else
        {
            var url = "http://localhost:8080/poslodavac/register"
            var xhr = new XMLHttpRequest();
            xhr.open("POST", url, true);
            xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
            xhr.onload = function () {
                var users = JSON.parse(xhr.responseText);
                if (xhr.readyState == 4 && xhr.status == "200") {
                    alert("Dobrodosli na sajt "+data.username+". Registracija je uspesna !!!");
                    //console.table(users);
                    setCookie("bezLoga","false");
                    setCookie("admin","false");
                    setCookie("radnik","false");
                    setCookie("poslodavac","true");
                    setCookie("userID",users.id);
                    setCookie("username",users.username);
                    //console.log("poslodavac: "+poslodavac);
                    //console.log("UserID: "+userID);
                    window.location.replace("http://localhost:8080/mojProfil="+users.id);

                } else {
                    console.error(users);
                }
            }
            //console.log(json);
            xhr.send(json);
        }

    }
    else
    {
        var data = {};

        data.imePrezime = document.getElementById("impr").value;
        data.kvalifikacije = document.getElementById("kv").value;
        data.username = document.getElementById("usr2").value;
        data.password = document.getElementById("psw2").value;


        if(data.imePrezime=="" || data.kvalifikacije=="" || data.username == "" || data.password == "")
        {
            alert("Popunite sva polja pre registracije !!!");
            return;
        }


        var json = JSON.stringify(data);

        console.table(json);

        if(radnici.includes(data.username))
        {
            alert("Username je zauzet, odaberite neki drugi");
            return;
        }
        else
        {
            var url = "http://localhost:8080/radnik/registracija"
            var xhr = new XMLHttpRequest();
            xhr.open("POST", url, true);
            xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
            xhr.onload = function () {
                var users = JSON.parse(xhr.responseText);
                if (xhr.readyState == 4 && xhr.status == "200") {
                    alert("Dobrodosli na sajt "+data.username+". Registracija je uspesna !!!");
                    //console.table(users);
                    setCookie("bezLoga","false");
                    setCookie("admin","false");
                    setCookie("radnik","true")
                    setCookie("poslodavac","false");
                    setCookie("userID",users.id);
                    setCookie("username",users.username);
                    //console.log("radnik: "+radnik);
                    //console.log("UserID: "+userID);
                    window.location.replace("http://localhost:8080/oglasi")

                } else {
                    console.error(users);
                }
            }
            //console.log(json);
            xhr.send(json);

        }
    }

}