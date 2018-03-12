<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<script type="text/javascript" src="skrypt.js"></script>
<title>Rezerwacja w restauracji</title>
</head>
<body>
<form action="Check" method="post" id="rezerwacja">
<div id="container">
<div id="header">
<h1>Witamy w Restauracji</h1>
<h3>Proszę podaj dane do rezerwacji</h3>
</div>
<div id="content">
<div id="fields">
<table>
<tr>
<td>Imie:</td>
<td><input id="name" type="text" name="firstName" ></td>
</tr>
<tr>
<td></td>
<td><div id="iname" class="error"></div></td>
</tr>
<tr>
<td>Nazwisko:</td>
<td><input id="lname" type="text" name="lastName" ></td>
</tr>
<tr>
<td></td>
<td><div id="ilname" class="error"></div></td>
</tr>
<tr>
<td>Email:</td>
<td><input id="email" type="text" name="email" ></td>
</tr>
<tr>
<td></td>
<td><div id="iemail" class="error"></div></td>
</tr>
<tr>
<td>Data rezerwacji</td>
<td><input id="data" type="text" name="data" placeholder="DD/MM/YYYY"></td>
</tr>
<tr>
<td></td>
<td><div id="idata" class="error"></div></td>
</tr>
<tr>
<td>Godzina rezerwacji</td>
<td><input id="godz" type="text" name="godz" placeholder="12:00"></td>
</tr>
<tr>
<td></td>
<td><div id="igodz" class="error"></div></td>
</tr>
</table>
</div>
<br>
<div id="buttons">
<input id="button" type="submit" value="Rezerwuj" ><input id="button" type="reset" value="Odśwież">
</div>
</div>
<div id="footer">
Copyright &copy; 2018 Przemyslaw Wesolowski.
</div>
</div>
</form>
</body>
</html>