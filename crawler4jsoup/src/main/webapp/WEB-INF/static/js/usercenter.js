function showOpArea(opArea){
    $("#usercenter-title").fadeOut(500);
    $(".control-panel-area").fadeOut(500,function(){
        $(".side-control-panel-area").fadeIn(500,function(){
            opArea.removeClass("hidden-window");
            opArea.fadeIn(500);
        });
    });
}

function changeOpArea(opArea){
    $(".op-area").fadeOut(500);
    opArea.delay(500).fadeIn(500);
}


$(document).ready(function(){
    $(".side-control-panel-area").fadeOut(700);

    // main panel click setting
    $("#user-data-area").click(function(){
        showOpArea($("#user-data-op-area"));
    });

    $("#article-area").click(function(){
        showOpArea($("#article-op-area"));
    });

    $("#tx-area").click(function(){
        showOpArea($("#tx-op-area"));
    });

    $("#service-area").click(function(){
        showOpArea($("#service-op-area"));
    });

    $("#report-area").click(function(){
        showOpArea($("#report-op-area"));
    });

    // side panel click setting
    $("#user-data-icon").click(function(){
        changeOpArea($("#user-data-op-area"));
    });

    $("#article-icon").click(function(){
        changeOpArea($("#article-op-area"));
    });

    $("#tx-icon").click(function(){
        changeOpArea($("#tx-op-area"));
    });

    $("#service-icon").click(function(){
        changeOpArea($("#service-op-area"));
    });

    $("#report-icon").click(function(){
        changeOpArea($("#report-op-area"));
    });

    // return main panel
    $(".op-close").click(function(){
        $(".op-area").fadeOut(500,function(){
            $(".side-control-panel-area").fadeOut(500,function(){
                $("#usercenter-title").fadeIn(500);
                $(".control-panel-area").fadeIn(500);
            });
        });
    });


    // user data operation area
    $("#basic-data-tab").click(function(){
        $(".tab").removeClass("tab-select");
        $("#basic-data-tab").addClass("tab-select");

        $(".data-area").fadeOut(500);
        $("#basic-data-area").fadeIn(500);
    });

    $("#tx-data-tab").click(function(){
        $(".tab").removeClass("tab-select");
        $("#tx-data-tab").addClass("tab-select");

        $(".data-area").fadeOut(500);
        $("#tx-data-area").fadeIn(500);
    });

    $("#auth-data-tab").click(function(){
        $(".tab").removeClass("tab-select");
        $("#auth-data-tab").addClass("tab-select");

        $(".data-area").fadeOut(500);
        $("#auth-data-area").fadeIn(500);
    });
    
});