<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Questions Dashboard</title>
</head>
<body>

	<div class = "container">
	<nav class="navbar navbar-light bg-dark text-white">
            <h3 class = "navbar brand text-white" style = "text-align: center;">Welcome to the Dashboard!</h3>
            <a class = "navbar brand text-white" href = "/newQuestion">Ask a question</a>
        </nav>
        <h4>Questions Dashboard</h4>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Questions</th>
	      <th scope = "col"></th>
	      <th scope="col">Tags</th>
	    </tr>
	  </thead>
	  <tbody>
        
        <c:forEach items = "${questions}" var = "question">
	        <tr>
			      <td><a href = "/showQuestion/${question.id}"><c:out value = "${question.body}"/></a></td>
			      <td></td>
			      <c:forEach items = "${question.tags}" var = "tag">
			     	 <td><c:out value = "${tag.content}"/></td>
			      </c:forEach>
			</tr>  
		   </c:forEach>

	  </tbody>
	</table>
</div>
</body>
</html>