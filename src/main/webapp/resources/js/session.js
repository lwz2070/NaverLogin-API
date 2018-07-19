$(document).ready(function() {
	
	var id = false;
	var nick = false;
	var pw = false;
	
	$('#checkId').click(function() {							//아이디 중복확인 버튼
		var inputID = $('#join_id').val();			
		$.ajax({
			data : {
				id : inputID
			},
			url : "./checkId",
			success : function(data) {
				if(data) {
					$('#massegeId').css("color", "#232efc");
					$('#massegeId').text("사용 가능한 아이디입니다.");
					id = true;
					if(id && nick && pw) {						//id nick pw 모두 true일 경우
						
						$('#join_btn').prop('disabled', false);		//사용가능 아이디일 경우 버튼 사용 가능
					}
				} else {
					$('#massegeId').css("color", "#ff4023");
					$('#massegeId').text("사용할 수 없는 아이디입니다.");
					id = false;
				}
			}
		});
	});
	
	$('#join_id').keyup(function() {							//아이디에 keyup이 들어갈때마다 버튼 비활성화
		$('#join_btn').prop('disabled', true);
		id = false;
	})
	
	$('#checkNick').click(function() {
		var inputNick = $('#join_nick').val();
		$.ajax({
			data : {
				nick : inputNick
			},
			url : "./checkNick",
			success : function(data) {
				if(data) {
					$('#massegeNick').css("color", "#232efc");
					$('#massegeNick').text("사용 가능한 닉네임입니다.");
					nick = true;
					if(id && nick && pw) {						//id nick pw 모두 true일 경우
						
						$('#join_btn').prop('disabled', false);		//사용가능 아이디일 경우 버튼 사용 가능
					}
				} else {
					$('#massegeNick').css("color", "#ff4023");
					$('#massegeNick').text("사용할 수 없는 닉네임입니다.");
					nick = false;
				}
			}
		});
	})
	
	$('#join_nick').keyup(function() {							//닉네임에 keyup이 들어갈때마다 버튼 비활성화
		$('#join_btn').prop('disabled', true);
		nick = false;
	})
	
	
	//이 구문을 넣어준 이유는 비밀번호 확인 적은 후 비밀번호 칸을 수정할 경우를 대비해서..
	//아래 아래의 펑션이랑 합칠 수 있는 방법이 있다면..... Great!
	$('#join_pw').keyup(function(){
		pw = false;
		var pwFirst = $('#join_pw').val();
		var pwCheck = $('#join_pw_check').val();
		
		if(pwFirst==pwCheck) {
			pw = true;
			if(id && nick && pw) {								//id nick pw 모두 true일 경우
				
				$('#join_btn').prop('disabled', false);			//비밀번호가 일치할 경우 버튼 사용 가능
			}
		} else {
			$('#join_pw_check').css('background-color', "#ff4023");
			pw = false;
			$('#join_btn').prop('disabled', true);
		}			
	})
	
	$('#join_pw_check').keyup(function(){						//keyup이 들어갈 때 마다
		pw = false;
		var pwFirst = $('#join_pw').val();
		var pwCheck = $('#join_pw_check').val();
		
		if(pwFirst==pwCheck) {
			$('#join_pw_check').css('background-color', "#232efc");
			pw = true;
			if(id && nick && pw) {								//id nick pw 모두 true일 경우
				
				$('#join_btn').prop('disabled', false);			//비밀번호가 일치할 경우 버튼 사용 가능					
			}
		} else {
			$('#join_pw_check').css('background-color', "#ff4023");
			pw = false;
			$('#join_btn').prop('disabled', true);
		}			
	})		
});
















