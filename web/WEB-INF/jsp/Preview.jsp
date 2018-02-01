<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Movies Store a Entertainment Category Website Template | Preview :: w3layouts</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script> 
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
    </head>
    <body>
        <div class="header">
            <div class="headertop_desc">
                <div class="wrap">
                    <div class="nav_list">
                        <ul>
                            <li><a href="home.htm">Home</a></li>
                            <li><a href="contact.html">Sitemap</a></li>
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </div>
                    <div class="account_desc">
                        <ul>    
                            <li><a href="sellerlogin.htm">Sell</a></li>
                            <li><a href="#">Checkout</a></li>
                                <c:choose>
                                    <c:when test="${sessionScope.LoginDetails.name == null}" > 
                                    <div class="dropdown">
                                        <li><a href="#">MY Account</a></li>
                                        <div class="dropdown-content">
                                            <a href="registration.htm">Register</a>
                                            <a href="login.htm">Login</a>
                                        </div>
                                    </div>
                                </c:when >
                                <c:when test="${sessionScope.LoginDetails.name != null}" >
                                    <div class="dropdown">
                                        <li><a href="#">MY Account</a></li>
                                        <div class="dropdown-content">
                                            <a href="Logout.htm">Log Out</a>
                                            <a href="Myacc.htm">Welcome:${sessionScope.LoginDetails.name}</a>

                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    do nothing
                                </c:otherwise>
                            </c:choose>

                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="wrap">
                <div class="header_top">
                    <div class="logo">
                        <a href="home.htm"><img src="images/logo.jpg" width="200px" height="95px" alt="" /></a>
                    </div>
                    <div class="header_top_right">
                        <div class="cart">
                            <p><span>Cart</span><div id="dd" class="wrapper-dropdown-2"> (empty)
                                <ul class="dropdown">
                                    <li>you have no items in your Shopping cart</li>
                                </ul></div></p>
                        </div>
                        <div class="search_box">
                            <form>
                                <input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Search';
                                        }"><input type="submit" value="">
                            </form>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <script type="text/javascript">
                        function DropDown(el) {
                            this.dd = el;
                            this.initEvents();
                        }
                        DropDown.prototype = {
                            initEvents: function () {
                                var obj = this;

                                obj.dd.on('click', function (event) {
                                    $(this).toggleClass('active');
                                    event.stopPropagation();
                                });
                            }
                        }

                        $(function () {

                            var dd = new DropDown($('#dd'));

                            $(document).click(function () {
                                // all dropdowns
                                $('.wrapper-dropdown-2').removeClass('active');
                            });

                        });
                    </script>
                    <div class="clear"></div>
                </div>     				
            </div>
        </div>
        <div class="main">
            <div class="wrap">
                <div class="content_top">
                    <div class="back-links">
                        <p><a href="home.htm">Home</a> &gt;&gt;&gt;&gt; <a href="#" class="active">English</a></p>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="section group">
                    <form:form commandName="singleproduct" method="post" action="bookAction.htm"> 
                        <div class="cont-desc span_1_of_2">
                            <div class="product-details">
                                <div class="grid images_3_of_2">
                                    <img  src="/EventManagement/myImage.htm?id=${singleproduct.productId}" width="250px" height="250px" alt="" />
                                </div>
                                <div class="desc span_3_of_2">
                                    <h2>${singleproduct.productName}</h2>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>					
                                    <div class="price">
                                        <p>
                                            Price:<span>${singleproduct.price}</span>
                                            <input type="hidden" name="productId" value="${singleproduct.productId}"/>      
                                            <input type="hidden" name="productName" value="${singleproduct.productName}"/>    
                                            <input type="hidden" name="price" value="${singleproduct.price}"/>    
                                        </p>
                                    </div>
                                    <div class="available">
                                        <ul>
                                            <li><span>Model:</span> &nbsp; Model 1</li>
                                            <li><span>Shipping Weight:</span>&nbsp; 5lbs</li>
                                            <li><span>Units in Stock:</span>&nbsp; 566</li>
                                        </ul>
                                    </div>
                                    <div class="share-desc">

                                        <div class="clear"></div><br></br>
                                    </div>
                                    <div class="share-desc">
                                        <div class="button">
                                            <p>
                                                <input type="submit" name="addCart" value="Add to Cart">
                                                <input type="submit" name="book" value="Book">
                                            </p>
                                        </div>					
                                        <div class="clear"></div>
                                    </div>

                                </div>
                                <div class="clear"></div>

                            </div>
                            <div class="product_desc">	
                                <h2>Details :</h2>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                            </div>
                        </div> 
                    </form:form>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="wrap">	
                <div class="section group">
                    <div class="col_1_of_4 span_1_of_4">
                        <h4>PRODUCTS</h4>
                        <ul>
                            <li><a href="Puja.htm">Puja</a></li>
                            <li><a href="Wedding.htm">Wedding</a></li>
                            <li><a href="Birthday.htm">BIRTHDAY</a></li>
                            <li><a href="Meeting.htm">Meeting</a></li>
                        </ul>
                    </div>                    
                    <div class="col_1_of_4 span_1_of_4">
                        <h4>Contact</h4>
                        <ul>
                            <li><span>+918158042069</span></li>
                            <li><span>suvasmnt@yahoo.in</span></li>
                        </ul>
                    </div>
                </div>
                <div class="copy_right">
                    <p>© Movies Store. All Rights Reserved | Design by  <a href="http://w3layouts.com">W3Layouts</a> </p>
                </div>			
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <a href="#" id="toTop"><span id="toTopHover"> </span></a>
    </body>
</html>

