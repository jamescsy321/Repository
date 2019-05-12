<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MotoZone</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!-- Bootstrap -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <!-- main style -->
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <!-- header style -->
    <link href="<c:url value="/css/header.css"/>" rel="stylesheet">
    <!-- category style -->
    <link href="<c:url value="/css/category.css"/>" rel="stylesheet">


    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- jQuery UI library -->
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"
            integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="
            crossorigin="anonymous"></script>
    <!-- Off-canvas Menu -->   
    <script src="<c:url value="/js/classie.js"/>"></script>
    <!-- CKEditor library -->
    <script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
    <!-- main js -->
    <script src="<c:url value="/js/main.js"/>"></script>
    <!-- category js -->
    <script src="<c:url value="/js/category.js"/>"></script>
    
    <script>
        console.log(location.href);
    </script>
    
</head>
<body>
    <!-- BEGAIN PRELOADER -->
    <div id="preloader">
            <div id="status">&nbsp;</div>
    </div>
    <!-- END PRELOADER -->

    <!-- Start menu area -->
    <%@ include file="include/menu.jsp" %>
    <!-- End menu area -->

    <!-- Start header area -->
	<%@ include file="include/header.jsp" %>
	<!-- End header area -->

    <!-- Start catgory area -->
    <div id="cat-area">
        <c:forEach var="bean" items="${categoryList}">
			<a href="<c:url value="/PostList/${bean.subCategory.category}"/>">
		        <div class="cat">
		            <img src="<c:url value="${bean.subCategory.imgSrc}"/>" alt="${bean.subCategory.category}"/>
		        </div>
		   	</a>
		</c:forEach>
    </div>
    <!-- End catgory area -->

    <!-- Strat article area -->
    <article>
        <section class="content-area">
            <div class="content-img">
                <img src="http://img.webike.tw/moto_photo/1681d3be-bed1-4643-9538-228d3af86036.jpg" alt="">
            </div>
            <div class="content">
                <h3>HONDA NEWS</h3>
                <p>The CBR600's most radical redesign since the introduction of the RR in 2003 is highlighted by a whole new engine, frame, and bodywork that results in a smaller, lighter, more-powerful CBR600RR with a class-leading power-to-weight ratio and unparalleled performance.</p>
            </div>
        </section>
        <section class="content-area">
            <div class="content-img">
                <img src="https://bd.gaadicdn.com/processedimages/kawasaki/kawasaki-ninja-h2/640X309/v_ninja-h2-r1543231598.jpg" alt="">
            </div>
            <div class="content">
                <h3>KAWASAKI NEWS</h3>
                <p>In June 2015, TT race competitor James Hillier rode a Kawasaki H2R as an inter-race demonstration lap, at near-race speeds,[17] using normal Superbike slick race tires,[18] around the 37​3⁄4-mile road course, leading to a roads TT record of the highest top speed attained in the Isle of Man by a motorcycle.[19] The top speed of "over 206 mph" (332 km/h) on the Sulby Straight was recorded on Hillier's personal Strava GPS smartphone app for cyclists.</p>
            </div>
        </section>
        <section class="content-area">
            <div class="content-img">
                <img src="https://pictures.topspeed.com/IMG/crop/201711/yamaha-yzf-r1-and-yz-44_800x0w.jpg" alt="">
            </div>
            <div class="content">
                <h3>YAMAHA NEWS</h3>
                <p>In 2000, Yamaha introduced a series of changes to improve the bike, and minor changes to the bodywork to allow for better long duration ride handling. Yamaha's main design goal was to sharpen the pre-existing bike and not to redesign it. The dry weight was reduced five pounds to 414 pounds (188 kg)</p>
            </div>
        </section>
        <section class="content-area">
            <div class="content-img">
                <img src="https://img.newatlas.com/2017-suzuki-gsxr1000-review-22.jpg?auto=format%2Ccompress&fit=max&q=60&w=1000&s=643ce56572b4524bae9e2125fab03c5a" alt="">
            </div>
            <div class="content">
                <h3>SUZUKI NEWS</h3>
                <p>The 2017 model, introduced to reporters at EICMA in late 2016, had a significantly redesigned engine the first since the last engine update on the 2009 model. This new engine has a higher RPM limit and no balancer shaft to quell vibration</p>
            </div>
        </section>
        <section class="content-area">
            <div class="content-img">
                <img src="https://moto7.net/imgs/1299_Panigale_R_FE2_151.jpg" alt="">
            </div>
            <div class="content">
                <h3>DUCATI NEWS</h3>
                <p>Due to World SuperBike engine displacement regulations, the engine in the R variant of 1299 Panigale retains the old 1,198 cc displacement, with the addition of a tungsten-balanced crankshaft, titanium valves and con-rods and two-ring pistons. Power figures for the R are same as other 1299 models with 150.8 kW (205 hp) @ 11,500 rpm, torque is down 6.2 lb-ft to 100.5 lb-ft (136.2 Nm) @ 10,250 rpm.[</p>
            </div>
        </section>
        <section class="content-area">
            <div class="content-img">
                <img src="https://mcn-images.bauersecure.com/upload/297853/images/mvf3800.png" alt="">
            </div>
            <div class="content">
                <h3>MV Agusta NEWS</h3>
                <p>The exhilaration of a 1000cc Superbike with the handling of a 600 Supersport. The torque of a v-twin and the rev limit of a four-cylinder. The MV Agusta F3 800 is</p>
            </div>
        </section>
        <section class="content-area">
            <div class="content-img">
                <img src="https://secure.i.telegraph.co.uk/multimedia/archive/01784/Aprilia_RSV4_1784269c.jpg" alt="">
            </div>
            <div class="content">Aparilla NEWS</div>
        </section>

    </article>
    <!-- End article area -->

     <!-- Start article-content area -->
     <div class="article-content-area popup-window hidden-window">
        <i class="fas fa-times close-btn"></i>

        <div id="posts-area">
            <h2>Title Here</h2>
            <div class="single-post">
                <hr/>
                <div class="post-header">
                    user name
                    <br/>
                    time
                </div>
                <div class="post-body">Contents</div>
            </div>
        </div>
    </div>
    <!-- End article-content area -->


    <!-- login and regist pop up windows (with shadow) -->
   	<%@ include file="include/loginArea.jsp" %>
    
</body>
</html>