//var bezLoga = true;
//var admin = false;
//var radnik = false;
//var poslodavac = false;
//var userID = null;



var bezLoga = getCookie("bezLoga");
var admin = getCookie("admin");
var radnik = getCookie("radnik");
var poslodavac = getCookie("poslodavac");
var username = getCookie("username");
var userID = getCookie("userID");

//console.log("bezLoga: "+bezLoga)
//console.log("admin: "+admin);
//console.log("poslodavac: "+poslodavac);
//console.log("radnik: "+radnik);
//console.log("Username: "+username);
//console.log("UserID: "+userID);


function setCookie(cname, cvalue) {
    document.cookie = cname + "=" + cvalue + ";path=/";
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


function deleteCookie(cname) {
    if( getCookie(cname) ) {

        document.cookie = cname + "=" + ";expires=Thu, 01 Jan 1970 00:00:01 GMT";
    }
}

function loginProvera(){
    console.log(document.getElementById("users").value)

    setCookie("bezLoga","true");
    setCookie("admin","false");
    setCookie("poslodavac","false");
    setCookie("radnik","false");
    setCookie("userID","null");

    var selektovan = document.getElementById("users").value;



        var usr = document.getElementById("usr").value;
        var psw = document.getElementById("psw").value;

        var url  = "http://localhost:8080/"+selektovan+"/login/username="+usr+"&password="+psw;
        //console.log(url);
        var xhr  = new XMLHttpRequest();
        xhr.open('GET', url, true)
        xhr.onload = function () {

            if (xhr.readyState == 4 && xhr.status == "200") {
                var test = xhr.responseText;
                    if(test != ""){
                        var users = JSON.parse(test);
                        if(selektovan == "admin")
                        {
                            setCookie("bezLoga","false");
                            setCookie("admin","true");
                            setCookie("radnik","false")
                            setCookie("poslodavac","false");
                            setCookie("userID",users.id);
                            setCookie("username",users.username);
                            //console.log("admin: "+admin);
                            //console.log("UserID: "+userID);
                          window.location.replace("http://localhost:8080")
                        }
                        else if(selektovan == "poslodavac")
                        {
                            setCookie("bezLoga","false");
                            setCookie("admin","false");
                            setCookie("radnik","false");
                            setCookie("poslodavac","true");
                            setCookie("userID",users.id);
                            setCookie("username",users.username);
                            //console.log("poslodavac: "+poslodavac);
                            //console.log("UserID: "+userID);
                            window.location.replace("http://localhost:8080/mojProfil="+getCookie("userID"));
                        }
                        else if(selektovan == "radnik")
                        {
                            setCookie("bezLoga","false");
                            setCookie("admin","false");
                            setCookie("radnik","true")
                            setCookie("poslodavac","false");
                            setCookie("userID",users.id);
                            setCookie("username",users.username);
                            //console.log("radnik: "+radnik);
                            //console.log("UserID: "+userID);
                            window.location.replace("http://localhost:8080/oglasi")
                        }
                    }
                    else
                    {
                        alert("Ovaj nalog ne postoji !!!")
                    }
                //console.log(users);
            } else {

                console.log(xhr.responseText);
                //console.error(users);
            }
        }
        xhr.send(null);

}


function displayLoginState()
{
    if(bezLoga == "true")
        return;
    else if(admin == "true")
    {
        document.getElementById("statusKorisnika").innerHTML = "Status: Admin";
        document.getElementById("username").innerHTML ="Username: " + username;
        document.getElementById("logInNaslov").style.display = "none";
        document.getElementById("logOutDugme").style.display = "block";
        var pathname = window.location.pathname;
        //console.log(pathname);
        if(pathname == "/")
        {
            document.getElementById("myImage").src="css/avatar.jpg";
        }

    }
    else if(poslodavac == "true")
    {
        document.getElementById("statusKorisnika").innerHTML = "Status: Poslodavac";
        document.getElementById("username").innerHTML ="Username: " + username;
        document.getElementById("logInNaslov").style.display = "none";
        document.getElementById("logOutDugme").style.display = "block";
    }
    else if(radnik == "true")
    {
        document.getElementById("statusKorisnika").innerHTML = "Status: Radnik";
        document.getElementById("username").innerHTML ="Username: " + username;
        document.getElementById("logInNaslov").style.display = "none";
        document.getElementById("logOutDugme").style.display = "block";
    }

}

function logOut()
{
    deleteCookie("bezLoga");
    deleteCookie("admin");
    deleteCookie("radnik");
    deleteCookie("poslodavac");
    deleteCookie("username");
    deleteCookie("userID");
    location.reload();
}

function redirLogIn()
{
    window.location.replace("http://localhost:8080");
}