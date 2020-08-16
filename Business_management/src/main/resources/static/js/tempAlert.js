/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * 弹框
 * Created by hw.lee on 2015/7/3
 */
(function (w) {
    var prompt_window, alert_window, confirm_window;
    var init = false;
    var winTimeOutArray = [];

    function initWin() {
        var prompt_win = document.createElement("div");
        prompt_win.id = "prompt-window";
        prompt_win.innerHTML = '<div id="alert-window"> <div class="alert-title"></div> <div class="alert-info"><div class="alert-icon"></div>  </div> </div> <div id="confirm-window" class="confirm-warning "> <div class="confirm-title"></div> <div class="confirm-info"> <div class="confirm-get clearfix"><div class="confirm-ok">确定</div> </div> </div> </div>';
        document.body.appendChild(prompt_win);
        init = true;
        prompt_window = $("#prompt-window");
        alert_window = $("#alert-window");
        confirm_window = $("#confirm-window");
    }

    function closeWin() {
        prompt_window.removeClass();
        prompt_window.hide();
    }

    function alertWin(strcontent, alertType, getFunc) {
        console.log(init);
        if (!init) {
            initWin();
        }
        //清理确认框的显示
        confirm_window.hide();
        //清理timeOut
        if (winTimeOutArray && winTimeOutArray.length > 0) {
            while (winTimeOutArray.length > 0) {
                clearTimeout(winTimeOutArray.pop());
            }
        }
        //清理之前的按钮事件
        prompt_window.off("click");
        //更换弹出框样式
        alert_window.removeClass();
        alert_window.addClass("alert-" + alertType);
        //更换弹出框的内容
        if (strcontent && strcontent.length > 0) {
            alert_window.find(".alert-title").html(strcontent);
        }
        //显示弹出框
        prompt_window.removeClass();
        if (prompt_window.is(':hidden')) {
            prompt_window.show();
            alert_window.show();
        }
        else {

        }
        prompt_window.css("opacity", "1");
        alert_window.css("opacity", "1");
        //添加弹出框的消失事件
        if (!alertType) {
            alertType = "warning";
        }
        switch (alertType) {
            case "success":
            case "error":
            case "warning":
                prompt_window.on("click", closeWin);
                prompt_window.addClass(" animated fadeHide");
                winTimeOutArray.push(setTimeout(showWin.closeWin, 2000));
                break;
            case "waiting":
                //prompt_window.addClass("waiting");
                prompt_window.on("click", closeWin);
                break;
            default :
                break;
        }
    }

    function confirmWin(strcontent, okFunc, cancelFunc, confirmType, confirmBtn) {
        console.log(init);
        if (!init) {
            initWin();
        }
        //清理弹出框的显示
        alert_window.hide();
        //清理timeOut
        if (winTimeOutArray && winTimeOutArray.length > 0) {
            while (winTimeOutArray.length > 0) {
                clearTimeout(winTimeOutArray.pop());
            }
        }
        //清理之前的按钮事件
        prompt_window.off("click");
        prompt_window.off("click", ".confirm-cancel");
        prompt_window.off("click", ".confirm-ok");
        //更换确认框的内容
        if (strcontent && strcontent.length > 0) {
            confirm_window.find(".confirm-title").html(strcontent);
        }
        //显示弹出框
        prompt_window.removeClass();
        if (confirmType == "load") {
            prompt_window.addClass("confirm-load");
        }
        if (confirmType == "warning") {
//            prompt_window.find(".confirm-ok").css("color", "#ec407a");
//        }else{
            prompt_window.find(".confirm-ok").css("color", "#64b5f6");
        }
        if (confirmBtn && confirmBtn.length > 0) {
            prompt_window.find(".confirm-ok").html(confirmBtn);
        }
        if (prompt_window.is(':hidden')) {
            prompt_window.show();
        }
        if (confirm_window.is(':hidden')) {
            confirm_window.show();
        }
        //添加按钮事件
        if (okFunc) {
            prompt_window.on("click", ".confirm-ok", okFunc);
        }
        if (cancelFunc) {
            prompt_window.on("click", ".confirm-cancel", cancelFunc);
        }
        else {
            prompt_window.on("click", ".confirm-cancel", showWin.closeWin);
        }
    }

    w.showWin = {closeWin: closeWin, alertWin: alertWin, confirmWin: confirmWin};
})(window);