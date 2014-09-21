<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<jsp:useBean id="userName" class="il.ac.hit.couponstorem.model.User" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%if (userName.getUserName() == null)userName.setUserName("guest"); %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome To Coupon-Store</title>

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
                    <img src="${pageContext.request.contextPath}/images/applogo1.png" alt=""> <!-- http://placehold.it/150x50&text=Logo -->
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
                    <li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
                    <li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li><li><a></a></li>
                    <li>
                        <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/coupons_cart"%>>
                        <img src="${pageContext.request.contextPath}/images/cart4.png" alt="" style=height:28px></a>
                    </li> 
                    <li>
                    	<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/login"%>>Log-In</a>
                    </li>
                    <li>
                    	<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/signin"%>>Sign-Up</a>
                    </li> 
                    <li>
                    	<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/logoff"%>>Log-Off</a>
                    </li>         	
                    <li>
               			 <a style ="font-size:18px">Hello:<%=userName.getUserName()%></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Categories</p>
                <div class="list-group">
                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/restaurants"%> class="list-group-item">restaurants</a>
                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/movies_shows"%> class="list-group-item">movies and shows</a>
                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/vacation"%> class="list-group-item">vacation</a>
                    <a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/electronics"%> class="list-group-item">electronics</a>
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
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy;2014 Coupon-Store all rights reserved</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.0 -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>

</html>
