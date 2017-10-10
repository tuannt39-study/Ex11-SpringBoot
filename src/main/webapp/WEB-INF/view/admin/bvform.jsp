<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bai Viet Form</title>
</head>
<body>
	<h2>Bai Viet Form Sping Web</h2>
	<c:url var="action" value="/hello/baiviet/save" />
		
	<form:form action="${action}" method="POST" modelAttribute="baiviet">
		MaBV : <form:input path="maBV" /><br />
		Tieu De : <form:input path="tieuDe" /><br />
		Danh Muc :<form:input path="danhMuc" /><br />
		Chi Tiet :<form:input path="chiTiet" /><br />
		Lich Dang : <form:input path="lichDang" /><br />
		Trang Thai : <form:input path="trangThai" /><br />
		Nhan : <form:input path="nhan" /><br />
		<button type="submit" >Save</button>
	</form:form>
</body>
</html>