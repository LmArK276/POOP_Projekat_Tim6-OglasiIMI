

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



if((getCookie("admin") == "true") || (getCookie("radnik") == "true") || (getCookie("poslodavac") == "true"))
{
    document.getElementById("button2").style.display="none";
}

if((getCookie("admin") == "true") || (getCookie("radnik") == "true") || (getCookie("poslodavac") == "true"))
{
    document.getElementById("button1").style.display="none";
}



function myFunction() {

    var s = document.getElementById("users1");
    var s1 = s.options[s.selectedIndex].value;
    if(s1=="poslodavac"){

        document.getElementById("poslodavac").style.display="block";
        document.getElementById("radnik").style.display="none";
    }
    else
    {
        document.getElementById("radnik").style.display="block";
        document.getElementById("poslodavac").style.display="none";

    }

}










