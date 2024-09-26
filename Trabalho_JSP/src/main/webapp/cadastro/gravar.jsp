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

	<%
		Filme f = new Filme();
		FilmeDao fdao = new FilmeDao();
		f.setId_filme(Integer.parseInt(request.getParameter("id_filme")));
		f.setNome(request.getParameter("nome"));
		f.setDiretor(request.getParameter("diretor"));
		f.setGenero(request.getParameter("genero"));
		f.setAno(request.getParameter("ano"));
		f.setStreaming(request.getParameter("streaming"));
		
		if (f.getId_filme()>0){
			fdao.alterar(f);
		}else{
			fdao.inserir(f);
		}
	%>
	<h1>Filme salvo com sucesso!</h1>
	<a href="index.jsp">Início</a>

</body>
</html>