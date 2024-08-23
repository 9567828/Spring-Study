console.log('하이')

console.dir($("#out"))

// document.querySelector("#out").innerHTML = "힘들게 내용추가";

$("#out").html("간단하게 내용 추가")

console.dir($('.box'));

// html() : 해당 요소의 내용 추가
$(".box").html("내용 고침")

// prop() : 해당 요소의 속성 추가
$(".box").prop("title", "마우스를 오래 올리고 있으면 나오는 설명")
$(".box").prop("style", "background-color: orange");

// 해당 요소의 css 설정
$(".box").css("color", "brown")
$(".box").css("font-size", "20px")
$(".box").css("width", "150px")
$(".box").css("height", "150px")
$(".box").css("margin", "10px")
$(".box").css("padding", "20px")

let i = 0;
$("#btn1").click((e) => {
	
	/**
	 * # Jquery에서 Ajax 요청 하기
	 *
	 * - 다음 정보들을 담고 있는 자바스크립트 객체를 하나 생성한다 
	 * url : 요청 주소
	 * method: 요청 방식
	 * dataType: 요청 성공 후 받게 되는 데이터 타입
	 * success: 요청 성공 시 처리 함수
	 * 
	 * - $.ajax()를 사용해 해당 객체와 함께 요청을 보낸다
	 * - 요청 시 콜백에서 받게 되는 데이터
	 * 
	 * 첫번째 인자: 응답 데이터
	 * 두번째 인자: 응답 상태코드
	 * 세번째 인자: ajax 요청 객체
	*/
	
	const ajaxSettings = {
		url: "/entity/test5",
		method: "GET",
		dataType: "json",
		success: (data, state, xhttp) => {
			// JSON.pare() 없이도 알아서 객체 형태로 변환되어있음
			console.log("받은데이터: ", data);
			console.log("받은 상태코드: ", state);
			console.log("xhttp 객체: ", xhttp);
			// 원한다면 전통적인 방식으로 xhttp 객체를 제어할 수도 있다
			console.log("responseText: ", xhttp.responseText)
			console.log("responseJSON: ", xhttp.responseJSON)
			console.log("status: ", xhttp.stauts)
			console.log("statusText: ", xhttp.stautsText)
		}
	}
	
	$.ajax(ajaxSettings);
})


