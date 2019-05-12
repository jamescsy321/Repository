crawler4jsoup v2.1
1.加入Spring控管
2.新增DataSource連線方式 (由Spring控管DAO)
3.新增Hibernate (尚未測試 , 需寫測試程式)

crawler4jsoup v2.2
1.ArticleDAO/ArticleIdDAO/ArticleListDAO更新Hibernate版本並完成測試程式
2.Spring transaction控管已上線

crawler4jsoup v2.3
1.DAO全面更換為Hibernate技術 ,JDBC技術版本已刪除
2.對應6支DAO的測試程式已完成並測試通過
3.ArticleService的功能已完成(*)
4.ArticleService的測試程式已完成並測試通過(*)
5.package階層更新
6.套上已完成的網頁樣版 (僅文章區分類區塊及分區列表區塊有掛上功能)
7.文章區分類區塊使用AJAX達成
8.文章區分區列表區塊使用AJAX達成

crawler4jsoup v2.4
1.controller全面更新為Spring MVC技術 , Servlet版本已刪除
2.新增Spring MVC設定檔於config.SpringMVCConfig
3.新增DispacherServlet設定於web.xml
4.新增default servlet(tomcat內建)於web.xml (用於讀取.html網頁)
5.將靜態資源(js/css/img)移動至WEB-INF/static目錄底下經由Spring controller讀取(於SpringMVCConfig檔中設定addResourceHandlers())
6.將ajax資源移動至WEB-INF/ajax目錄底下經由Spring controller讀取
7.使用BeanNameViewResolver
8.個別的View Bean定義於SpringMVCConfig

crawler4jsoup v2.4Beta
1.更新article.html (新增article-content-area)
2.更新article.css
3.更新article.js (新增ajax取得post部分程式碼)
4.新增postsPage.jsp於WEB-INF/ajax目錄下
5.ArticleController新增對應 /Posts的方法
6.SpringMVCConfig新增對應ajaxPosts的View -> postPage.jsp

crawler4jsoup v2.5
1.移除所有.html頁面改為.jsp頁面並置於WEB-INF/pages目錄底下
2.更改pop-up視窗觸發方式(由CSS觸發改為JS觸發)
3.將網址列呼叫及帶參數方式改為RESTful風格
4./Posts/{id}設計為可以使用兩種呼叫方式：
	a.GET方式：呼叫回傳完整頁面並打開pop-up視窗(呼叫articleGet.jsp)
	b.POST方式：使用AJAX呼叫僅回傳貼文串回填至網頁上打開的pop-up視窗中
5.使用JS的history.pushState()達成打開及關閉pop-up視窗時須更改URL的需求(可將文章URL存為書籤)
6.ArticleIdDAO新增updateViewsById()方法以更新文章點閱數
7.ArticleService修改getPosts()方法 , 加入呼叫updateViewsById()方法以更新文章點閱數

crawler4jsoup v2.6
1.JavaSpringConfig更名為SpringJavaConfig(web.xml同步修正)
2.JavaSpringMVCConfig更名為SpringMvcJavaConfig(web.xml同步修正)
3.將View的設定從SpringMvcJavaConfig分離至config.view套件的三個檔案中,利用@import載入view設定
4.package結構開頭新增com.motozone
5.受package name影響的檔案皆已修正(hibernate.cfg.xml及DAO)
6.jsp頁面中重複的部分使用include指令載入,分離的頁面片斷至於pages/include目錄下(header/menu/loginArea)