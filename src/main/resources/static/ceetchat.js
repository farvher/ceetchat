/**
 * @Autor Farsan@eltiempo.com
 * 
 * 
 */

$(function() {
	console.log("ready!");

	var formChat;
	var inputChat;
	var question;
	var response;
	var chatBox;
	var fragmentChat;
	var fragmentChat2;
	var business;
	var right = true;
	var urlSearch = "/search/"

	form = $("#ceetchat");
	fragmentChat = $("#fragmentChat");
	fragmentChat2 = $("#fragmentChat2");
	chatBox = $("#chatBox");

	form.submit(function(event) {
		event.preventDefault();
		var msj = form.find("input").val();
		if (msj != "") {
			addResponse(fragmentChat, msj)
			sleep(1000, msj)
			form.find("input").val("")
			// sendQuestion();
		}
	})

	search = function(data) {

		addResponse(fragmentChat2,  optionsDocument(data.documents) + dym(data.question, data.suggestions) );
	}

	function addResponse(fragment, msj) {
		fragment.find("p").html(msj);
		var html = fragment.wrap("<p/>").parent().html();
		html = html.replace("hidden", "");
		chatBox.append(html);
		chatBox.parent().animate({
			scrollTop : chatBox.height()
		}, 500);

	}

	function sendQuestion(msj) {
		AjaxGenericHTML(urlSearch + msj, search, []);

	}

	function optionsDocument(documents) {
		var options = "<div class='list-group'>";
		$.each(documents, function(i,o) {
			options += "<a class='list-group-item' href='#'>"+o.content+"</a>";
		})
		options += "</div>";
		return options;
		
	}

	function dym(msj, suggestion) {
		var res = "";
		if (msj != suggestion) {
			res = "<p>";
			res += "<div class='alert alert-warning' >quizas quisiste decir : "+suggestion+"</div>"
//			res += "quizas quisiste decir : " + suggestion;
			res += "</p>";

		}
		return res;
	}

	function AjaxGenericHTML(url, funct, param) {
		console.log("busqueda ajax : " + url + " params : "
				+ JSON.stringify(param));
		// gifStart();
		$.ajax({
			url : url,
			data : param,
			type : "GET",
			success : funct,
			error : function(jqXHR, textStatus, errorThrown) {
				alert('ha ocurrido un error' + jqXHR + " - " + textStatus
						+ " - " + errorThrown);
			},
			complete : function(jqXHR, textStatus) {
				// gifStop();
			}
		});
	}
	function sleep(time, msj) {
		setTimeout(function() {
			sendQuestion(msj);
		}, time);
	}

});
