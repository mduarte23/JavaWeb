<%@page import="org.filmes.Filme"%>
<%@page import="org.filmes.FilmeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filmes</title>
</head>
<body>
	
	<h1>Cadastro de Filmes</h1>
	<a href="formulario.jsp?id=0">Novo</a>
	
	<table border="1">
		<th>ID</th>
		<th>Nome</th>
		<th>Diretor</th>
		<th>Genero</th>
		<th>Ano</th>
		<th>Streaming</th>
		
		<%
			FilmeDao fdao = new FilmeDao();
			for (Filme f : fdao.listar()){
				out.print("<tr>");
				out.print("<td>" + f.getId_filme() + "</td>");
				out.print("<td>" + f.getNome() + "</td>");
				out.print("<td>" + f.getDiretor() + "</td>");
				out.print("<td>" + f.getGenero() + "</td>");
				out.print("<td>" + f.getAno() + "</td>");
				out.print("<td>" + f.getStreaming() + "</td>");
				out.print("<td>");
				out.print("<a href='formulario.jsp?id=" + f.getId_filme() + "'>Alterar</a>");
				out.print("<a href='excluir.jsp?id=" + f.getId_filme() + "'>Excluir</a>");
				out.print("</tr>");
			}
		%>
		
		
	</table>
	
</body>
</html>