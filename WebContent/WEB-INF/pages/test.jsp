<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>   
<html>
<head>
<title>upload</title>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
<style>
body {
  background: #eee !important;
}

.wrapper {
  margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0, 0, 0, 0.1);
  height:370px;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 30px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 20px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

</style>
</head>
  <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>

      <link rel="stylesheet" href="css/style.css">
      
      
<body>
                     
<div class="container" style="padding-top:200px;min-height:738px;">
  
    <form class="form-signin" action="handle_merge" method="POST" enctype="multipart/form-data">        
      <h2 class="form-signin-heading">Please Upload File</h2>

      <input type="file" class="form-control" name="multipartfile" placeholder="File 1" required autofocus />
      <br>
      
      <input type="file" class="form-control" name="multipartfile" placeholder="File 2" required autofocus/>      
     
     
     
      <div class="form-group"> 
	      
	      <label class="col-md-6">

	      </label>
	      
	      <label class="col-md-6">
	         
	      </label>
	      
      </div>
     
      <label style="color:red"></label>
      
      <div class="form-group">
      <button class="btn btn-lg btn-primary btn-block" type="submit">MERGE</button> 
      </div>
      
    </form>
  </div>
	
</body>
</html>