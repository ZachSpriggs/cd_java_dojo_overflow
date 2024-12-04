<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>New Question</title>
</head>
<body>

<div class="container">
        <nav class='navbar navbar-light bg-dark text-white'>
            <a class='navbar brand text-white' href="/">Dashboard</a>
        </nav>
        <h3>What is your question</h3>
        <form action="/createQuestion" method="POST">
            <div class="row">
            	<div class = "col-lg">
                    <p>
	  					<label >Question:</label>
	  					<input name = "body" type = "text" style = "width: 240px;"/>
  					</p>
  					<p>
	  					<label >Tag:</label>
	  					<input name = "tags" type = "text" placeholder = "Separate up to 3 tags with commas" style = "width: 280px;"/>
  					</p>
               	</div>
             </div>
            <div class='row'>
                <button class='btn btn-outline-success ml-3 mt-3'>Add</button>
            </div>
        </form>
        
    </div>

</body>
</html>