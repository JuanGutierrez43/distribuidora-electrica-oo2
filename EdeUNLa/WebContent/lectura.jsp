<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1" pageEncoding = "ISO-8859-1" %>
<%@ page import = "datos.Lectura" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<HTML>
<HEAD>
	<META http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
	<TITLE> EdeUNLa - Lectura</TITLE>
</HEAD>
<BODY>
	<%@ include file = "/cabecera.jsp" %>
	<%Lectura lectura=(Lectura)request.getAttribute( "lectura" ); %>
	<BR>
		ID: <%= lectura.getIdLectura() %> <BR>
		Fecha: <%= lectura.getFecha() %> <BR>
		Inspector: <%= lectura.getInspector() %> <BR>
		Medidor: <%= lectura.getMedidor() %> <BR>
	<BR>
	<A href = "/EdeUNLa/index.jsp" > Volver... </A>
</BODY>
</HTML>