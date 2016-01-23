function getxmlhttp() {
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest;
    } else if (window.ActiveXObject) {
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    } else {
        alert("AJAX not supported");
        xmlhttp = false;
    }
    return xmlhttp;
}

function loadPage(option) {
    var xmlhttp = getxmlhttp();
    var url = "Controller?section=subc" + option + ".kp&action=display";

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            document.getElementById('content').innerHTML = xmlhttp.responseText;           
        }
        else {
            document.getElementById('content').innerHTML = "Loading:" + option + ".jsp";
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send(null);
}
