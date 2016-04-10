<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista degli articoli</title>
</head>
<body>
<p>
  <a href="createArticle">Inserisci un nuovo articolo</a>
</p>
<fieldset>
<legend>Articoli inseriti</legend>
<c:forEach items="${articles}" var="article">
  Autore: <c:out value="${article.name}" /><br/><br/>
  Titolo: <c:out value="${article.title}" /><br/><br/>
  Contenuto: <c:out value="${article.body}" /><br/><br/>
  Data creazione: <c:out value="${article.data}" /><br/><br/>
  Tags: <c:out value="${article.tags}" /><br/><br/>
  <hr/>
</c:forEach>
</fieldset>

</body>
</html>