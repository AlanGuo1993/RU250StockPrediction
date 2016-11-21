<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Stock Prediction System</title>
		<link href="assets/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="assets/css/font-awesome.min.css">
		
		<link rel="stylesheet" href="assets/css/jquery.gritter.css" />
		
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />		
		<!-- page specific plugin styles -->
		<!-- jqgrid -->
		<link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.full.min.css">
		<link rel="stylesheet" href="assets/css/datepicker.css" />
		<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />

		<!--<link rel="stylesheet" href="assets/css/mySplitter.css">-->
		
		<link rel="stylesheet" href="assets/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="assets/css/search.css" />
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							Stock Prediction System
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
                    <!--
                    <li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									Jason
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										Profile
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
                     -->
					<li class="light-blue">
                    <a href="aboutus">About Us</a>
                    </li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li id="mainpage" class="active">
							<a id="home" href="#">
								<i class="icon-home"></i>
								<span class="menu-text"> Home </span>
							</a>
						</li>
						 
						<li id="google" onclick="hideContent('GOOG')" >
							<a href='#'>
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Google </span>
							</a>
						</li>
						<li id="microsoft" onclick="hideContent('MSFT')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Microsoft </span>
							</a>
						</li>
						<li id="amazon" onclick="hideContent('AMZN')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Amazon </span>
							</a>
						</li>
						<li id="oracle" onclick="hideContent('ORCL')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Oracle </span>
							</a>
						</li>
						<li id="yahoo" onclick="hideContent('YHOO')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Yahoo </span>
							</a>
						</li>
						<li id="linkedin" onclick="hideContent('LNKD')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> LinkedIn </span>
							</a>
						</li>
						<li id="fb" onclick="hideContent('FB')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Facebook </span>
							</a>
						</li>
						<li id="intel" onclick="hideContent('INTC')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Intel </span>
							</a>
						</li>
						<li id="cisco" onclick="hideContent('CSCO')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Cisco </span>
							</a>
						</li>
						<li id="apple" onclick="hideContent('AAPL')">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> Apple </span>
							</a>
						</li>
					

					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul id="process" class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>

						</ul><!-- .breadcrumb -->

					</div>
					<div id="stock" style="display:none;">
						<div id="container4" style="height: 100%; width: 100%"></div>
						<h4>
						<div>The highest stock price of <span id="stockName"></span> in the last ten days:<span id="highest"></span></div>
						<div>Average stock price of <span id="stockName1"></span> in the latest one year:<span id="avg"></span></div>
						<div>Lowest stock price for <span id="stockName2"></span> in the latest one year:<span id="lowest"></span></div>
						</h4>
						<div class="tabbable">
							<ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
								<li class="active">
									<a data-toggle="tab" href="#home4">Bayesian Curve-fitting</a>
								</li>
 								<li>
									<a data-toggle="tab" href="#profile4">Support Vector Machine</a>
								</li>

								<li>
									<a data-toggle="tab" href="#dropdown14">Artifical Neural Networks</a>
								</li>
							</ul>

							<div class="tab-content">
								<div id="home4" class="tab-pane in active">
									Prediction:<span id="prediction1"></span>
								</div>

								<div id="profile4" class="tab-pane">
									Prediction:	<span id="prediction2"></span>						
								</div>

								<div id="dropdown14" class="tab-pane">
									<div class="row">
										<div class="col-xs-8">
										<div id="containerA" style="height: 400px; min-width: 610px"></div>
										</div>	
										<div class="col-xs-4">	
										<h1>
											Suggestion:
											<br>
										</h1>
										<h2>
										
											KDJ:<div id="kdj"></div>
											<br>
											MACD:<div id="macd"></div>
											<br>
											RSI:<div id="rsi"></div>
											<br>
											Average Prediction:<div id="avgAnn"></div>
										</h2>
										</div>
									</div>						
								</div>
							</div>
						</div>
					</div>

					<div id="main" class="page-content">
						<!-- <div class="search"  style="margin-left:380px;">
                            <span class="s_con"><input id="stockname" type="text" class="content" placeholder="Search"><i class="clear"></i>
                            </span>
                            <span class="s_btn" id="search_button" onclick='hideContent()'>Search</span> 
                       	</div> -->

                        <div class="row" style="margin-top:110px"> 
	                        <div class="col-xs-6">
	                        <div id="container" style="height: 400px; min-width: 310px">
	
	                        </div>
	                        </div>
	                        <div class="col-xs-6">
	                        <div id="container1" style="height: 400px; min-width: 310px"></div>
	                        </div>
                        
                        </div>
                        <div>The companies who have the average stock price lesser than the lowest of Google in the latest one year:<span id="lower"></span></div>         
                        
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>


		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
<!-- 		<script src="https://code.highcharts.com/highcharts.js"></script>
 -->
		<script src="https://code.highcharts.com/stock/highstock.js"></script>
		<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
		$(function () {	
			//var urll = "http://localhost:8080/Ru250/lowerthanGOOG";
			//alert("1");
			$.ajax({
				type : "GET", 
				url:"lowerthanGOOG",
			    dataType:"json",
			    contentType:'application/json;charset=UTF-8',
			    success : function(data) {
			    	//alert(data);
			    	$( "#lower" ).text( data );
			        }
			    
			   });
		});
		
	function hideContent(name){
			//alert(name);
			$( "#stockName" ).text( name );
			$( "#stockName1" ).text( name );
			$( "#stockName2" ).text( name );
		    var url = "searchhstock?name="+name;
			
		    $.getJSON(url, 				function (data) {
		    	
			    // Create the chart
			    $('#container4').highcharts('StockChart', {


			        rangeSelector : {
			            selected : 1
			        },

			        title : {
			            text : ' Stock Price'
			        },

			        series : [{
			            name : name,
			            data : data,
			            tooltip: {
			                valueDecimals: 2
			            }
			        }]
			    });
			});
			var content =document.getElementById("main");
			content.style.display='none';
			var stock =  document.getElementById("stock");
			stock.style.display='block';
			
			/*Highest value*/
			var url1 = "highest?name="+name;
			$.ajax({
				type : "GET", 
				url:url1,
			    dataType:"json",
			    contentType:'application/json;charset=UTF-8',
			    success : function(data) {
			    	$( "#highest" ).text( data );
			        }
			    
			   });
			/*Average stock price in the latest one year*/
			var url2 = "avgstock?name="+name;
			$.ajax({
				type : "GET", 
				url:url2,
			    dataType:"json",
			    contentType:'application/json;charset=UTF-8',
			    success : function(data) {
			    	$( "#avg" ).text( data );
			        }
			    
			   });
			
			/*Lowest stock price in the latest one year*/
			var url3 = "lowest?name="+name;
			$.ajax({
				type : "GET", 
				url:url3,
			    dataType:"json",
			    contentType:'application/json;charset=UTF-8',
			    success : function(data) {
			    	$( "#lowest" ).text( data );
			        }
			    
			   });
			
			var url4 = "predictBayesian?name="+name;
			$.ajax({
				type : "GET", 
				url:url4,
			    dataType:"json",
			    contentType:'application/json;charset=UTF-8',
			    success : function(data) {
			    	$( "#prediction1" ).text( data );
			        }
			    
			   });
			
			var url5 = "predictAnn?name="+name;
			 $.getJSON(url5, 				function (data) {
			    	
				    // Create the chart
				 $('#containerA').highcharts({
				        chart: {
				            type: 'line'
				        },
				        title: {
				            text: 'Predict Price in future ten days'
				        },
				     
				        xAxis: {
				            categories: ['Day1', 'Day2', 'Day3', 'Day4', 'Day5', 'Day6', 'Day7', 'Day8', 'Day9', 'Day10']
				        },
				        yAxis: {
				            title: {
				                text: 'price'
				            }
				        },
				        plotOptions: {
				            line: {
				                dataLabels: {
				                    enabled: true
				                },
				                enableMouseTracking: false
				            }
				        },
				        series: [{
				            name: name,
				            data: data
				        }]
				    });
				});
			 
				var sell = "<button class='btn btn-xs btn-danger'>sell out</button>";
			 	var hold = "<button class='btn btn-xs btn-yellow'>hold and see</button>";
			 	var buy = "<button class='btn btn-xs btn-green'>buy in</button>";
			 	
				 var url6 = "kdj?name="+name;
				 $.ajax({
					type : "GET", 
					url:url6,
				    dataType:"json",
				    contentType:'application/json;charset=UTF-8',
				    success : function(data) {
				        if(data == -1){
				    		document.getElementById("kdj").innerHTML = sell;
				    	}else if(data == 0){
				    		document.getElementById("kdj").innerHTML = hold;
				    	}else{
				    		document.getElementById("kdj").innerHTML = buy;
				    	} 
				       }
				    
				   }); 
				 
				 var url7 = "macd?name="+name;
				 $.ajax({
					type : "GET", 
					url:url7,
				    dataType:"json",
				    contentType:'application/json;charset=UTF-8',
				    success : function(data) {
				        if(data == -1){
				    		document.getElementById("macd").innerHTML = sell;
				    	}else if(data == 0){
				    		document.getElementById("macd").innerHTML = hold;
				    	}else{
				    		document.getElementById("macd").innerHTML = buy;
				    	} 
				       }
				    
				   }); 
				 
				 var url8 = "rsi?name="+name;
				 $.ajax({
					type : "GET", 
					url:url8,
				    dataType:"json",
				    contentType:'application/json;charset=UTF-8',
				    success : function(data) {
				        if(data == -1){
				    		document.getElementById("rsi").innerHTML = sell;
				    	}else if(data == 0){
				    		document.getElementById("rsi").innerHTML = hold;
				    	}else{
				    		document.getElementById("rsi").innerHTML = buy;
				    	} 
				       }
				    
				   }); 
				 
				 var url9 = "avgAnn?name="+name;
				 $.ajax({
					type : "GET", 
					url:url9,
				    dataType:"json",
				    contentType:'application/json;charset=UTF-8',
				    success : function(data) {
				        if(data == -1){
				    		document.getElementById("avgAnn").innerHTML = sell;
				    	}else if(data == 0){
				    		document.getElementById("avgAnn").innerHTML = hold;
				    	}else{
				    		document.getElementById("avgAnn").innerHTML = buy;
				    	} 
				       }
				    
				   }); 
				 
				 var url10 = "predictSvn?name="+name;
				 $.ajax({
					type : "GET", 
					url:url10,
				    dataType:"json",
				    contentType:'application/json;charset=UTF-8',
				    success : function(data) {
				        $("#prediction2").text(data);
				       }
				    
				   });
				 
	}
		
/*		function del(n){
				var s=document.getElementById('process');
				var t=s.childNodes.length;
				for (var i=0;i<t;i++){
					if (i==n-1){
						s.removeChild(s.childNodes[i]);
	   				}
				}
		}
				
 		function clearAndSetBread(el){
		
				// clear all breadcrumb first
				del(3);
				
				// set breadcrumb
				var s = document.getElementById('process');
				var t = s.childNodes.length;
				var li = document.createElement("li");
				li.innerHTML = el;
				s.appendChild(li); 
		}
		
		
		function clearAndSetActiveStates(el) {
		
				// clear all active states first
				$('#mainpage').removeClass("active");				
				// set active state
				el.parent().addClass("active");		
		} */
		
jQuery(function($) {
			$("#home").on('click',function(){

						location.reload();
				
			});

});
		
		

$(function () {
		$.getJSON('searchhstock?name=GOOG', 				function (data) {
        // Create the chart
        $('#container').highcharts('StockChart', {


            rangeSelector : {
                selected : 1
            },

            title : {
                text : 'Google Stock Price'
            },

            series : [{
                name : 'GOOG',
                data : data,
                tooltip: {
                    valueDecimals: 2
                }
            }]
        });
    });

});
$(function () {
		$.getJSON('searchhstock?name=MSFT', 				function (data) {
        // Create the chart
        $('#container1').highcharts('StockChart', {


            rangeSelector : {
                selected : 1
            },

            title : {
                text : 'Microsoft Stock Price'
            },

            series : [{
                name : 'MSFT',
                data : data,
                tooltip: {
                    valueDecimals: 2
                }
            }]
        });
    });

});





/* $(function () {
	$.getJSON('https://www.highcharts.com/samples/data/jsonp.php?filename=aapl-c.json&callback=?', 				function (data) {
    // Create the chart
    $('#containerA').highcharts('StockChart', {


        rangeSelector : {
            selected : 1
        },

        title : {
            text : 'Microsoft Stock Price'
        },

        series : [{
            name : 'MSFT',
            data : data,
            tooltip: {
                valueDecimals: 2
            }
        }]
    });
});

});


 */        </script>
</body>
</html>
