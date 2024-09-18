<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap 5 Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>


	<div  id="frmLoginArea" class="container mt-3">
		<h2>Autenticação</h2>
		<form action="/action_page.php">
			<div class="mb-3 mt-3">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>
		    <div class="mb-3">
		      <label for="pwd">Password:</label>
		      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
		    </div>
	    <button id="btnLogin" type="button" class="btn btn-primary">Entrar</button>
	    <br><a id="linkLembrarSenha" href="#">LembrarSenha </a>
	    <br><a id="linkCadUser" class="btn btn-warning" href="#"> Cadastrar Usuário </a>
	  </form>
	</div>

	<div  id="frmLembrarSenhaArea" class="container mt-3">
		<h2>Lembrar Senha</h2>
		<form action="/action_page.php">
			<div class="mb-3 mt-3">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>
	    	<button id="btnLembrarSenha" type="button" class="btn btn-primary">Enviar</button>
	    	<button id="btnCancelaLembrarSenha" type="button" class="btn btn-danger">Cancelar</button>
	  </form>
	</div>
	
	<div  id="frmCadUserArea" class="container mt-3">
		<h2>Cadastro do Usuário</h2>
		<form action="/action_page.php">
			<div class="mb-3 mt-3">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>
		    <div class="mb-3 mt-3">
		      <label for="cep">CEP:</label>
		      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>
		    
			<label>Cep:
	        <input class="form-control" name="cep" type="text" id="cep" value="" size="10" maxlength="9" /></label><br />
	        <label>Rua:
	        <input class="form-control" name="rua" type="text" id="rua" size="60" /></label><br />
	        <label>Bairro:
	        <input class="form-control" name="bairro" type="text" id="bairro" size="40" /></label><br />
	        <label>Cidade:
	        <input class="form-control" name="cidade" type="text" id="cidade" size="40" /></label><br />
	        <label>Estado:
	        <input class="form-control" name="uf" type="text" id="uf" size="2" /></label><br />
	    	<button id="btnLembrarSenha" type="button" class="btn btn-primary">Save</button>
	    	<button id="btnCancelaCad" type="button" class="btn btn-danger">Cancelar</button>
	  </form>
	</div>
	<script type="text/javascript">
    $(document).ready(function() {

        function limpa_formulário_cep() {
            // Limpa valores do formulário de cep.
            $("#rua").val("");
            $("#bairro").val("");
            $("#cidade").val("");
            $("#uf").val("");
            $("#ibge").val("");
        }
        
        
        $("#frmCadUserArea").hide();
        $("#frmLembrarSenhaArea").hide();
        // $("#frmLoginArea").hide();
    	
        $("#linkLembrarSenha").click(function() {
        	$("#frmCadUserArea").hide();
            $("#frmLembrarSenhaArea").show();
            $("#frmLoginArea").hide();
        });
        
        $("#linkCadUser").click(function() {
        	$("#frmCadUserArea").show();
            $("#frmLembrarSenhaArea").hide();
            $("#frmLoginArea").hide();        	
        });
        
        $("#btnCancelaCad").click(function() {
            $("#frmCadUserArea").hide();
            $("#frmLembrarSenhaArea").hide();
            $("#frmLoginArea").show();
        });
        
       	$("#btnCancelaLembrarSenha").click(function() {
       		$("#frmCadUserArea").hide();
            $("#frmLembrarSenhaArea").hide();
            $("#frmLoginArea").show();
       	});
       	
        $("#cep").blur(function() {

            //Nova variável "cep" somente com dígitos.
            var cep = $(this).val().replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if(validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    $("#rua").val("...");
                    $("#bairro").val("...");
                    $("#cidade").val("...");
                    $("#uf").val("...");
                    $("#ibge").val("...");

                    //Consulta o webservice viacep.com.br/
                    $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                        if (!("erro" in dados)) {
                            //Atualiza os campos com os valores da consulta.
                            $("#rua").val(dados.logradouro);
                            $("#bairro").val(dados.bairro);
                            $("#cidade").val(dados.localidade);
                            $("#uf").val(dados.uf);
                            $("#ibge").val(dados.ibge);
                        } //end if.
                        else {
                            //CEP pesquisado não foi encontrado.
                            limpa_formulário_cep();
                            alert("CEP não encontrado.");
                        }
                    });
                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        });
    });

	</script>

</body>
</html>