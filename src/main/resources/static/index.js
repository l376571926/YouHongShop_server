// JavaScript Document

var jq = jQuery.noConflict();
$(document).ready(function () {
    var name = Cookies.get("name");
    console.log("当前登录用户：" + name);
    if (name != null) {
        $("#no_login_btn").hide()
    }
});