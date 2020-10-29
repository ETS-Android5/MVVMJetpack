
function D2J_FoxBrowserEdit_SetText(editId, text){
	alert('setText');
	GetJQueryObject(editId).text(text);
}

function D2J_FoxBrowserEdit_QueryHeight(editId, text){
	var div = document.getElementById(editId);
	return {'offsetHeight': div.offsetHeight}
}

function D2J_FoxBrowserEdit_QueryWidth(editId, text){
	var div = document.getElementById(editId);
	return {'offsetWidth': div.offsetWidth}
}
