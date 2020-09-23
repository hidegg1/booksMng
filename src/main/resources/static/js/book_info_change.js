$(function(){
    $('[name=plusOrMinus]').click(function(){
        if($('#reduce:checked').prop('checked')){
            $("#increase_and_decrease_number").attr("max",$("#stock").val());
            if($("#increase_and_decrease_number").val().length > $("#stock").val().length){
                $("#increase_and_decrease_number").val($("#stock").val());
            }else if($("#increase_and_decrease_number").val().length == $("#stock").val().length){
                if($("#increase_and_decrease_number").val() > $("#stock").val()){
                    $("#increase_and_decrease_number").val($("#stock").val());
                } 
            }
        }else{
            $("#increase_and_decrease_number").removeAttr("max"); 
        }
    });
    $("#increase_and_decrease_number").on('input',function(){
        if($('#reduce:checked').prop('checked')){
            if($("#increase_and_decrease_number").val().length > $("#stock").val().length){
                $("#increase_and_decrease_number").val($("#stock").val());
            }else if($("#increase_and_decrease_number").val().length == $("#stock").val().length){
                if($("#increase_and_decrease_number").val() > $("#stock").val()){
                    $("#increase_and_decrease_number").val($("#stock").val());
                } 
            }          
        }
    });
    $(".submit_btn").on("click", function(){
        $("#confirmation-dialog").dialog({
            buttons:[
                {text: "ＯＫ",
                 click: function() {
                    let flag = false;
                    $('.required').each(function(e) {
                        if ($('.required').eq(e).val() === "") {
                            $(this).css('background-color','#FADADA');
                            flag = true;
                        }else{
                            $(this).css('background-color','#ffffff');
                        }
                    });
                    if (flag) {
                        if($("#messageSpace p").length > 0){
                            $(this).dialog("close");
                        }else{
                            let messageSpace = document.getElementById("messageSpace");
                            let message = document.createElement('p');
                            message.innerHTML = '未入力の項目があります'
                            message.setAttribute("style","color:#ff0000;");
                            messageSpace.appendChild(message);
                            $(this).dialog("close");    
                        }    
                    }else{
                        $('form').attr('method', 'post');
                        $('form').attr('action','/cdbooksmng/adimin/doBooksChange');
                        $('form').submit();
                    }                 
                 }
                },
                {text: "キャンセル",
                 click: function() {$(this).dialog("close");}
            }]
        });
    });
    $(function(){
	function pageChange(){
		$('<input>').attr({
		    type: 'hidden',
		    name: 'PageNum',
		    value: $(this).val()
		}).appendTo('form');
		$('form').attr('action', '#');
		$('form').submit();
	}
	$('.top_page').click(pageChange);
	$('.last_page').click(pageChange);
	$('#pageNumberSelect').change(pageChange);
});
});
