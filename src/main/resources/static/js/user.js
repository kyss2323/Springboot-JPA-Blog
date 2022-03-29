let index = {
    init:function(){
        $("#btn-save").on("click",()=>{ // 내부에서 this를 바인딩하기 위해서
            this.save();
        });
    },
    save:function(){
        // alert('user의 save함수 호출됨 ');
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        // ajax 호출시 default가 비동기 호출
        $.ajax({
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data), // http body 데이터
            contentType: "application/json; charset=utf-8",
            dataType:"json"
        }).done(function (resp){
            alert("회원가입이 완료되었습니다.");
            console.log(resp);
            // location.href="/blog";
        }).fail(function (error){
            alert(JSON.stringify(error));
        }); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
    }
}

index.init();

