<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href= "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity= "sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN", crossorigin= "anonymous"}>
<meta charset="ISO-8859-1">
<title>Stock prediction</title>
</head>
<style>
#select{
width:300px;

}
</style>
<body class="container bg-danger-subtle">

<div class="container text-dark text-center border-primary bg-red mt-5 p-5 rounded shadow text-bg-success p-3">
<h1>Stock Prediction</h1>
<form style=center; action=Stockmain method=get>
<div class="mb-3">
<lable class="form-label d-block">Select Stock Indices</lable>

<select name="Stock" class="form-select" id="select" style=text-align:center>
<option>Select</option> 
<option value="NIFTY%20NEXT%2050">NSE next50</option>
<option value="NIFTY%20BANK">Nifty Bank</option>
<option value="NIFTY%20500">Nifty 500</option>

</select>
<button class="btn btn-info px-4 py-2 mx-auto mt-4 d-block">find</button>
</div></form>
</div>
</body>
</html>