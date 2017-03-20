<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style1.css">
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="container">
			<div class="col-md-12">
				<h1>Bootstrap 3 Thumbnail Slider</h1>

				<div class="well">
					<div id="myCarousel" class="carousel slide">

						<!-- Carousel items -->
						<div class="carousel-inner">

							<c:forEach  begin="1" end="6" var="x">
								 <c:if test="${x==1}">
									<div class="item active">
								</c:if>
								 <c:if test="${x!=1}">
								<div class="item">
									 </c:if>
 
									<div class="row">
									<c:forEach  begin="1" end="4">
										<div class="col-sm-3">
											<a href="#x"><img src="http://placehold.it/500x500"
												alt="Image" class="img-responsive"></a>
										</div>
										</c:forEach>
										
								
									</div>
								</div>
							</c:forEach>
						</div>

						<!--/row-->
					</div>

				</div>
				<!--/carousel-inner-->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">Prv</a> <a class="right carousel-control"
					href="#myCarousel" data-slide="next">Nxt</a>
			</div>
			<!--/myCarousel-->
		</div>
		<!--/well-->
	</div>
	</div>

	</div>
	<!-- /.container -->



</body>
</html>
