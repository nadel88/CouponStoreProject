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

    <title>Admin index page</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()+"/css/bootstrap.min.css"%>" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()+"/css/simple-sidebar.css"%>" rel="stylesheet" type="text/css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a>
                        Hello Admin:<%=userName.getUserName() %>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()+"/servlet/CouponAdminServlet/adminindex"%>">Dash board</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()+"/servlet/CouponAdminServlet/newcoupon"%>">Add new Coupon</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()+"/servlet/CouponAdminServlet/deletecoupon"%>">Delete Coupon</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()+"/servlet/CouponAdminServlet/updatecoupon"%>">Update Coupon</a>
                </li>
                 <li>
                    <a href="<%=request.getContextPath()+"/servlet/CouponAdminServlet/adminadduser"%>">Add Admin User</a>
                </li>
                 <li>
                     <a href="<%=request.getContextPath()+"/servlet/CouponAdminServlet/businessdelete"%>">Delete Business</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1><u>Hello and Welcome to the Administrator portal!</u></h1>
                        <h3>Here you can manage the coupon Data Base , preform actions such as:</h2><br>
                        <!--  <h1>Here you can manage the coupon Data Base , preform actions such as:<br>-add new administrator users (such as yourself)<br>-add new coupons<br>-update existing coupons<br>-delete existing coupons</h1>-->
                        <ol>
                        	<li>
                        		<h4>add new administrator users (such as yourself) or regular users.</h3>
                        	</li>
                        	<li>
                        		<h4>add new coupons.</h3>
                        	</li>
                        	<li>
                        		<h4>update existing coupons.</h3>
                        	</li>
                        	<li>
                        		<h4>delete existing coupons.</h3>
                        	</li>
                        	<li>
                        		<h4>delete existing business.</h3>
                        	</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
      <!-- jQuery Version 1.11.0 -->
    <script src="<%=request.getContextPath()+"/js/jquery-1.11.0.js"%>"></script> 

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()+"js/bootstrap.min.js"%>"></script>  
</body>

</html>
