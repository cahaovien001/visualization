function setUpSheet() {
    var q              = document.getElementById("main");
    var qWidth         = q.clientWidth;
    var s              = document.getElementById("sheet");
    var h              = window.innerHeight;
    var _h             = q.clientHeight;
    var n              = document.getElementById("nav").getElementsByTagName("NAV")[0]
    var nHeight        = n.clientHeight;
    var currentStyle   = document.getElementsByTagName("STYLE")[0].innerText;
    var matched        = currentStyle.match(/\#main[\n\d\w\D]*/).toString();
    var matchedMargin  = matched.match(/margin[\d\D\w]*px;/).toString();
    var margin         = matchedMargin.match(/[\d]*px/).toString();
    var indexOfPx      = margin.indexOf("px");
    var marginNumber   = margin.substring(0, indexOfPx);
    var _m             = marginNumber.valueOf();
    console.log("margin: " + _m);
    s.style.height     = document.getElementById("nav").clientHeight + "px"; 
    s.style.width      = (qWidth + 44) + "px";
}
function moveNav() {
    var currentStyle   = document.getElementsByTagName("STYLE")[0].innerText;
    var matched        = currentStyle.match(/\#nav[\n\d\w\D]*/).toString();
    var matchedPadding = matched.match(/padding[\d\D\w]*px;/).toString();
    var padding        = matchedPadding.match(/[\d]*px/).toString();
    var indexOfPx      = padding.indexOf("px");
    var paddingNumber  = padding.substring(0, indexOfPx);
    var _p             = paddingNumber.valueOf();
    var matchedWidth   = matched.match(/width[\d\D\w]*px;/).toString();
    var width          = matchedWidth.match(/[\d]*px/).toString();
    indexOfPx          = width.indexOf("p");
    var widthNumber    = width.substring(0, indexOfPx);
    var _w             = widthNumber.valueOf();
    var w              = window.innerWidth;
    var _w_move        = w - _w - (2*_p);
    var n              = document.getElementById("nav");
    n.style.left       = _w_move + "px";
    
}

function setHeightToMinHeight() {
    var h  = window.innerHeight;
    var n  = document.getElementById("nav");
    var q  = document.getElementById("main");
    var _h = q.clientHeight;
    console.log(_h);
    var currentStyle   = document.getElementsByTagName("STYLE")[0].innerText;
    var matched        = currentStyle.match(/\#main[\n\d\w\D]*/).toString();
    var matchedMargin  = matched.match(/margin[\d\D\w]*px;/).toString();
    var margin         = matchedMargin.match(/[\d]*px/).toString();
    var indexOfPx      = margin.indexOf("px");
    var marginNumber   = margin.substring(0, indexOfPx);
    var _m             = marginNumber.valueOf();
    console.log("margin: " + _m);
    n.style.height     = Math.max(h, (2*_m + _h)) + "px";
}

function resetNav() {
    setHeightToMinHeight();
    moveNav();
    setUpSheet();
}
