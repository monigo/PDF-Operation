<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
    

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
    <title>PDF Tools</title>
    

    <style>
        .navbar{
            background-color: black;
            border-radius: 30px;
        }
        .navbar ul{
            overflow: auto;
        }
        .navbar li{
            float:left;
            list-style: none; 
            margin: 13px 20px;
            
        }
        .navbar li a{
            padding: 3px 3px;
            text-decoration: none;
            color: white;
        }
        .navbar li a:hover{
            color: red
        }
        .search{
            float: right;
            color: white;
            padding: 12px 75px;
        }
        .navbar input{
            border: 2px solid black;
            border-radius: 14px;
            padding: 3px 17px;
            width: 129px;
        }
        .sub-menu-1{
          display:none;
        }
        .navbar ul li:hover .sub-menu-1{
          display: block;
          position: absolute;
          background: black;
          margin-top: 15px;
          margin-left: -15px;
        }
        .navbar ul li:hover .sub-menu-1{
          display: block;
          margin:10px;
        }
        /* .jumbotron-img{
          background-image: url(https://live.staticflickr.com/908/41281384105_6fab834b14_b.jpg);
          background-size: auto 100%;
          color:red;
          font-family: sans-serif;
        } */
        .content {
          max-width: 500px;
          margin: auto;
        }
        .container {
          display: flex;
          justify-content: center;
          flex-direction: row;
        }
        .back{
          background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ1QOPwA3UFVxTvTH5lUub8_hunnf1NmtZ2LmRraSPUhcqPSIhw&usqp=CAU);
          background-size: cover;
        }
        .align{
          text-align: right;
        }
    </style>
</head>

<body>
  <div class="back">
      <header>
          <nav class="navbar">
              <ul>
                <!-- <li><a href="#"></a></li><li><a href="#"></a> -->
                <!-- </li><li><a href="#"></a></li><li><a href="#"></a></li><li><a href="#"></a></li><li><a href="#"></a></li> -->
                
                  <li><a href="#">SPLIT PDF</a></li>
                  <li><a href="#">SPLIT PDF</a></li>
                  <li><a href="#">COMPRESS PDF</a></li>
                  <li><a href="#">SIGN UP</a></li>
                  <li><a href="#">LOG IN</a></li> 
            
              </ul>
          </nav>
          <div class="jumbotron jumbotron-img">
            <h1 class="display-4" style="text-align:center ; font-size:50px;"><strong>This is for You</strong></h1>
           
            <p class="lead"  style="text-align:center"><strong >I am waiting for you to make a visit here atleast once</strong></p>
            
            <hr class="my-4">
            <!-- <p><strong>Every tool you need to use PDFs, at your fingertips. All are 100% FREE and easy to use! Merge, split, compress, convert, rotate, unlock and watermark PDFs with just a few clicks.</strong></p> -->
            <!-- <p class="lead">
              <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
            </p> -->
          </div>
      </header>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap">
              <div class="card-body">
				<a href="<s:url value="/merge"/>">MERGE PDF</a>	
                <p class="card-text">Combines pdf in the order you want with the easiest pdf merger available.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
			  <a href="<s:url value="/split"/>">SPLIT PDF</a>
                <p class="card-text"> Seperate the one page or a whole set for easy conversion into independent PDF files.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
				<a href="<s:url value="/extract_text"/>">PDF TO TEXT</a>
                <p class="card-text">Extract All the Text form the PDF and Edit the Text as you want.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    <br>
    <br>
    <br>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
				<a href="<s:url value="/pdf_to_image"/>">PDF TO IMAGE</a>
                <p class="card-text">Easily convert your PDF files into image. The converted file is of 100% document format.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
				<a href="<s:url value="/lock"/>">LOCK</a>
                <p class="card-text">Lock Your PDF and make it secure from the unwanted people.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
				<a href="<s:url value="/unlock"/>">UNLOCK</a>
                <p class="card-text">Unlock the PDF to see its content without password.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    <br>
    <br>
    <br>
      
    <br>
    <br>
    <br>
      <footer>
        <div class="jumbotron jumbotron-fluid">
          <div class="container">
            <p class="lead">Free PDF Operation WebSite</p>
          </div>
          <div >
            
            <h6 style="text-align:center;"> : KLLQZ</h6>
          </div>
        </div>
      </footer>
  </div>
</body>
</html>
