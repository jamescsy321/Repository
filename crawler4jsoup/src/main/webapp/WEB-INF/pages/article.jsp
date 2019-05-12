<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- article style -->
    <link href="<c:url value="/css/article.css"/>" rel="stylesheet">


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
    <!-- article js -->
    <script src="<c:url value="/js/article.js"/>"></script>

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
        <div class="cat">
            <div>輕型機車</div>
            <img src="<c:url value="/img/scooter.jpg"/>" alt="CAT1"/>
        </div>
        <div class="cat">
            <div></div>
            <img src="<c:url value="/img/honda.png"/>" alt="CAT1"/>
        </div>
    </div>
    <!-- End catgory area -->

    <!-- Strat article area -->
    <article id="postList">
    	<c:forEach var="bean" items="${postList}">
	        <section class="content-area">
	            <span class="content-id">${bean.id}</span>
	
	            <div class="content-img">
	            	<c:choose>
	            		<c:when test="${empty bean.imgSrc}">
	            			<img src="<c:url value="/img/article-default.jpg"/>"/>
	            		</c:when>
	            		<c:otherwise>
	            			${bean.imgSrc}
	            		</c:otherwise>
	            	</c:choose>
	            </div>
	            <div class="content">
	                <h4><b>${bean.title}</b></h4>
	                <p>...</p>
	            </div>
	            <div class="content-info">
	                <span><fmt:formatDate value="${bean.date}" pattern="yyyy/MM/dd"/></span>
	                <div class="view">
	                        <i class="far fa-eye"></i>
	                        <span>${bean.views}</span>
	                </div>
	                <i class="fas fa-ellipsis-h" id="content-opt"></i>
	            </div>
	        </section>
        </c:forEach>

    </article>
    <!-- End article area -->

    <!-- Start article-content area -->
    <div class="article-content-area popup-window hidden-window">
        <i class="fas fa-times close-btn"></i>
		
		<div id="post-block">
	        <div id="posts-area">
	        </div>
        </div>
    </div>
    <!-- End article-content area -->

    
    

    <!-- Start publish area -->

    <!-- publish button -->
    <div id="publish-btn">
        <img src="<c:url value="/img/publish.png"/>" alt="publish"/>
    </div>

    <!-- publish window -->
    <div class="publish-area popup-window hidden-window">
        <i class="fas fa-times close-btn"></i>

        <h2>發佈貼文</h2><br/>
        <form method="POST">
            <label for="title">標題：</label>
            <input type="text" name="title" id="title"/><br/>
            <hr/>
            <textarea name="content" id="editor" rows="3"></textarea>
            <script>
                    editor = ClassicEditor
                    .create( document.querySelector( '#editor' ) ,{
                        removePlugins: ['Heading']
                    })
                    .then( newEditor => {
                        editor = newEditor
                    } )
                    .catch( error => {
                        console.error( error );
                    } );

                    
            </script>
        </form>
        <br/>
        <button id="submit">提交</button>
    </div>
    <!-- End publish area -->



    <!-- login and regist pop up windows (with shadow) -->
   	<%@ include file="include/loginArea.jsp" %>

</body>
</html>