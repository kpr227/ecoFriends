<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li class="breadcrumb-item active">Login</li>
		</ul>
	</div><!-- /.container-fluid -->
</div><!-- /.breadcrumb-wrap -->
<!-- Breadcrumb End -->

<!-- Login Start -->
<div class="login">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<div class="login-form">
					<div class="row">
					<form id="loginForm" method="post" action="/login">
							<div class="col-md-6">
								<label>Id</label> 
								<input class="form-control" type="text" id="memberId" name="username" placeholder="id">
							</div>
							<div class="col-md-6">
								<label>Password</label> 
								<input class="form-control"	type="password" id="password" name="password" placeholder="Password">
							</div>
							<div class="col-md-12">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" name="remember-me" >자동로그인
								</div>
							</div>
							<div class="col-md-12"><input type="submit" id="btn_submit" class="btn" value="Login"></div>
							<div class="hidden-value">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							</div>
						</form>
					</div><!-- /. row -->
				</div><!-- /. login-form -->
			</div><!-- /. col-lg-6 -->
		</div><!-- /. row -->
	</div><!-- /. container-fluid -->
</div><!-- /. login  -->
<!-- Login End -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
<script type="text/javascript" src="/resources/cust/custRest.js?v=<%=System.currentTimeMillis()%>"></script>
<script>
	
</script>
    
<%@include file="../include/footer.jsp" %>        

