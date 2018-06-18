// JavaScript Document

var jq = jQuery.noConflict();
jq(document).ready(function () {
    jq(".log_btn").click(function () {
        var name = jq(".l_user").val();
        var pass = jq(".l_pwd").val();
        jq.post("/api/login",
            {
                l_user: name,
                l_pwd: pass
            },
            function (data, status) {
                var code = data.code;
                var msg = data.msg;
                if (code !== 0) {
                    alert(msg)
                } else {
                    window.location.href = "/Member.html";//需要跳转的地址
                }
            }
        );
    })
});