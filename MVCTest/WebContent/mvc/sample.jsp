<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var form = document.getElementById("form");
	var name = "";
	var age = "";
	
	window.onload = function() {
	}

	function chkString() {
		name = document.getElementById("name").value;
		age = document.getElementById("age").value;
		
		for(var i=0; i<name.length; i++){
			if(name.charAt(i) > '0' && name.charAt(i) <'9'){
				alert("문자입력하세요");
				return false;
			}
		}
		
		
		for(var i=0; i<age.length; i++){
			if(!(age.charAt(i) > '0' && age.charAt(i) <'9')){
				alert("숫자입력하세요");
				return false;
			}
		}
		return true;
	}
</script>
</head>
<body>
	<!-- 디렉토리 패턴 -->
	<a href="http://localhost:8081/MVCTest/mvc01/ABC">move to index
		page</a>
	<br>
	<br>

	<form action="http://localhost:8081/MVCTest/mvc01/form" method="get" onsubmit="return chkString();">
		<span>이름</span><input type="text" name="name" id="name"> <br>
		<br> <span>나이</span><input type="text" name="age" id="age">
		<br>
		<br> <input type="submit" value="ok"><input type="reset"
			value="reset">
	</form>
	<br><br>
	
	<!-- 확장자 패턴 -->
	<a href="http://localhost:8081/MVCTest/abc/xyz/xxx.nhn">nhn</a>
	<br><br><br>
	
	<a href="http://localhost:8081/MVCTest/write.action">SampleCnt - write</a>
	<br>
	<a href="http://localhost:8081/MVCTest/list.action">SampleCnt - list</a>
	<br>
</body>
</html>