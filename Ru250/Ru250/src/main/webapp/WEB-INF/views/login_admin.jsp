
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html lang="cn">
	<head>
		<meta charset="utf-8" />
		<title>Login</title>

		<!-- basic styles -->

		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/jquery.gritter.css">
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		
		
		
		<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<!-- page specific plugin styles -->
<!-- jqgrid -->


		
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		
		<!-- basic js -->
		
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									
									<span class="red">Stock Prediction System</span>
								</h1>
								<h4 class="blue">&copy; Group 19</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												Sign in 
											</h4>

											<div class="space-6"></div>

<%-- 											<form action="<%=basePath%>/login" method="post">
 --%>
 												<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="userName" id="username" placeholder="username" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="pwd" id="pwd" placeholder="password" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>

														<button id="log" type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															Login
														</button>
													</div>

													<div class="space-4"></div>
<%-- 											</form>
 --%>											
										</div><!-- /widget-main -->

										<div class="toolbar clearfix" style="align:center">
											<div>
												<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													I want to register
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												New User Registration
											</h4>

											<div class="space-6"></div>
											<p> Enter your details to begin: </p>

											<form action="<%=basePath%>/addUser" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="email" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="userName" placeholder="Username" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="pwd" placeholder="Password" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="repwd" placeholder="Repeat password" />
															<i class="icon-retweet"></i>
														</span>
													</label>

													<label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>
															Reset
														</button>

														<button type="submit" class="width-65 pull-right btn btn-sm btn-success">
															Register
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
<!-- 		<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5" />
 -->		
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript" src="assets/js/jquery-2.0.3.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			}
		</script>
		
		<script type="text/javascript">
		function error(e) {
			$.gritter.add({
				title : 'This is a warning notification',
				text : e,
				time : '3000',
				class_name : 'gritter-error gritter-center'
			});
	
			return false;
		}

		$( "#log" ).click(function(){
			var name=$("#username").val();
		 	var pwd=$("#pwd").val();
		 	alert(name);
		 	var regx=/^\w{4,20}$/;
		 	var a=1;
		 	var b=1;
		 	
		 	if(pwd==""){
		 		error("Please enter you password!");
		 		b=0;
		 	}

			if((a&&b)==1){
				var url="login?userName="+name+"&pwd="+pwd;
				$.ajax({
					type : "GET", 
					url:url,
				    dataType:"json",
				    contentType:'application/json;charset=UTF-8',
				    success : function(user) {
				    	alert(user.usertype);
				        if(usertype=""){
				        	alert("user isn't exist or password is wrong!")
				        }else{
				        	if(user.usertype=="2"){
				        		alert("right");
				        		window.location='mainpage_login_admin';
				        	}else{
				        		alert("wrong");
			        			window.location='mainpage_login';
				        	}
				        }
				    }
				   });
					 
		  	}	 /*  */
		});
    	</script>
</body>
</html>
