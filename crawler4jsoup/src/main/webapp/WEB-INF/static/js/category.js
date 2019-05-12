$(document).ready(function(){
    var queryString = location.search;
    $.ajax({
        url:"/Category",
        type:"POST",
        data:{category:queryString.substring(queryString.indexOf('=') + 1)},
        success:function(data){
                    $("#cat-area").append(data);
                }
    });

    $(".content-area").click(function(){
        $(".article-content-area").removeClass("hidden-window",700);
        $("#shadow").fadeIn(700);

        history.pushState({foo: "main"},"","http://localhost:8000/Categories/L/123");
    });

});