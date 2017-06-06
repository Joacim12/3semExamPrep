var svg2 = document.getElementById("svg2");
var paths = document.getElementsByTagName("path");
svg2.addEventListener("click", click);
function click(evt) {
    for (var i = 0; i < paths.length; i++) {
        paths[i].style.fill = "#c0c0c0";
    }
    evt.target.style.fill = "red";
    var url = "http://localhost:8084/SvgEurope/proxy?codes=" + evt.target.id;

    var promise = fetch(url, {method: 'get'});
    promise.then(function (response) {
        return response.text();
    }).then(function (text) {
        var textObject = JSON.parse(text);
        document.getElementById("text").innerHTML = textObject[0].name + "<br/>Population: " + textObject[0].population
                + "<br/>Area: " + textObject[0].area + "<br/>Borders: " + textObject[0].borders;

    });
    clicked = evt.target.id;
}
;      