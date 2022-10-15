<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-4 col-md-offset-4">
		<div class="login-panel panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Logout Page</h3>
			</div>
			<div class="panel-body">
				<form role="form" method='post' action="/customLogout">
					<fieldset>
						<a href="/customLogin" class="btn btn-lg btn-success btn-block">Logout</a>
					</fieldset>
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	$(".btn-success").on("click", function(e){
		e.preventDefault();
		$("form").submit();
	});
</script>
<c:if test="${param.logout != null }">
	<script>
		$(document).ready(function(){
			alert("로그아웃하였습니다.");
		});
	</script>
</c:if>
</html>

