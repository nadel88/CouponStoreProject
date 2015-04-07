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

    <title>Add new Coupon</title>

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
                    <div class="col-lg-6">
                        <h3>Add Coupon</h3>
                        <p>In this Form you cant add a coupon to the Data Base. </p>
                        <p>Make sure that you supply a correct business id (greater then 100).<br>and type the correct category (restaurants,electronics,movie_shows,vacation).</code>.</p>
                        <form method="post" action=<%= request.getContextPath() +"/servlet/CouponAdminServlet/add"%>>
							<br><h3> Business_Id:</h3> <input type="text" class="form-control input-lg" name="business_id" /> 
							<br><h3> Image Source:</h3> <input type="text" class="form-control input-lg" name="image" /> 
							<!--  <br><h3> Details:</h3> <input type="text" class="form-control input-lg" name="details" /> -->
							<br><h3>Details:</h3>
							<br><textarea type="text" class="form-control input-lg" name="details"></textarea>
							<br><h3> Price:</h3> <input type="text" class="form-control input-lg" name="price" />
							<br><h3>Select Category:</h3><select class="form-control input-lg" name="category">
  								<option>restaurants</option>
  								<option>electronics</option>
  								<option>movies_shows</option>
  								<option>vacation</option>
								</select>
							<br><h3> Date of expire(MM DD YY hh:mm:ss):</h3> <input type="text" class="form-control input-lg" name="doe" />
							<!--  <br><input type="submit"/> -->
							<br>
							<br>
							<div class="form-group">
        						<button type="submit" class="btn btn-primary btn-lg btn-block">Submit Query</button>
    						</div>
						</form>
						<br><h3 class="bg-warning">Query Status:<%=session.getAttribute("notification") %></h3>
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
