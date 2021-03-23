<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>E Store - eCommerce HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="eCommerce HTML Template Free Download" name="keywords">
        <meta content="eCommerce HTML Template Free Download" name="description">
		
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
                    <a href="" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="index.html" class="nav-item nav-link">Home</a>
                            <a href="product-list.html" class="nav-item nav-link">Products</a>
                            <a href="product-detail.html" class="nav-item nav-link">Product Detail</a>
                            <a href="cart.html" class="nav-item nav-link active">Cart</a>
                            <a href="checkout.html" class="nav-item nav-link">Checkout</a>
                            <a href="my-account.html" class="nav-item nav-link">My Account</a>
                            <div class="nav-item dropdown">
                                <a href="" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>
                                <div class="dropdown-menu">
                                    <a href="wishlist.html" class="dropdown-item">Wishlist</a>
                                    <a href="login.html" class="dropdown-item">Login & Register</a>
                                    <a href="contact.html" class="dropdown-item">Contact Us</a>
                                </div>
                            </div>
                        </div>
                        <div class="navbar-nav ml-auto">
                            <div class="nav-item dropdown">
                                <a href="" class="nav-link dropdown-toggle" data-toggle="dropdown">User Account</a>
                                <div class="dropdown-menu">
                                    <a href="" class="dropdown-item">Login</a>
                                    <a href="" class="dropdown-item">Register</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->      
        
        <!-- Bottom Bar Start -->
        <div class="bottom-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a href="index.html">
                                <img src="/resources/template/img/logo.png" alt="Logo">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="search">
                            <input type="text" placeholder="Search">
                            <button><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="user">
                            <a href="wishlist.html" class="btn wishlist">
                                <i class="fa fa-heart"></i>
                                <span>(0)</span>
                            </a>
                            <a href="cart.html" class="btn cart">
                                <i class="fa fa-shopping-cart"></i>
                                <span>(0)</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bottom Bar End -->
        
        <!-- Breadcrumb Start -->
        <div class="breadcrumb-wrap">
            <div class="container-fluid">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item"><a href="">Home</a></li>
                    <li class="breadcrumb-item"><a href="">Products</a></li>
                    <li class="breadcrumb-item active">Cart</li>
                </ul>
            </div>
        </div>
        <!-- Breadcrumb End -->
        
        <!-- Cart Start -->
        <div class="cart-page">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="cart-page-inner">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Product</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody class="align-middle orderList">
                                     
                                                                         
                                    </tbody>
                                    
                                </table>
                                
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="cart-page-inner">
                            <div class="row">                               
                                <div class="col-md-12">
                                    <div class="cart-summary ">
                                        <div class="cart-content">
                                            <h1>Ordered</h1>
                                            <p class="sub-total">Sub Total<span class="sub-total-price">$99</span></p>
                                            <p class="ship-cost">Shipping Cost<span>$1</span></p>
                                            <h2>Grand Total<span class="grand-total-price totalPrice">100</span></h2>
                                        </div>
                                        <div class="cart-btn">
                                            <button class="cancelOrderBtn">주문 취소</button>
                                            <button class="orderCommit">주문 확정</button>
                                        </div>
                                        <div class="checkout-btn">
                                   			 <!-- <button class="deliverySearch">배송조회</button> -->
                                   			 <button type="button" class="btn btn-primary deliverySearch" data-toggle="modal" data-target=".bd-example-modal-lg">배송조회</button>
                               			 </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->
        
        <!-- Footer Start -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Get in Touch</h2>
                            <div class="contact-info">
                                <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                                <p><i class="fa fa-envelope"></i>email@example.com</p>
                                <p><i class="fa fa-phone"></i>+123-456-7890</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Follow Us</h2>
                            <div class="contact-info">
                                <div class="social">
                                    <a href=""><i class="fab fa-twitter"></i></a>
                                    <a href=""><i class="fab fa-facebook-f"></i></a>
                                    <a href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a href=""><i class="fab fa-instagram"></i></a>
                                    <a href=""><i class="fab fa-youtube"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Company Info</h2>
                            <ul>
                                <li><a href="">About Us</a></li>
                                <li><a href="">Privacy Policy</a></li>
                                <li><a href="">Terms & Condition</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Purchase Info</h2>
                            <ul>
                                <li><a href="">Pyament Policy</a></li>
                                <li><a href="">Shipping Policy</a></li>
                                <li><a href="">Return Policy</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="row payment align-items-center">
                    <div class="col-md-6">
                        <div class="payment-method">
                            <h2>We Accept:</h2>
                            <img src="/resources/template/img/payment-method.png" alt="Payment Method" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="payment-security">
                            <h2>Secured By:</h2>
                            <img src="/resources/template/img/godaddy.svg" alt="Payment Security" />
                            <img src="/resources/template/img/norton.svg" alt="Payment Security" />
                            <img src="/resources/template/img/ssl.svg" alt="Payment Security" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->
        
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
        
        <!--modal  -->
        <div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-xl" role="document">
		    <div class="modal-content">
		      <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>송장번호</th>
                                            <th>배송상태</th>
                                            <th>날짜</th>
                                            <th>비고</th>
                                        </tr>
                                    </thead>
                                    <tbody class="align-middle shipInfo">
                                    
                                                                         
                                    </tbody>
                                    
                                </table>
                                
                  </div>
		    </div>
		  </div>
		</div>
        
      
             
        
        <!-- Back to Top -->
        <a href="" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="/resources/template/lib/easing/easing.min.js"></script>
        <script src="/resources/template/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="/resources/template/js/main.js?var=2"></script>
        <script src="/resources/basket/basket.js?ver=6"></script>
		<script src="/resources/basket/transferTime.js"></script>
		<script src="/resources/order/checkout.js?ver=5"></script>
    </body>
    
    <script>
    $(document).ready(function(){
    	showList();
    });
 
  	//상품제목 <p>클릭시
  	$('.basketList').on('click', "p",function () {
  		var goods_seq =  $(this).data("goods_seq");
    	console.log("버튼클릭goods_seq: "+goods_seq);
      //현재 버튼클릭시 해당 goods_seq선택가능-->Ajax로 연동
		selectBasketGoods(goods_seq);    
    });
	
  	//주문취소
	$('.cancelOrderBtn').on('click',function(){
		if(window.confirm('really?')){
			console.log("주문취소 시작");
			checkoutService.getShipStatus('basic',function(shipStatus){
				if(Number(shipStatus[0].delivery_status)===0){
					console.log("주문취소 로직 실행");
					checkoutService.orderCancel(2);
				}else{
					alert("현재 배송중인 상품은 취소가 불가능 합니다");
					return;
				}
			});
		}
	});
  	
	//배송조회
	$('.deliverySearch').on('click',function(){
		$(".modal").modal("show");
		checkoutService.getShipStatus('basic',function(shipStatus){
			console.log("jsp"+shipStatus[0].delivery_status);
			var str="";
			var shipInfoTable=$(".shipInfo");
			
			for(var i=0,len=shipStatus.length||0;i<len;i++){
			str+="<tr>"
             	+"	<td>"+shipStatus[i].invoice_no+"</td>"
             	+"	<td>"+shipStatus[i].delivery_status+"</td>"
             	+"	<td>"+shipStatus[i].editDate+"</td>"
             	+"	<td>"+shipStatus[i].delivery_company+"</td>"
         		+"</tr>"
			}
			shipInfoTable.html(str);
		});		
	});
  
	$('.orderCommit').on('click',function(){
		var totalPrice = $('.totalPrice').text();
		var point = Number(totalPrice)*0.1;
		var point2 = parseInt(totalPrice);
		
		console.log("적립 point: "+point);
		if(window.confirm('주문확정시 환불이 불가능 합니다 주문확정을 하시겠습니까?')){
			checkoutService.orderCommit(2,point,'basic');
		}
		
		
	});
	
	function showList(){		
		checkoutService.getOrderList("basic",function(ordertList){
			var orderListTable=$(".orderList");
			var str="";
			console.log(ordertList);
			for(var i=0,len=ordertList.length||0;i<len;i++){
				 //"+ordertList[i].IMG_URL+"
				str+="<tr>"
	                +"   <td>"
	                +"        <div class='img'>"
	                +"            <a href=''><img src='/resources/template/img/product-1.jpg' alt='Image'></a>"		               
	                +"            <p data-goods_seq='"+ordertList[i].GOODS_SEQ+"'>"+ordertList[i].GOODS_NAME+"</p>"
	                +"        </div>"
	                +"    </td>"
	                +"    <td><span>"+ordertList[i].PRICE+"</span></td>"
	                +"    <td>"
	                +"        <div class='qty' data-goods_seq='"+ordertList[i].GOODS_SEQ+"'>"
	                +"            <input type='text' value='"+ordertList[i].QTY+"' readonly=readonly>"
	                +"        </div>"
	                +"    </td>"
	                +"    <td><span class='calPrice"+[i]+"'>"+Number(ordertList[i].PRICE)*Number(ordertList[i].QTY)+"</span></td>"                                           
           		    +"</tr>"
					
			}
			orderListTable.html(str);
			 /* $(".grand-total-price").html(checkoutInfo.TOTAL_PRICE);
             var shippingCost = 1;
             $(".sub-total-price").html(checkoutInfo.TOTAL_PRICE-shippingCost); */
		})
	}
    </script>
</html>