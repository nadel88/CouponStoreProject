<%@ page language="java" contentType="text/html; charset=windows-1255" 
    pageEncoding="windows-1255"%>
<%@ page import="il.ac.hit.couponstorem.model.*" %>
<%@ page import="java.util.Iterator" %>
<jsp:useBean id="userName" class="il.ac.hit.couponstorem.model.User" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html lang="en">

<head>
	<%if (userName.getUserName() == null)userName.setUserName("guest"); %>
	<%Iterator<Coupon> list_coupon = (Iterator<Coupon>)request.getAttribute("coupon"); %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Electronics Coupons</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/css/1-col-portfolio.css" rel="stylesheet" type="text/css" >
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
                    	<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/signin"%>>Sign-In</a>
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

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Electronics
                    <small>Electronics Coupons</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->
		<%for(int i = 1 ;list_coupon.hasNext() ; i++ ){ Coupon c = list_coupon.next(); %>
        <!-- Project One -->
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/<%=c.getImage()%>" alt=""> <!-- http://placehold.it/700x300 -->
                </a>
            </div>
            
            <div class="col-md-5">
                <h3>Coupon ID: <%=c.getId() %></h3>
                <h4>Business ID: <%=c.getBusiness_id() %></h4>
                <p>Coupon Details: <%=c.getDetails()%></p>
                <p>Coupon Price: <%=c.getPrice() %> NIS</p>
                 <p>Valid until: <%=c.getExpiredate() %></p>
                 <%session.setAttribute("id", c.getId()); %>
                <a class="btn btn-primary" href=servlet/CouponUserServlet/coupons_cart?id=<%=c.getId() %>>Add Coupon To Cart <span class="glyphicon glyphicon-chevron-right"></span></a>
               
            </div>
        </div>
        <!-- /.row -->

        <hr>
	<%} %>
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.0 -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


</body>

</html>
