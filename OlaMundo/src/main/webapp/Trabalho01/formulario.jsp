<%@page import="org.libertas.PessoaDao"%>
<%@page import="org.libertas.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int idpessoa = Integer.parseInt(request.getParameter("id"));
		Pessoa p = new Pessoa();
		PessoaDao pdao = new PessoaDao();
		if (idpessoa > 0){
			p = pdao.consultar(idpessoa);
		} else {
			//limpa os dados para novo
			p.setNome("");
			p.setTelefone("");
			p.setEmail("");
			p.setCidade("");
			p.setEndereco("");
			p.setCep("");
		}
	%>

	<form action="gravar.jsp" method="post">
		<input type="hidden" name="idpessoa" value="<%=p.getIdpessoa() %>" />
	
		Nome:
		<input type="text" name="nome" value="<%= p.getNome() %>"/>
		<br/>
		Telefone:
		<input type="text" name="telefone" value="<%= p.getTelefone() %>"/>
		<br/>
		Email:
		<input type="text" name= "email" value="<%= p.getTelefone() %>"/>
		<br/>
		Cidade:
		<input type="text" name="cidade" value="<%= p.getEmail() %>"/>
		<br/>
		Endereco:
		<input type="text" name="endereco" value="<%= p.getEndereco() %>"/>
		<br/>
		CEP:
		<input type="text" name="cep" value="<%= p.getCep() %>"/>
		<br/>
		<input type="submit" value="salvar"/>
	</form>

</body>
</html>