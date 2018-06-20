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
                    //所有版本:true/false//别忘记冒号哦
                    var check_status = jq("input[type='checkbox']").is(':checked');//判断是否勾选记住登录
                    if (check_status) {
                        Cookies.set('name', name, {expires: 1});
                    } else {
                        // alert("不记住登录")
                    }
                    window.location.href = "/Member.html";//需要跳转的地址
                }
            }
        );
    })
});