<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%session.setAttribute("isNew", true);session.setAttribute("permissions", 0); String notif = (String)session.getAttribute("usernotif"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>Simple Login Template | PrepBootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

<div class="page-header">
    <h1>Sign-in <small>Please choose a user name and password.</small></h1>
</div>

<!-- Simple Login - START -->
<form class="col-md-6 col-md-offset-3">
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
    <br><h3 class="bg-danger">Query Status:<%=session.getAttribute("usernotif") %></h3>
    
</form>
<!-- Simple Login - END -->

</div>
</body>
</html>