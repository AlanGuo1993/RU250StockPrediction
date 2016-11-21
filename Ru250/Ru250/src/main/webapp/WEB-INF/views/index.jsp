<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

	<head>
		<base href="<%=basePath%>">
		<title>Spring MVC Starter Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style type="text/css">
		*{
			margin: 0 auto;
			padding: 0
		}
		</style>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="https://code.highcharts.com/highcharts.js"></script>
        <script type="text/javascript" src="https://code.highcharts.com/modules/exporting.js"></script>
	</head>

	<body>
	<div align="center">
		<h1>Software Engineering of Web Applications - Spring 2016</h1>
		<h1>Group Project</h1>
		<br/>
		<h2>Guojun Ren,	Xinhe Gao,	Li Yin,	Qianyu Wang,	Ao Guo</h2>
		<br/><!-- 
		<img alt="" src="https://sebs.rutgers.edu/images/rutgers250-logo.png"> -->
		<div id="container" style="min-width: 110px; height: 400px; margin: 0 auto"></div>
		<br/>
		<a href="persons"><h2>GO RUTGERS<h2></a>
		<a href="new"><h2>Test a new Jsp</h2></a>
	</div>
	<script type="text/javascript">
			$(function () {
			    $.getJSON('https://www.highcharts.com/samples/data/jsonp.php?filename=usdeur.json&callback=?', function (data) {

			        $('#container').highcharts({
			            chart: {
			                zoomType: 'x'
			            },
			            title: {
			                text: 'USD to EUR exchange rate over time'
			            },
			            subtitle: {
			                text: document.ontouchstart === undefined ?
			                        'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
			            },
			            xAxis: {
			                type: 'datetime'
			            },
			            yAxis: {
			                title: {
			                    text: 'Exchange rate'
			                }
			            },
			            legend: {
			                enabled: false
			            },
			            plotOptions: {
			                area: {
			                    fillColor: {
			                        linearGradient: {
			                            x1: 0,
			                            y1: 0,
			                            x2: 0,
			                            y2: 1
			                        },
			                        stops: [
			                            [0, Highcharts.getOptions().colors[0]],
			                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
			                        ]
			                    },
			                    marker: {
			                        radius: 2
			                    },
			                    lineWidth: 1,
			                    states: {
			                        hover: {
			                            lineWidth: 1
			                        }
			                    },
			                    threshold: null
			                }
			            },

			            series: [{
			                type: 'area',
			                name: 'USD to EUR',
			                data: data
			            }]
			        });
			    });
			});
			</script>
	</body>
</html>
