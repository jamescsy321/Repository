/* ----------------------------------------------------------- */
/*  1. PRELOADER 
/* ----------------------------------------------------------- */ 

jQuery(window).load(function() { // makes sure the whole site is loaded
    $('#status').delay(1000).fadeOut(); // will first fade out the loading animation
    $('#preloader').delay(1000).fadeOut('slow'); // will fade out the white DIV that covers the website.
    $('body').delay(1000).css({'overflow':'visible'});
    })

/* ----------------------------------------------------------- */
/*  2. MENU SLIDE
/* ----------------------------------------------------------- */ 



window.onload = function() {
    var menuRight = document.getElementById( 'main-menu' ),
		showRight = document.getElementById( 'menu-btn' ),
		close = document.getElementById( 'close' );

    showRight.onclick = function(e) {
        e.preventDefault();
        classie.toggle( this, 'active' );
        classie.toggle( menuRight, 'menu-open' );			
    };

    // close.onclick = function() {
    //     // menuRight.hide();						
    // };

    menuRight.onclick = function() {
        classie.toggle( this, 'active' );
        classie.toggle( menuRight, 'menu-open' );				
    };
};

/* ----------------------------------------------------------- */
/*  3. MENU SMOOTH SCROLLING
/* ----------------------------------------------------------- */ 

//MENU SCROLLING WITH ACTIVE ITEM SELECTED

jQuery(".main-nav a").click(function(event){
    event.preventDefault();
    //calculate destination place
    var dest=0;
    if($(this.hash).offset().top > $(document).height()-$(window).height()){
        dest=$(document).height()-$(window).height();
    }else{
        dest=$(this.hash).offset().top;
    }
    //go to destination
    $('html,body').animate({scrollTop:dest}, 1000,'swing');
});


/* ----------------------------------------------------------- */
/*  4. LOGIN BUTTON & ICON CONTROL
/* ----------------------------------------------------------- */ 
var userCenterUrl = "UserCenter";

$(document).ready(function(){
    $("#login-submit-btn").click(function(){
        // for login AJAX operation use

        // $.ajax({
        //     url:"",
        //     type:"POST",
        //     data:$("#login-form").serialize(),
        //     success:function(){ // redirect after success
        //                 location.href = "#";
        //                 $("#login-btn").hide(700);
        //                 $("#loggedin-icon").show(700);
        //             }
        // });
        
        // close login window
        $(this).parent().addClass("hidden-window", 700);
        $("#shadow").fadeOut(700);
        
        // show user icon
        $("#login-btn").hide(700);
        $("#loggedin-icon").show(700);
    });

    $("#loggedin-icon").click(function(){
        $("#loggedin-list").fadeToggle(500);
        
    });

    // in the list

    // user center button
    $("#user-center-btn").click(function(){
        $("#loggedin-list").fadeToggle(500);
        location.href = userCenterUrl;
    });

    // regist button
    $("#regist-btn").click(function(){
        $("#loggedin-list").fadeToggle(500);
        $(".regist-area").removeClass("hidden-window", 700);
        $("#shadow").fadeIn(700);
    });

    $("#logout").click(function(){
        $("#loggedin-list").fadeToggle(500); // close the list
        $("#login-btn").show(700);           // show login button
        $("#loggedin-icon").hide(700);       // hide loggedin icon
    });


});

/* ----------------------------------------------------------- */
/*  5. LOGIN & REGIST WINDOWS CONTROL
/* ----------------------------------------------------------- */ 

$(document).ready(function(){
    $("#login-btn").click(function(){
        $(".login-area").removeClass("hidden-window", 700);
        $("#shadow").fadeIn(700);
    });

    $(".regist-btn").click(function(){
        $(this).parent().addClass("hidden-window", 700, function(){
            $(".regist-area").removeClass("hidden-window", 700);
        });
        $("#shadow").fadeIn(700);
    });

    $("#regist-submit-btn").click(function(){
        $(this).parent().addClass("hidden-window", 700, function(){
            $(".regist-reply-area").removeClass("hidden-window", 700);
        });
    });

    $("#return-login-btn").click(function(){
        $(this).parent().addClass("hidden-window", 700, function(){
            $(".login-area").removeClass("hidden-window", 700);
        });
    });

    $(".close-btn").click(function(){
        $(this).parent().addClass("hidden-window", 700);
        $("#shadow").fadeOut(700);

        history.pushState({foo: "main"},"",currentUrl);
    });

});

/* ----------------------------------------------------------- */
/*  6. BROWSER HISTORY CONTROL
/* ----------------------------------------------------------- */ 

var currentUrl = location.href;