window.onload = function(){
	$("#send").on("click", function(event){
		var data = {
			//HTMLテキストボックスより取得した文字列をJSON形式へ変換する
		};

		$.ajax({
			type: "POST",
			url: "",
			data: JSON.stringify(data),
			dataType: "json",
			success: function(json_data){
			//リクエスト成功時の挙動を定義
			},
			error: function(){
			//リクエスト失敗時の挙動を定義
			},
			complete: function(){
			//リクエストが失敗でも成功でも実行する挙動を定義
			}
		});
	});
};