<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet"
type="text/css">

</head>
<body>
	<h1>Custom Login Page</h1>
	<h2><c:out value="${error }"/></h2>
	<h2><c:out value="${logout }"/></h2>
	
	<form role="form" method="post" action="/login">
		<fieldset>
			<div class="form-group">
				<input class="form-control" placeholder="userid" 
				type='text' name='username' autofocus>
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="Password" type='password' name='password' value=''>
			</div>
			<div class="checkbox">
				<input type='checkbox' name='remember-me'>Remember Me
			</div>
			<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
		</fieldset>
		<div>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		</div>
	</form>
	
	<!-- jQuery -->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="/resource/vendor/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Metis Menu Plugins JavaScript -->
	<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>
	
	<!-- Custom Theme JavaScript -->
	<script src="/resources/dist/js/sv-admin-2.js"></script>
	
	<script>
		$(".btn-success").on("click", function(e){
			e.preventDefault();
			$("form").submit();
		});
	</script>
	
	
</body>
</html>