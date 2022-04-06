let index = {
    init:function(){
        $("#btn-save").on("click",()=>{ // 내부에서 this를 바인딩하기 위해서
            this.save();
        });
    },
    save:function(){
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };
        // ajax 호출시 default가 비동기 호출
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType:"json"
        }).done(function (resp){
            alert("글쓰기 완료!");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();

