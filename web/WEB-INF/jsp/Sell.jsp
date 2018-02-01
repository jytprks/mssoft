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
                <div class="section group">
                    <div class="col span_2_of_3">
                        <div class="contact-form">
                            <h2>Seller Login</h2>
                            <div  class="form">
                                <form:form action="sellerlogin.htm" method="post" id="contactform" commandName="LoginDetails">                                   
                                    <p class="contact"><label for="name">User Name</label></p>
                                    <input id="name" name="name" placeholder="User name" required=""  type="text" autocomplete="off"> 
                                    <p class="contact"><label for="password"> Password</label></p> 
                                    <input type="password" placeholder="Password" id="password" name="password" required="" autocomplete="off"> </br>
                                    <input class="buttom" name="submit" id="submit"  value="Log In!" type="submit">
                                    <a href="Sforgotpass.htm"><u>forgot password</u></a>
                                    <p>
                                        <form:errors path="*" cssStyle="color:red"/>
                                    </p>
                                </form:form> 

                            </div>  

                        </div>
                    </div>
                    <div class="col span_1_of_3">
                        <div class="contact_info">
                            <h2>START SELLING</h2>
                            <div  class="form">
                                <form:form action="sellerregistration.htm" method="post" id="contactform" commandName="RegistrationDetails">
                                    <form id="contactform"> 
                                        <p class="contact"><label><h1 align="center"><font style="color: greenyellow">${success}</font></h1></label></p>                     
                                        <p class="contact"><label for="name">First Name</label></p> 
                                        <input id="name" name="Fname" placeholder="First and last name" required=""  type="text"> 
                                        <form:errors path="Fname" cssStyle="color:red"/>
                                        <p class="contact"><label for="name">Last Name</label></p> 
                                        <input id="name" name="Lname" placeholder="First and last name" required=""   type="text"> 
                                        <form:errors path="Lname" cssStyle="color:red"/>
                                        <p class="contact"><label for="email">Email</label></p> 
                                        <input id="email" name="email" placeholder="example@domain.com" required="" type="email"> 
                                        <form:errors path="email" cssStyle="color:red"/>
                                        <p class="contact"><label for="username">Create a username</label></p> 
                                        <input id="username" name="username" placeholder="username" required=""  type="text"> 

                                        <p class="contact"><label for="password">Create a password</label></p> 
                                        <input type="password" id="password" name="password" required=""> 
                                        <form:errors path="password" cssStyle="color:red"/>
                                        <p class="contact"><label for="repassword">Confirm your password</label></p> 
                                        <input type="password" id="repassword" name="repassword" required=""> 
                                        <form:errors path="repassword" cssStyle="color:red"/>

                                        <fieldset>
                                            <label>Birthday</label>
                                            <label class="month"> 
                                                <select class="select-style" name="BirthMonth">
                                                    <option value="">Month</option>
                                                    <option  value="01">January</option>
                                                    <option value="02">February</option>
                                                    <option value="03" >March</option>
                                                    <option value="04">April</option>
                                                    <option value="05">May</option>
                                                    <option value="06">June</option>
                                                    <option value="07">July</option>
                                                    <option value="08">August</option>
                                                    <option value="09">September</option>
                                                    <option value="10">October</option>
                                                    <option value="11">November</option>
                                                    <option value="12" >December</option>
                                            </label>
                                            </select>    
                                            <label>Day<input class="birthday" maxlength="2" name="BirthDay"  placeholder="Day" required=""></label>
                                            <label>Year <input class="birthyear" maxlength="4" name="BirthYear" placeholder="Year" required=""></label>
                                        </fieldset>

                                        <select class="select-style gender" name="gender">
                                            <option value="select">i am..</option>
                                            <option value="m">Male</option>
                                            <option value="f">Female</option>
                                            <option value="others">Other</option>
                                        </select><br><br>
                                        <p class="contact"><label for="name">ADDRESS</label></p> 
                                        <input id="name" name="address"  type="text"> 
                                        <p class="contact"><label for="phone">Pin Code</label></p> 
                                        <input id="phone" name="pin" required="" type="text"> <br>		 

                                        <p class="contact"><label for="phone">Mobile phone</label></p> 
                                        <input id="phone" name="phone" placeholder="phone number" required="" type="text">
                                        <form:errors path="phone" cssStyle="color:red"/>
                                        <br>             
                                        <input class="buttom" name="submit" id="submit" tabindex="5" value="Sign me up!" type="submit"> 	 
                                    </form:form> 
                                    </div>      
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

