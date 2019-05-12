<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MotoZone User Center</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!-- Bootstrap -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <!-- main style -->
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <!-- header style -->
    <link href="<c:url value="/css/header.css"/>" rel="stylesheet">
    <!-- user center style -->
    <link href="<c:url value="/css/usercenter.css"/>" rel="stylesheet">


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
    <!-- user center js -->
    <script src="<c:url value="/js/usercenter.js"/>"></script>
    
    
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

    <!-- Start content area -->
    <article>
    <!-- Start User center platform area -->
    <div id="usercenter-title">
        <i class="fas fa-tools"></i>
        <div>管理中心</div>
    </div>

    <div class="control-panel-area">
        
        <div class="icons" id="user-data-area">
            <i class="fas fa-users-cog"></i>
            <div>會員資料設定</div>
        </div>
        <div class="icons" id="article-area">
            <i class="fas fa-file-signature"></i>
            <div>文章管理</div>
        </div>
        <div class="icons" id="tx-area">
            <i class="fas fa-dollar-sign" ></i>
            <div>交易管理</div>
        </div>
        <div class="icons" id="service-area">
            <i class="fas fa-headset"></i>
            <div>客服中心</div>
        </div>

        <div class="icons" id="report-area">
            <i class="fas fa-chart-line"></i>
            <div>網站統計資料</div>
        </div>

    </div>

    <!-- side panel area -->
    <div class="side-control-panel-area">
        
        <div class="icons" id="user-data-icon">
            <i class="fas fa-users-cog"></i>
        </div>
        <div class="icons" id="article-icon">
            <i class="fas fa-file-signature"></i>
        </div>
        <div class="icons" id="tx-icon">
            <i class="fas fa-dollar-sign" ></i>
        </div>
        <div class="icons" id="service-icon">
            <i class="fas fa-headset"></i>
        </div>

        <div class="icons" id="report-icon">
            <i class="fas fa-chart-line"></i>
        </div>

    </div>
    <!-- End User center platform area -->

    </article>
    <!-- End content area -->

    <!-- Start user data operation area -->
    <div class="op-area" id="user-data-op-area">
        <i class="fas fa-times close-btn op-close"></i>

        <h1>會員資料設定</h1>
        <div class="tabs">
            <div class="tab" id="basic-data-tab">基本資料</div>
            <div class="tab" id="tx-data-tab">交易資料</div>
            <div class="tab" id="auth-data-tab">權限管理</div>
        </div>
        <div class="data-area" id="basic-data-area">
            <!-- dummy data -->
            <form>
                <div>
                    <span>帳號：</span>
                    <input type="text" name="user" id="user" required/>
                </div>
                <div>
                    <span>密碼：</span>
                    <input type="password" name="pwd" required/>
                </div>
                <div>
                    <span>姓名：</span>
                    <input type="text" name="name" required/>
                </div>
                <div>
                    <span>電話：</span>
                    <input type="text" name="email" required/>
                </div>
            </form>

        </div>
        <div class="data-area" id="tx-data-area">Transaction</div>
        <div class="data-area" id="auth-data-area">Authority</div>
    </div>
    <!-- End user data operation area -->

    <!-- Start article operation area -->
    <div class="op-area" id="article-op-area">
        <i class="fas fa-times close-btn op-close"></i>
        <h1>ARTICLES DATAS IN THIS PAGE</h1>
    </div>
    <!-- End article operation area -->

    <!-- Start transaction operation area -->
    <div class="op-area" id="tx-op-area">
        <i class="fas fa-times close-btn op-close"></i>
        <h1>TX DATAS IN THIS PAGE</h1>
    </div>
    <!-- End transaction operation area -->

    <!-- Start service operation area -->
    <div class="op-area" id="service-op-area">
        <i class="fas fa-times close-btn op-close"></i>
        <h1>SERVICE DATAS IN THIS PAGE</h1>
    </div>
    <!-- End service operation area -->

    <!-- Start report operation area -->
    <div class="op-area" id="report-op-area">
        <i class="fas fa-times close-btn op-close"></i>
        <h1>REPORT DATAS IN THIS PAGE</h1>
    </div>
    <!-- End report operation area -->


    <!-- login and regist pop up windows (with shadow) -->
   	<%@ include file="include/loginArea.jsp" %>
    
</body>
</html>