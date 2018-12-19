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

    <title>Online BookReading Category</title>
		 <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
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
                        <a href="##">My favorite</a>
                    </li>
                    <li>
                        <a href="##">Register</a>
                    </li>
                    <li>
                        <a href="##">Login</a>
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
					Online BooksReading Category <small></small>
				</h1>
			</div>
			<nav class="navbar navbar-default navbar-static-top" role="navigation">

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input class="form-control" type="text" id="queries" />
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
                    <a href="#" class="list-group-item">Politics</a>
                    <a href="#" class="list-group-item">Music</a>
                    <a href="#" class="list-group-item">Pschology</a>
                    <a href="#" class="list-group-item">Literature</a>
					<a href="#" class="list-group-item">Biology</a>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <!---<img class="slide-image" src="img/peter.jpg" alt="">--->
																			
		 <div id="container">
												
												
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
						{ var name=array[j].identifier;break;}
						 
				}
				document.write('<a href="bookViewer.jsp?name='+name+'">'+name+'</a>'+'<br>')
            
				var title=volume.title;
				var authors=volume.authors;
				var description=volume.description;
			  
				document.write(title+"<br>")
				document.write(id+"<br>")
				document.write(volume.subtitle+"<br>")
				//document.write(authors+"<br>")
				document.write(volume.publisher+"<br>")
				//documet.write(volume.publishedDate+"<br>")
				document.write(description+"<br>")
				//document.white("<br><br><br>")				
				
				}	
														
                                                                                                            
														
//container.append("Title: "+volume.title + "<br>")
//container.append("Subtitle: "+volume.subtitle + "<br>")
//container.append("Authors: "+volume.authors + "<br>
////container.append("Publisher: "+volume.publisher + "<br>")
//container.append("PublishedDate: "+volume.publishedDate + "<br>")
//container.append("Description: "+volume.description + "<br>")
//volume.industryIdentifiers = JSON.stringify(volume.industryIdentifiers);
//container.append("ISBN_10:"+volume.industryIdentifiers+"<br>")
//container.append("<br><br><br>")
														
//var array = volume.industryIdentifiers;
//for (var j=0;j<array.length;j++){
//if(array[j].type === 'ISBN_10') 
// document.write(array[j].identifier);
//alert(array[j].identifier);
														
//}
														
		
														
														
	});
        }	
</script>
                 </div>
												
   
                                </div>
                               
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <div class="row">

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/TIS.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$9.99</h4>
                                <h4><a href="Order.jsp">The Infinite Sea</a>
                                </h4>
                                <p></p>
                            </div>
       
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/peter1.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$74.99</h4>
                                <h4><a href="#">Harry Potter</a>
                                </h4>
                                <p></p>
                            </div>
       
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/TC.jpg" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$14.99</h4>
                                <h4><a href="#">The Chemist</a>
                                </h4>
                                <p></p>
                            </div>
         
                        </div>
                    </div>

                    


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
