<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%session.setAttribute("isNew", false); %>
<%  
response.setHeader("Cache-Control","no-store"); //HTTP 1.1  
response.setHeader("Pragma","no-cache"); //HTTP 1.0  
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta charset="utf-8" />
	    <title>Simple Login Template | PrepBootstrap</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	     <!-- Bootstrap Core CSS -->
	    <link href="<%=request.getContextPath()+"/css/bootstrap.min.css" %>"rel="stylesheet" type="text/css">
	 	<link hreg="<%=request.getContextPath()+"/font-awesome/css/font-awesome.min.css" %>">
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</head>
	<body>
	
		<div class="container">
		
		<div class="page-header">
		    <h1>Final Details <small>Enter your Credit Card Details to finalize the purchase.</small></h1>
		</div>
		
		<!-- Simple Login - START -->
		<form class="col-md-6 col-md-offset-3">
		    <div class="form-group">
		        <input type="text" class="form-control input-lg" placeholder="Credit Card" name="cc">
		    </div>
		    <div class="form-group">
		        <input type="text" class="form-control input-lg" placeholder="Id number" name="ident">
		    </div>
		     <div class="form-group">
		        <input type="text" class="form-control input-lg" placeholder="c.v" name="cv">
		    </div>
		     <div class="form-group">
		        <button formaction="<%= request.getContextPath() +"/servlet/CouponUserServlet/finalpage"%>" class="btn btn-primary btn-lg btn-block">purchase</button>
		    </div>
		    <hr>
		</form>
		<!-- Simple Login - END -->
		 
		 <img class="img-responsive hidden-xs" src="${pageContext.request.contextPath}/images/creditcards.jpg" alt="" style="margin-left:30%;">
		 <img class="img-responsive visible-xs" src="${pageContext.request.contextPath}/images/creditcards.jpg" alt="" >
		 <hr>
		 <p>**this site is working in a secure manner to ensure the highest security possible for our customers.**</p>
		</div>
	</body>
</html>