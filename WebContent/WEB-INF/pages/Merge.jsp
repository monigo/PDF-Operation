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
  width:95%;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0, 0, 0, 0.1);
  height:550px;
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
  font-size: 36px;
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
<script>
var counter = 1;
var limit = 10;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "<input type="file" class="form-control" name="multipartfile"  required autofocus/>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
</script>
</head>
  <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>

      <link rel="stylesheet" href="css/style.css">
      
      
<body>
<br><br><br>         
<div class="container" style="padding-top:200px;min-height:738px;text-size:36px;">
  
    <form class="form-signin" action="handle_merge" method="POST" enctype="multipart/form-data" >        
      <h1 style="font-size: 40px;" class="form-signin-heading" >Please Upload Files</h1>
	  <br>
      <br>
      
      
      <input type="file" class="form-control" name="multipartfile" placeholder="File 1" required autofocus />
      <br>
      <br>
      <br>
      
      
      
      
      
	 <div id="dynamicInput">
		          <input type="file" class="form-control" name="multipartfile"  required autofocus/>
		          
			      <br>
			      <br>
			      <br>
	</div>
		     
	<input type="button" value="Add another text file" onClick="addInput('dynamicInput');">
	
      
      
      
      
      
         
      <label style="color:red"></label>
      <br>
      <br>
      <div class="form-group">
      <button style="font-size: 36px;" class="btn btn-lg btn-primary btn-block" type="submit" >MERGE</button> 
      </div>
      
    </form>
  </div>
	
</body>
</html>