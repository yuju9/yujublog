let index = {
    init: function() {
        $("#btn-send").on("click", () => {
            this.send();
        });

    },

    send: function () {
        let data = {
            title: $("#title").val(),
            email: $("#email").val(),
            message: $("#message").val(),
        }

        $.ajax({
            type: "POST",
            url: "/ask",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("메일 전송이 완료되었습니다.");
            location.href = "/ask";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },

}

index.init();