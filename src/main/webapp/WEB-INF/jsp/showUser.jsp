<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>test spring mvc</title>
<style>
    	.show{
    		background : url(${contextPath}/img/index.jpg);
			background-size : 100% 100%;
			width: 500px;
			height:500px;
    	}
    </style>
</head>
<body style="">
	<div class="show">
		${user.name}
	</div>		
</body>
</html>