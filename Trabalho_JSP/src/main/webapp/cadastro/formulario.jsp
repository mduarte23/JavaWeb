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
		int id_filme = Integer.parseInt(request.getParameter("id"));
		Filme f = new Filme();
		FilmeDao fdao = new FilmeDao();
		if (id_filme > 0){
			f = fdao.consultar(id_filme);
		}else{
			f.setNome("");
			f.setDiretor("");
			f.setGenero("");
			f.setAno("");
			f.setStreaming("");
		}
	%>
	
	<form action="gravar.jsp" method="post">
		<input type="hidden" name="id_filme" value="<%=f.getId_filme() %>" />
		
		Nome:
		<input type="text" name="nome" value="<%= f.getNome() %>"/>
		<br/>
		Diretor:
		<input type="text" name="diretor" value="<%= f.getDiretor() %>" />
		<br/>
		Gênero:
		<input type="text" name="genero" value="<%= f.getGenero() %>" />
		<br/>
		Ano:
		<input type="text" name="ano" value="<%= f.getAno() %>" />
		<br/>
		Streaming:
		<input type="text" name="streaming" value="<%= f.getStreaming() %>" />
		<br/>
		<input type="submit" value="salvar"/>

	</form>

</body>
</html>