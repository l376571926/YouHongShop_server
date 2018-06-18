// JavaScript Document

var jq = jQuery.noConflict();
jq(document).ready(function () {
    jq(".log_btn").click(function () {
        var user = jq(".l_user").val();

        var one_pwd = $("#one_pwd").val();
        var two_pwd = $("#two_pwd").val();

        // var password = jq(".l_pwd").val();
        // var repassword = jq(".l_repwd").val();
        if (one_pwd !== two_pwd) {
            alert("两次输入密码不一样");
            return
        }

        var email = jq(".l_email").val();
        var tel = jq(".l_tel").val();
        var mem = jq(".l_mem").val();
        var num = jq(".l_num").val();
        var ipt = jq(".l_ipt").val();

        jq.post("/api/register"
            , {
                l_user: user,
                l_pwd: one_pwd,
                l_email: email,
                l_tel: tel,
                l_mem: mem,
                l_num: num,
                l_ipt: ipt
            }
            , function (data, status) {
                var code = data.code;
                var msg = data.msg;
                if (code !== 0) {
                    alert(msg)
                } else {
                    window.location.href = "/Login.html";//需要跳转的地址
                }
            }
        )
    });
});