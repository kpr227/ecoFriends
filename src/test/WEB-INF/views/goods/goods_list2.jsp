<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECO FRIENDS</title>
<!-- Favicon -->
<link href="/resources/template/img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

<!-- CSS Libraries -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="/resources/template/lib/slick/slick.css" rel="stylesheet">
<link href="/resources/template/lib/slick/slick-theme.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="/resources/template/css/style.css" rel="stylesheet">
</head>

	<body>
        <!-- Top bar Start -->
        <div class="top-bar">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6">
                        <i class="fa fa-envelope"></i>
                        support@email.com
                    </div>
                    <div class="col-sm-6">
                        <i class="fa fa-phone-alt"></i>
                        +012-345-6789
                    </div>
                </div>
            </div>
        </div>
        <!-- Top bar End -->
        
        <!-- Nav Bar Start -->
        <div class="nav">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                    <a href="#" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="index.html" class="nav-item nav-link">Home</a>
                            <a href="product-list.html" class="nav-item nav-link active">상품</a>
                            <a href="product-detail.html" class="nav-item nav-link">Product Detail</a>
                            <a href="cart.html" class="nav-item nav-link">Cart</a>
                            <a href="checkout.html" class="nav-item nav-link">Checkout</a>
                            <a href="my-account.html" class="nav-item nav-link">My Account</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>
                                <div class="dropdown-menu">
                                    <a href="wishlist.html" class="dropdown-item">Wishlist</a>
                                    <a href="login.html" class="dropdown-item">Login & Register</a>
                                    <a href="contact.html" class="dropdown-item">Contact Us</a>
                                </div>
                            </div>
                        </div>
                        <div class="navbar-nav ml-auto">
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">User Account</a>
                                <div class="dropdown-menu">
                                    <a href="#" class="dropdown-item">Login</a>
                                    <a href="#" class="dropdown-item">Register</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->      
        
        <!-- Breadcrumb Start -->
        <div class="breadcrumb-wrap">
            <div class="container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">메인</a></li>
                    <li class="breadcrumb-item"><a href="#">상품</a></li>
                    <li class="breadcrumb-item active">상품리스트</li>
                </ul>
            </div>
        </div>
        <!-- Breadcrumb End -->
        
        <!-- Product List Start -->
        <div class="product-view">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="product-view-top">
                                    <div class="row">
                                    	
                                    	<form name="searchForm" action="/goods/rest" method="get">
                                    		<input type="hidden" id="pageNum" name="pageNum" value="${page.cri.pageNum }">
                                    		<input type="hidden" id="amount" name="amount" value="${page.cri.amount }">
                                    	
	                                        <div class="col-md-2">
	                                            <div class="product-short">
	                                                <div class="dropdown">
	                                            		<select class="dropdown-toggle" id="category" name="category">
														    <option value="" selected>전체</option>
	                                                   		<c:forEach var="cate" items="${cateList }" >
															    <option value="${cate.CATE_SEQ }" ${cri.category eq cate.CATE_SEQ ? 'selected' : ''}>${cate.CATE_NAME }</option>
	                                                    	</c:forEach>
														</select>
	                                                </div>
	                                            </div>
	                                        </div>                                    
	                                        <div class="col-md-3">
	                                            <div class="product-search">
	                                                <input type="text" id="keyword" name="keyword" value="${cri.keyword }" placeholder="상품명 검색">
	                                                <button><i class="fa fa-search"></i></button>
	                                            </div>
	                                        </div>
                                        </form>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="goods_list">
	                            <c:forEach var="list" items="${goodsList}">
									<div class="col-md-3">
		                                <div class="product-item">
		                                    <div class="product-title" style="height:100px;">
	                                        	<a href="/goods/${list.GOODS_SEQ }">${list.GOODS_NAME }</a>
		                                        <div class="ratting">
		                                            <i class="fa fa-star"></i>
		                                            <i class="fa fa-star"></i>
		                                            <i class="fa fa-star"></i>
		                                            <i class="fa fa-star-half-o"></i>
		                                            <i class="fa fa-star-o"></i>
		                                        </div>
		                                    </div>
		                                    <div class="product-image">
		                                        <a href="product-detail.html">
		                                            <img src="${list.IMG_URL }" alt="Product Image">
		                                        </a>
		                                        <div class="product-action">
		                                            <a href="/goods/${list.GOODS_SEQ }"><i class="fa fa-search"></i></a>
		                                        </div>
		                                    </div>
		                                    <div class="product-price">
		                                        <h3><fmt:formatNumber value="${list.PRICE }" pattern="#,###" /> &#8361;</h3>
		                                        <a class="btn" href="/goods/${list.GOODS_SEQ }"><i class="fa fa-shopping-cart"></i>사러가기</a>
		                                    </div>
		                                </div>
	                            	</div>
								</c:forEach>
							</div>
                        </div>
                        
                        <!-- Pagination Start -->
                        <div class="col-md-12">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                	<c:if test="${page.prev}">
										<li class="page-item disabled">
                                        	<a class="page-link" href="${page.startPage-1}" tabindex="-1">이전</a>
                                    	</li>
									</c:if>	
                                	
                                	<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
										<c:choose>
											<c:when test="${page.cri.pageNum eq num}">
												<li class="page-item active"><span class="page-link">${page.cri.pageNum }</span></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link" href="#">${num }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
                                    
                                    <c:if test="${page.next}">
                                    	<li class="page-item">
	                                        <a class="page-link" href="${page.endPage+1}">다음</a>
	                                    </li>
									</c:if>
                                </ul>
                            </nav>
                        </div>
                        <!-- Pagination end -->
                        
                    </div>           
                </div>
            </div>
        </div>
        <!-- Product List End -->  
        
        <!-- Footer Bottom Start -->
        <div class="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 copyright">
                        <p>Copyright &copy; <a href="https://htmlcodex.com">HTML Codex</a>. All Rights Reserved</p>
                    </div>

                    <div class="col-md-6 template-by">
                        <p>Template By <a href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->       
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="/resources/template/lib/easing/easing.min.js"></script>
        <script src="/resources/template/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="/resources/template/js/main.js"></script>
	</body>
</html>