<%@ page isErrorPage="true" %>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Your Question</title>
</head>
<body>

<div class = "container">
		<nav class='navbar navbar-light bg-dark text-white'>
            <a class = "navbar brand text-white" href = "/newQuestion">Ask a question</a>
            <a class = "navbar brand text-white" href = "/">Dashboard</a>
        </nav>
        <div class = "col-8">
        	<h5>Question: </h5>
        		<h4><c:out value = "${question.body}"/></h4>
        	<hr>
        	<c:forEach items = "${tags}" var = "tag">
        	<h6>Tags: <c:out value = "${tags.content}"/></h6>
        	</c:forEach>
        </div>
        
	</div>


</body>
</html>