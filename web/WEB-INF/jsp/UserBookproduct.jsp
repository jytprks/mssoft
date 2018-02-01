<%-- 
    Document   : UserBookproduct
    Created on : 3 Mar, 2016, 3:18:55 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script> 
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script language="JavaScript">
            function Validate()
            {
                var image = document.getElementById("image").value;
                if (image != '') {
                    var checkimg = image.toLowerCase();
                    if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
                        alert("Please enter Image File Extensions .jpg,.png,.jpeg");
                        document.getElementById("image").focus();
                        return false;
                    }
                }
                return true;
            }
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
                            <li><a href="sellerlogin.htm">Seller</a></li>
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
                    <!--                    <div class="logo">
                                            <a href="home.htm"><img src="images/logo.jpg" width="200px" height="95px" alt="" /></a>
                                        </div>-->
                    <!--                    <div class="header_top_right">
                                            <div class="shortcutHome">
                                                <a href="Cpass.htm"><img src="images/posting.png"><br>Change Password</a>
                                                <a href="Cpass.htm"><img src="images/photo.png"><br>Change Email</a>
                                                <a href="Cmob"><img src="images/halaman.png"><br>Change Mobile</a>
                                          
                                            </div>
                                        </div>-->
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
                                <h3>My Account</h3>
                                <li><a href="changepassword.htm">Change Password</a></li>
                                <li><a href="wishlist.htm">My Wishlist</a></li>
                            </ul>
                        </div>					
                    </div>  

                    <div class="header_bottom_right">	
                        <div class="contact-form">
                            <div  class="form">
                                <c:forEach items="${userPDet}" var="prod">  
                                    <div class="grid_1_of_5 images_1_of_5">
                                        <c:url value="Preview.htm" var="myURL">
                                            <c:param name="name" value="${prod.productName}"/>
                                            <c:param name="price" value="${prod.price}"/>
                                            <c:param name="ID" value="${prod.productId}"/>
                                        </c:url>

                                        <a href="${myURL}"><img src="/EventManagement/myImage.htm?id=${prod.productId}" width="100px" height="100px"/></a>
                                        <h2><c:out value="${prod.productName}"/></a></h2>
                                        <div class="price-details">
                                            <div class="price-number">
                                                <p>Price:<c:out value="${prod.price}"/></span></p>
                                            </div>
                                            <div class="add-cart">								

                                            </div>
                                            <div class="clear"></div>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="main">
                <div class="wrap">
                    <div class="content">
                        <div class="section group">
                            <div class="col span_2_of_3">

                            </div>		
                        </div> 
                    </div>
                </div>
                <div class="footer">
                    <div class="wrap">	
                        <div class="section group">
                            <div class="col_1_of_4 span_1_of_4">
                                <h4>Information</h4>
                                <h4>PRODUCTS</h4>
                                <ul>
                                    <li><a href="Puja.htm">Puja</a></li>
                                    <li><a href="Wedding.htm">Wedding</a></li>
                                    <li><a href="Birthday.htm">BIRTHDAY</a></li>
                                    <li><a href="Meeting.htm">Meeting</a></li>
                                </ul>
                            </div>
                            <div class="col_1_of_4 span_1_of_4">
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
                                    <li><a href="login.htm">Sign In</a></li>
                                    <li><a href="index.html">View Cart</a></li>
                                    <li><a href="#">My Wishlist</a></li>
                                    <li><a href="#">Track My Order</a></li>
                                    <li><a href="contact.html">Help</a></li>
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
                    </div>
                    <div class="copy_right">
                        <p>� Movies Store. All Rights Reserved | Design by  <a href="http://w3layouts.com">W3Layouts</a> </p>
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
