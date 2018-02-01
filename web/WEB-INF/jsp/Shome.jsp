<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Movies Store a Entertainment Category Website Template | Contact :: w3layouts</title>
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
<!--                            <li><a href="home.htm">Home</a></li>-->
                            <!--<li><a href="contact.html">Contact</a></li>-->
                        </ul>
                    </div>
                    <div class="account_desc">
                        <ul> 
                            <c:choose>
                                <c:when test="${sessionScope.loginDetails.name == null}" > 
                                    <div class="dropdown">
                                        <li><a href="#">MY Account</a></li>
                                        <div class="dropdown-content">
                                            <a href="sellerregistration.htm">Register</a>
                                            <a href="sellerlogin.htm">Login</a>
                                        </div>
                                    </div>
                                </c:when >
                                <c:when test="${sessionScope.loginDetails.name != null}" >
                                    <div class="dropdown">
                                        <li><a href="#">MY Account</a></li>
                                        <div class="dropdown-content">
                                            <a href="sellerLogout.htm">Log Out</a> 
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
                        <img src="images/logo.jpg" width="200px" height="95px" alt="" />
                    </div>
                    <div class="header_top_right">
                        <div class="shortcutHome">
                            <a href="Saddproduct.htm"><img src="images/posting.png"><br>ADD PRODUCT</a>


                            <a href="Product.htm"><img src="images/photo.png"><br>MY PRODUCT</a>


                            <a href="sellerLogout.htm"><img src="images/halaman.png"><br>LOG OUT</a>
                        </div>
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
                <div class="content">

                    <div class="section group">
                        <div class="col span_2_of_3">
                            <div class="contact-form">

                            </div>
                        </div>


                    </div>		
                </div> 
            </div>
        </div>
        <div class="footer">
            <div class="wrap">	
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

