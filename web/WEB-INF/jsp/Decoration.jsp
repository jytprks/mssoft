<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Movies Store a Entertainment Category Website Template | Home :: w3layouts</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script> 
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
        <script type="text/javascript">
            $(window).load(function () {
                $('#slider').nivoSlider();
            });
        </script>
    </head>
    <body>
        <div class="header">
            <div class="headertop_desc">
                                <div class="wrap">
                    <div class="nav_list">
                        <ul>
                            <li><a href="home.htm">Home</a></li>
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
                                            <a href="Myacc.htm">HELLOW:${sessionScope.LoginDetails.name}</a>
                                           
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
                        <a href="index.html"><img src="images/logo.jpg" width="200px" height="95px" alt="" /></a>
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
                <div class="header_bottom">
                    <div class="header_bottom_left">				
                        <div class="categories">
                            <ul>
                                <h3>Categories</h3>
                                <li><a href="#">ALL</a></li>
                                 <li><a href="Decoration.htm">DECORATERS</a></li>
                                </ul>
                        </div>					
                    </div>
                    <div class="header_bottom_right">					 
                        <!------ Slider ------------>
                        <div class="slider">
                            <div class="slider-wrapper theme-default">
                                <div id="slider" class="nivoSlider">
                                    <img src="images/1.jpg" data-thumb="images/1.jpg" alt="" />
                                    <img src="images/2.jpg" data-thumb="images/2.jpg" alt="" />
                                    <img src="images/3.jpg" data-thumb="images/3.jpg" alt="" />
                                    <img src="images/4.jpg" data-thumb="images/4.jpg" alt="" />
                                    <img src="images/5.jpg" data-thumb="images/5.jpg" alt="" />
                                    <img src="images/6.jpg" data-thumb="images/6.jpg" alt="" />
                                    <img src="images/7.jpg" data-thumb="images/7.jpg" alt="" />
                                    <img src="images/8.jpg" data-thumb="images/8.jpg" alt="" />
                                    <img src="images/9.jpg" data-thumb="images/9.jpg" alt="" />
                                    <img src="images/10.jpg" data-thumb="images/10.jpg" alt="" />
                                </div>
                            </div>
                        </div>
                        <!------End Slider ------------>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <!------------End Header ------------>
        <div class="main">
            <div class="wrap">
                <div class="content">
                    <div class="content_top">
                        <div class="heading">
                            <h3>New Products</h3>
                        </div>
                    </div>
                    <div class="section group">
                        <div class="grid_1_of_5 images_1_of_5">
                           <a href="Preview.htm"><img src="images/11 (1).jpg" alt="" /></a>
                            <h2><a href="Preview.htm">End Game</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$620.87</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>					 
                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (2).jpg" alt="" /></a>
                            <h2><a href="preview.html">Sorority Wars</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$620.87</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>

                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (3).jpg" alt="" /></a>
                            <h2><a href="preview.html">Twilight New Moon</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$899.75</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>

                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (4).jpg" alt="" /></a>
                            <h2><a href="preview.html">Avatar</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$599.00</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (5).jpg" alt="" /></a>
                            <h2><a href="preview.html">Black Swan</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$679.87</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>				     
                        </div>
                    </div>
                    <div class="content_bottom">
                        <div class="heading">
                            <h3>Feature Products</h3>
                        </div>
                    </div>
                    <div class="section group">
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (6).jpg" alt="" /></a>
                            <h2><a href="preview.html">Beauty and the beast</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$620.87</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>

                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (7).jpg" alt="" /></a>
                            <h2><a href="preview.html">Eclipse</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$620.87</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>

                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (8).jpg" alt="" /></a>
                            <h2><a href="preview.html">Coraline</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$899.75</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>

                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (9).jpg" alt="" /></a>
                            <h2><a href="preview.html">Unstoppable</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$599.00</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="grid_1_of_5 images_1_of_5">
                            <a href="preview.html"><img src="images/11 (10).jpg" alt="" /></a>
                            <h2><a href="preview.html">Priest 3D</a></h2>
                            <div class="price-details">
                                <div class="price-number">
                                    <p><span class="rupees">$679.87</span></p>
                                </div>
                                <div class="add-cart">								
                                    <h4><a href="preview.html">Add to Cart</a></h4>
                                </div>
                                <div class="clear"></div>
                            </div>				     
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="wrap">	
                <div class="section group">
                    <div class="col_1_of_4 span_1_of_4">
                         <h4>PRODUCTS</h4>
                                <ul>
                                    <li><a href="contact.html">Puja</a></li>
                                 <li><a href="contact.html">Wedding</a></li>
                                 <li><a href="contact.html">BIRTHDAY</a></li>
                                 <li><a href="contact.html">Meeting</a></li>
                                </ul>
                    </div>
<!--                    <div class="col_1_of_4 span_1_of_4">
                        <h4>Why buy from us</h4>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Customer Service</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="contact.html">Site Map</a></li>
                            <li><a href="#">Search Terms</a></li>
                        </ul>
                    </div>
                    <div class="col_1_of_4 span_1_of_4">
                        <h4>My account</h4>
                        <ul>
                            <li><a href="contact.html">Sign In</a></li>
                            <li><a href="index.html">View Cart</a></li>
                            <li><a href="#">My Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="contact.html">Help</a></li>
                        </ul>
                    </div>-->
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

