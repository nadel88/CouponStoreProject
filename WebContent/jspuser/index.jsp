<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="il.ac.hit.couponstorem.model.*" %>
<%@ page import="java.util.Iterator" %> 
<%  
response.setHeader("Cache-Control","no-store"); //HTTP 1.1  
response.setHeader("Pragma","no-cache"); //HTTP 1.0  
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%> 
<jsp:useBean id="userName" class="il.ac.hit.couponstorem.model.User" scope="session"></jsp:useBean>
<%if (userName.getUserName() == null){userName.setUserName("guest");} %>
<%request.setAttribute("coupon",CouponDao.getInstance().getCoupons(0,CouponDao.getInstance().getListSize())); %>
<%Iterator<Coupon> list_coupon = (Iterator<Coupon>)request.getAttribute("coupon"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
		
	    <title>Welcome To Coupon-Store</title>
		<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
	    <!-- Bootstrap Core CSS -->
	    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	
	    <!-- Custom CSS -->
	    <link href="${pageContext.request.contextPath}/css/shop-homepage.css" rel="stylesheet" type="text/css">
	     <link href="${pageContext.request.contextPath}/css/logo-nav.css" rel="stylesheet" type="text/css">
	
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
	                <a class="navbar-brand" href=<%=request.getContextPath()+"/servlet/CouponUserServlet/index"%>>
	                     <img class="hidden-xs" style="margin-top:-5px;margin-right:15px;" src="${pageContext.request.contextPath}/images/logo150.png" alt=""> 
	                      <img class="visible-xs" src="${pageContext.request.contextPath}/images/logo120.png" alt=""> 
	                </a>
	            </div>
	
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li>
	                        <a  href=<%=request.getContextPath()+"/servlet/CouponUserServlet/about"%>>About</a>
	                    </li>
	                    <li>
	                        <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/contact"%>>Contact</a>
	                    </li>
	                    <li>
	                        <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/coupons_cart"%>>Cart</a>
	                    </li> 
	                    <li>
	                    	 <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/login"%>>Log-In</a> 
	                    		
	                    </li>
	                    <li>
	                    	<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/signin"%>>Sign-Up</a>
	                    </li> 
	                    <%if (userName.getUserName()!="guest"){ %>
	                    <li>
	                    		<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/logoff"%>>Log-Off</a>
	                    </li>  
	                    <%} %>       	
	                    <li>
	               			 <a>Hello:<%=userName.getUserName()%></a>
	                    </li>
	                </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container -->
	    </nav>
		
		    <!-- Page Content -->
	    <div class="container">
	    
			<div class="jumbotron" style="border:1px solid #DDD;">
				<h1 class="hidden-xs" style="color: white;font-size:7em;margin-left:23%;">Coupon Store Ne</h1>
				<h1 class="visible-xs" style="color: white;font-size:4em;margin-left:5%;">Coupon Store Ne</h1>
				
			</div>
			
	        <div class="row">
	
	            <div class="col-md-3">
	                <p class="lead">Categories</p>
	                <div class="list-group">
	                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/restaurants"%> class="list-group-item">restaurants</a>
	                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/movies_shows"%> class="list-group-item">movies and shows</a>
	                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/vacation"%> class="list-group-item">vacation</a>
	                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/electronics"%> class="list-group-item">electronics</a>
	                </div>
	                
	               
	                <div id="second-list" class="list-group">
	                	<p id="second-list-p" class="lead">Links</p>
	                    <a href="https://www.facebook.com/nadav.eliyahu.1" target="_blank" class="list-group-item">Facebook</a>
	                    <a href="https://twitter.com/ShredMasterB" target="_blank" class="list-group-item">Twitter</a>
	                    <a href="https://www.linkedin.com/profile/view?id=185937317&trk=nav_responsive_tab_profile_pic" target="_blank" class="list-group-item">LinkedIn</a>
	                    <a href="#" class="list-group-item">Resume Page(soon)</a>
	                    <a href="#" class="list-group-item">Artist Page(soon)</a>
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
	                                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
	                            </ol>
	                            <div class="carousel-inner">
	                                <div class="item active">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/images/restaurant_indexpage.jpg" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/images/cameras_indexpage.jpg" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/images/vacation_indexpage.jpg" alt="">
	                                </div>
	                                <div class="item">
	                                    <img class="slide-image" src="${pageContext.request.contextPath}/images/movies_indexpage.jpg" alt="">
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
	                
	                <hr>
	                <h1>New Items</h1>
	                <div class="row">
	               		<%for(int i = 1 ;i<=8 && list_coupon.hasNext() ; i++ ){ Coupon c = list_coupon.next();%>
	               		<div class="col-xs-6 col-md-3">
							<a href="servlet/CouponUserServlet/item?id=<%=c.getId() %>" class="thumbnail">
								<img src="${pageContext.request.contextPath}/<%=c.getImage()%>" alt="...">
							</a>
						</div>
						<%} %>
						
					</div>
					<hr>
					<h1 style="margin-left:40%" class="underline">Full Disclosure!</h1>
					
					<div class="arrow-down"></div>
	
	                <!-- div for info -->
	                <div id="hidden-about">
	                	<p>This web application is my final project, it is for demonstration purposes only(NOT REAL WORLD APPLICATION!).<br>  
	                	</p>
	                </div>
	                
			        <!-- Footer -->
			        <footer>
			            <div class="row">
			                <div class="col-lg-12">
			                	<hr>
			                    <p>Copyright &copy;2014 CouponStoreNe all rights reserved</p>
			                </div>
			            </div>
			        </footer>
	
	    	</div>
		    <!-- /.container -->
		
		    <!-- jQuery Version 1.11.0 -->
		    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
			
		    <!-- Bootstrap Core JavaScript -->
		    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		    <script src="${pageContext.request.contextPath}/js/myjs.js"></script>
	
		</body>
</html>
