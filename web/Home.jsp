<!---<%-- 
    Document   : Home
    Created on : 2016-12-6, 10:20:09
    Author     : Shiki
--%>
<%@page import="Classes.Document"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
					Online Categorical Reading System <small></small>
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
                    <a href="category.jsp" class="list-group-item">Politics</a>
                    <a href="category2.jsp" class="list-group-item">Music</a>
                    <a href="category3.jsp" class="list-group-item">Psychology</a>
                    <a href="category4.jsp" class="list-group-item">Biology</a>
                </div>
            </div>

            <div class="col-md-9">
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
				//document.write('<a href="bookViewer.jsp?name='+name+'">'+name+'</a>'+'<br>')
            
				var title=volume.title;
				
				var description=volume.description;
                                container.append('<a href="bookViewer.jsp?name='+name+'">'+'<h4>'+title+'</h4>' +"<br>")
				container.append("Authors: "+volume.authors + "<br>")
			        container.append("Abstract: "+description + "<br>")
				container.append("PublishedDate: "+volume.publishedDate + "<br>")
			        //document.write('<a href="bookViewer.jsp?name='+name+'">'+title+'</a>'+'<br>')
				//document.write(title+"<br>")
				//document.write(id+"<br>")
				//document.write(volume.subtitle+"<br>")
				//document.write('Author:'+volume.authors+"<br>")
				//document.write(volume.publisher+"<br>")
				//documet.write(volume.publishedDate+"<br>")
				//document.write('Abstract:'+description+"<br>")
								
				
				}	
					document.white("<br><br><br>");									
														
	});
        }	
</script>

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
																			
			<a href="bookViewer.html" style="text-decoration:none; color:#000000"> <div id="container"></div></a>
												
												
			

												
   
                   </div>
                               
                            </div>
                           
                        </div>
                    </div>

                </div>

                <div class="row">

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/book1.jpg" alt="">
                            <div class="caption">
                  
                                <h4><a href="bookViewer.jsp?name=1501131133">All By Myself, Alone</a>
                                </h4>
                                <p></p>
                            </div>
       
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/book2.jpg" alt="">
                            <div class="caption">
                               
                                <h4><a href="bookViewer.jsp?name=0062300563">Hillbilly Elegy</a>
                                </h4>
                                <p></p>
                            </div>
       
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/book3.jpg" alt="">
                            <div class="caption">
                              <h4><a href="bookViewer.jsp?name=0795308329">The Gathering Storm: <br>
                                      The Second World War <br>Volume 1</a>
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
