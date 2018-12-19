<!---<%-- 
    Document   : Home
    Created on : 2016-12-6, 10:20:09
    Author     : Shiki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>--->
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Google Books Embedded Viewer API Example</title>
<script>
     function getParameterByName(name, url) {
      if (!url) {
        url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
        
    var number = getParameterByName("name");
    //alert(number);
        
    
</script>
    <script type="text/javascript" src="https://www.google.com/books/jsapi.js"></script>
    <script type="text/javascript">
      google.books.load();
        var label='ISBN:';
        var bookid=label.concat(number);
        alert(bookid);
      function initialize() {
        var viewer = new google.books.DefaultViewer(document.getElementById('viewerCanvas'));
        viewer.load(bookid);
        
       //viewer.load('ISBN:'+number+');
      }

      google.books.setOnLoadCallback(initialize);
    </script>
    <title>Online Categorical Reading System</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


    
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Home.jsp">Home</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="ViewHistory.jsp">View History</a>
                    </li>
                    <li>
                        <a href="UserRegister.jsp">Register</a>
                    </li>
                    <li>
                        <a href="Login.jsp">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					Online Categorical Reading System <small></small>
				</h1>
			</div>
			<nav class="navbar navbar-default navbar-static-top" role="navigation">

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input class="form-control" type="text" id="queries"/>
						</div> <button class="btn btn-default" type="button" onclick="search()">Search</button>
					</form>

				</div>
			</nav>
		</div>
	</div>
</div>
    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Subjects</p>
                <div class="list-group">
                    <a href="category.jsp" class="list-group-item">Politics</a>
                    <a href="category2.jsp" class="list-group-item">Music</a>
                    <a href="category3.jsp" class="list-group-item">Psychology</a>
                    <a href="category4.jsp" class="list-group-item">Biology</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">
				<script>
			    function search(){
				var q;
				q=document.getElementById("queries").value;								
				var term=q;
				var page="https://www.googleapis.com/books/v1/volumes?q="
				$.get(page+term, function(data) {
				var container = $('#container');
                                 container.empty();
				var items = data.items;													
		            for(i=0;i<items.length;i++){
					var volume = items[i];
                    var id =volume.id;
				                
				volume = volume.volumeInfo;
				var array = volume.industryIdentifiers;
				for (var j=0;j<array.length;j++){							
					if(array[j].type == 'ISBN_10') 
						{ var name=array[j].identifier;
					      if(name=="undefined"){alert("Sorry the book is not exist!");}
					      break;
					}
						 
				}
				//document.write('<a href="bookViewer.jsp?name='+name+'">'+name+'</a>'+'<br>')
            
				
                                var title=volume.title;
				
				var description=volume.description;
                                container.append('<a href="bookViewer.jsp?name='+name+'">'+'<h4>'+title+'</h4>' +"<br>")
				container.append("Authors: "+volume.authors + "<br>")
			        container.append("Abstract: "+description + "<br>")
				container.append("PublishedDate: "+volume.publishedDate + "<br>")
                                
//			    document.write('<a href="bookViewer.jsp?name='+name+'">'+title+'</a>'+'<br>')
//				//document.write(title+"<br>")
//				//document.write(id+"<br>")
//				document.write(volume.subtitle+"<br>")
//				document.write('Author:'+volume.authors+"<br>")
//				document.write(volume.publisher+"<br>")
//				//documet.write(volume.publishedDate+"<br>")
//				document.write('Abstract:'+description+"<br>")
								
				
				}	
					//document.white("<br><br><br>");									
														
	});
        }	
</script>

								
				

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                           
                         <div id="viewerCanvas" style="width: 700px; height: 700px"></div>   
                         
                        </div>
                    </div>

                </div>

                <div class="row">

                    
                   


                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>University of Pittsburgh</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
