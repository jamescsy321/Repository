let editor; // store CKEditor's instance


$(document).ready(function(){

    $(".content-area").click(function(){
        $(".article-content-area").removeClass("hidden-window",700);
        $("#shadow").fadeIn(700);
        var id = $(this).children(".content-id").text();
        history.pushState({foo: "Post"},"","../Posts/" + id);
        displayPosts(id);
    });

    $("#publish-btn").click(function(){
        $(".publish-area").removeClass("hidden-window",700);
        $("#shadow").fadeIn(700);
    });

    $("#content-opt").click(function(event){
        event.stopPropagation();
        // custom menu
        /*

            TBD

        */

    });

    // send a post
    $("#submit").click(function(e){

        if(editor.getData() && $("#title").val()){
            // use ajax to send data to servlet
        $.ajax({
            url:"http://localhost:8080/article/Article",
            type:"POST",
            data:{title: $("#title").val(),content: editor.getData()},
            success:function(data,status){
                        if(status == "success"){
                            console.log("OK");

                            // empty input area
                            $("#title").val("");
                            editor.setData("");

                            // redirect
                            location.href = "#";
                        }
                    }
        });
        }
        
    });


});

function displayPosts(id){
    $.ajax({
        url:"../Posts/" + id,
        type:"POST",
        data:{id: id},
        success:function(data,status){
                    if(status == "success"){
                        console.log("OK");
                        $("#posts-area").html("");
                        $("#posts-area").append(data);
                        
//                        var posts = $("#posts-area .single-post");
//                        var post = posts.first();
//                        
//                        var len = posts.length;
//                        
//                        for(let i=0 ; i<len ; i++){
//                        	var imgs = post.children(".post-body").first().children("img");
//                        	var img = imgs.first();
//                        	var imgsLen = imgs.length;
//                        	
//                        	for(let j=0 ; j<imgsLen ; j++){
//                        		if(img.width() > 100){
//                        			img.css({"display":"block","margin":"20px auto"});
//                        		}
//                        		
//                        		img = img.next();
//                        	}
//                        	
//                        	post = post.next();
//                        	
//                        	
//                        }
                    
                        
                    }
                }
    });
}