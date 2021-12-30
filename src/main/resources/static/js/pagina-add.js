

$("#form-pagina").submit(function(evt) {
	//bloquear o comportamento padrão do submit
	evt.preventDefault();
	
	var page = {};
	page.linkPagina = $("#linkPagina").val();
	
	
	page.descricao = $("#desc").val();	
	page.url = $("#url").val();
    page.titulo = $("#titulo").val();
	
	console.log('page > ', page);
	
	$.ajax({
		method: "POST",
		url: "/sites/save",
		data: page,
		beforeSend: function() {
			$("#form-pagina").hide();
			$("#loader-form").addClass("loader").show();
		},
		success: function() {	
			//limpar a pagina
			$("#form-pagina").each(function() {
				this.reset();
			});		
			$("#alert").addClass("alert alert-success").text("OK! Pagina cadastrada com sucesso.");
		},
		error: function(xhr) {
			console.log("> error: ", xhr.responseText);
			$("#alert").addClass("alert alert-danger").text("Não foi possível salvar esta pagina.");
		},
		complete: function() {
			$("#loader-form").fadeOut(800, function() {
				$("#form-pagina").fadeIn(250);
				$("#loader-form").removeClass("loader");
			});
		}
		
	});
});


//capturar a url

$("#linkPagina").on('change', function() {

	var url = $(this).val();
	
	if (url.length > 7) {
		
		$.ajax({
			method:"POST",
			url: "/meta/info?url=" + url,
			cache: false,
			// limpar os dados anteriores
			beforeSend: function() {
				$("#alert").removeClass("alert alert-danger alert-success").text('');
			    $("#titulo").val("");
			    $("#url").val("");
			    $("#desc").val("");
			},
						
			success : function(data) {
			 $("#titulo").val(data.title);
			 $("#url").val(data.url);
			 $("#desc").val(data.description);
			 			
			}, 
			statusCode: {
				404: function() {
					$("#alert").addClass("alert alert-danger").text("Dados não encontrados- url invalida.");
		           }
		     },
		     error: function() {
				$("#alert").addClass("alert alert-danger").text("Danou-se... deu algum erro, tente mais tarde.");				
			}
		});
	}
});