function openWindowTab() {
    var htmlElem = window.document.documentElement;
    htmlElem.setAttribute("style", "padding: 3px");
    
    createNewWindowInHtmlElem(htmlElem);
    createNewWindowInHtmlElem(htmlElem);
    createNewWindowInHtmlElem(htmlElem);
    createNewWindowInHtmlElem(htmlElem);
    createNewWindowInHtmlElem(htmlElem);

    _webmgr_stack(htmlElem);
}

function _webmgr_lineup(host) {
    var _children =  host.children;

    for (var i=0; i < _children.length; i++) {
	if (_children[i].nodeName == "DIV") {
	    _children[i].setAttribute("style", "margin: 3px; width: 377px; height: 377px; background-color: rgb(84,156,206); float:left; display:block");
	    _children[i].setAttribute("onclick", "_webmgr_stack(window.document.documentElement)");
	}
    }
}

function _webmgr_stack(host) {
    var _children =  host.children;

    for (var i=0; i < _children.length; i++) {
	if (_children[i].nodeName == "DIV") {
	    _children[i].setAttribute("style", "margin: 3px; width: 377px; height: 377px; background-color: rgb(84,156,206); float:none; clear:both; display:block");
	    _children[i].setAttribute("onclick", "_webmgr_lineup(window.document.documentElement)");
	}
    }
}


function createNewWindowInHtmlElem(elem) {
    var divElem = document.createElement("DIV");
    var parElem = document.createElement("P");

    parElem.textContent = "Hello World!";
    parElem.setAttribute("style", "color: rgb(69, 186, 203)");
    
    divElem.scrollHeight = "233px";
    divElem.scrollWidth  = "377px";
    divElem.setAttribute("style", "margin: 3px; width: 377px; height: 377px; background-color: rgb(84,156,206); display: block");
    divElem.setAttribute("onclick", "_webmgr_lineup(window.document.documentElement)");
    //divElem.appendChild(parElem);
    elem.appendChild(divElem);

    document.write();
}

openWindowTab();
