<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
 <script type="text/javascript" src="<%=basePath%>js/jquery1.42.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<form:form modelAttribute="accountmodel" method="post"> 	
		用户名：<form:input path="username" />
		<br />
		密 码：<form:password path="password" />
		<br />
		<input type="button" id="biu" value="提交" />
	</form:form>


	<script type="text/javascript" >
        $(function() { 
            $("#biu").click(function() {  
            	
                var postData = '{"username":"' + $('#username').val() + '","password":"' + $('#password').val() + '"}';
                alert(postData); 
                $.ajax({  
                    type : 'POST',  
                    contentType : "application/json",  
                    url : 'http://localhost:8080/SpringMVC/databind/requestbodybind',  
                    processData : false,
                    dataType: 'json',
                    data : postData,
                    success : function(data) {  
                        alert('username : '+data.username+'\npassword : '+data.password);  
                    }, 
                    
                    error: function(XMLHttpRequest, error, errorThrown){  
                        alert(error);  
                        alert(errorThrown);  
                        }
                    
                   //error : function() {  
                   //     alert('出错了'+ postData);  
                   // }   
                    
                    }); 
            });
        });
    </script> 
</body>
</html>