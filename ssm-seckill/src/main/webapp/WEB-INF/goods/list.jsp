<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>商品列表</title>

<!-- Bootstrap -->
<link href='<c:url value="/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="/css/main.css"></c:url>' rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<form class="form-inline"
					action='<c:url value="/goods/list"></c:url>'>
					<div class="form-group">
						<label class="sr-only" for="exampleInputAmount"></label>
						<div class="input-group">
							<div class="input-group-addon">关键字</div>
							<input type="text" name="keyword" class="form-control"
								id="exampleInputAmount" placeholder="关键字">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">搜索</button>
				</form>
				<table class="table table-bordered" style="background-color: white;">
					<tr>
						<th>标题</th>
						<th>
							数量
							<a href='<c:url value="/goods/list?count=false"></c:url>'>
								<span class="glyphicon glyphicon-triangle-top"
									aria-hidden="true"></span>
							</a>
							<a href='<c:url value="/goods/list?count=true"></c:url>'>
								<span class="glyphicon glyphicon-triangle-bottom"
									aria-hidden="true"></span>
							</a>
						</th>
						<th>开始时间</th>
						<th>结束时间</th>
					</tr>
					<c:forEach items="${dto.list }" var="goods">
						<tr>
							<td>
								<a href='<c:url value="/goods/detail?id=${goods.id }"></c:url>'>${goods.name }</a>
							</td>
							<td>${goods.count }</td>
							<td>${goods.beginTime }</td>
							<td>${goods.endTime }</td>
						</tr>
					</c:forEach>
				</table>

				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li>
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<c:forEach begin="1" end="${dto.pageCount }" varStatus="index">
							<li>
								<a href='<c:url value="/goods/list?pageIndex=${index.count }"></c:url>'>${index.count }</a>
							</li>
						</c:forEach>
						<li>
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${dto.list }" var="goods">
				<div class="col-md-4 goods-cell">
					<div class="goods-cell-container text-center">
						<img src='<c:url value="/upload/1.jpg"></c:url>'
							class="img-rounded goods-cell-container-image">
						<p class="goods-cell-container-name">${goods.name }</p>
						<div class="row goods-cell-container-seckill">
							<div class="col-md-8">
								<p class="goods-cell-container-seckill-price">
									<span
										class="glyphicon glyphicon-yen goods-cell-container-seckill-price-icon"
										aria-hidden="true"></span>${goods.price }</p>
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="60"
										aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
										已售：60%</div>
								</div>
							</div>
							<div class="col-md-4">
								<a
									class="btn btn-danger btn-lg goods-cell-container-seckill-seckill"
									href='<c:url value="/goods/detail?id=${goods.id }"></c:url>'
									role="button">立即抢购</a>
							</div>
						</div>
					</div>

				</div>

			</c:forEach>

		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src='<c:url value="/js/jquery-3.2.1.min.js"></c:url>'></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
</body>
</html>