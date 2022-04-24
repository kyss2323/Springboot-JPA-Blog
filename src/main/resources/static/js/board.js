let index = {
    init:function(){
        $("#btn-save").on("click",()=>{ // 내부에서 this를 바인딩하기 위해서
            this.save();
        });
        $("#btn-delete").on("click", ()=>{
            this.delete();
        })
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
    },

    delete:function(){
        var id = $("#data-board-id").data("id");
        // ajax 호출시 default가 비동기 호출
        $.ajax({
            type: "DELETE",
            url: "/api/board/"+id,
            dataType:"json"
        }).done(function (resp){
            alert("글삭제 완료!");
            location.href="/";
        }).fail(function (error){
            alert(error.responseText);
            console.log(error.responseText);
        });
    }
}

index.init();

