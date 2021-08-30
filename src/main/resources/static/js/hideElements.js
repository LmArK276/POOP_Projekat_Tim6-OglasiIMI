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

var bezLoga = getCookie("bezLoga");
var admin = getCookie("admin");
var radnik = getCookie("radnik");
var poslodavac = getCookie("poslodavac");
var username = getCookie("username");
var userID = getCookie("userID");

var mojProfil = document.getElementById("profilLink");
var ctrlPanel = document.getElementById("ctrlPanelLink");


if(admin != "true")
{
    ctrlPanel.style.display = "none";
}


if(poslodavac != "true")
{
    mojProfil.style.display = "none";
}



