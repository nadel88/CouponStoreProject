<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%  
response.setHeader("Cache-Control","no-store"); //HTTP 1.1  
response.setHeader("Pragma","no-cache"); //HTTP 1.0  
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%> 
<%session.setAttribute("isNew", true);session.setAttribute("permissions", 0); String notif = (String)session.getAttribute("usernotif"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta charset="utf-8" />
	    <title>Sign-Up</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" />
	    <link href="${pageContext.request.contextPath}/css/logo-nav.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</head>

	<body>

		<div class="container">
		
		<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/index"%>>
				<img class="hidden-xs" style="width:100px;height:auto;margin-top:-100px;" src="${pageContext.request.contextPath}/images/back_arrow.png" alt="" >
			</a>
			<a href=<%=request.getContextPath()+"/servlet/CouponUserServlet/index"%>>
				<img class="img-responsive visible-xs" style="width:80px;height:auto;margin-left:-10px;" src="${pageContext.request.contextPath}/images/back_arrow.png" alt="" >
			</a>
			
		<div class="page-header">
		    <h1>Sign-Up <small>Please choose a user name and password.<br>
		    If you have an account already please <a href=href=<%=request.getContextPath()+"/servlet/CouponUserServlet/login"%>>log-in</a></small></h1>
		</div>
		
		<!-- Simple Login - START -->
		<form class="col-md-6 col-md-offset-3" method="post">
		    <div class="form-group">
		        <input type="text" class="form-control input-lg" placeholder="User Name" name="userName">
		    </div>
		    <div class="form-group">
		        <input type="password" class="form-control input-lg" placeholder="Password" name="passWord">
		    </div>
		       <div class="form-group">
		        <input type="password" class="form-control input-lg" placeholder="Confirm Password" name="passWordCheck">
		    </div>
		    <div class="form-group">
		        <button formaction="<%= request.getContextPath() +"/servlet/LoginServlet"%>" class="btn btn-primary btn-lg btn-block">Sign In</button>
		    </div>
		    <br><h3 id="notification" class="bg-danger"><%=session.getAttribute("usernotif") %></h3>
		    
		</form>
		<!-- Simple Login - END -->
		
		</div>
	</body>
</html>