let index = {
    init: function() {
        $("#btn-register").on("click", () => {
            this.register();
        })
    },

    register:function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        console.log(data);

        $.ajax({
            type: "POST",
            url: "/api/join",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            if (resp.status === 500) {
                alert("username 중복으로 인해 회원가입을 실패하였습니다.");
            } else {
                alert("회원가입이 완료되었습니다.");
                location.href="/";
            }
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

}

index.init();