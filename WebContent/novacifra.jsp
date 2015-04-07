<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${requestScope.title}</title>
</head>
<body>


        
 
<form action="/CifraApp/Cifra/novaCifra/name/author/letter.do" method="post">
	<fieldset>
		<legend>General Information: </legend>
		  <label>Nome da Musica:<input type="text" name="name"></label>
		  <label>Autor: <input type="text" name="author"></label>
		  <label>Letra: <textarea name=letter cols=70 rows=30></textarea></label>
	</fieldset>
  <input type="submit">
</form>

<br><br>${requestScope.error}
</body>
</html>