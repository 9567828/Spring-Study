console.log("하이")

const btn = document.getElementById("btn")
const out = document.getElementById("out")

const btn2 = document.getElementById("btn2")
const btn3 = document.getElementById("btn3")

const btn4 = document.getElementById("btn4")
const out2 = document.getElementById("out2")

btn.addEventListener("click", (e) => {
	// 서버로 요청 보내기 원래는 location.href로 경로를 보냈음
	const xhttp = new XMLHttpRequest();
	
	xhttp.addEventListener("readystatechange", (e) => {
		if (xhttp.readyState == 1) {
			console.log('open()이 성공')			
		} else if (xhttp.readyState == 2) {
			console.log('xhttp 요청을 보내고 응답을 받았따')
		} else if (xhttp.readyState == 3) {
			console.log("응답을 받은 후 처리를 시작햇따")
		} else if (xhttp.readyState == 4) {
			console.log("받은 응답에 대한 처리가 모두 끝나따. 사용할 수 있다")
			
			// 응답의 상태 코드에 따른 로직 구성이 가능하다
			if (xhttp.status == 200) {
				console.dir(xhttp)
				out.innerText = xhttp.responseText;				
			}
		}
	}); // 서버로부터 ajax 요청에 대한 응답을 받을때 마다 발생하는 이벤트를 설정
	xhttp.open("GET", "/rest/v1"); // 요청 보낼 메서드 및 주소를 설정
	
	xhttp.send(); // 설정한 내용으로 요청을 보낸다
})

btn2.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();
	
	// xhttp 요청에 대한 응답을 load 이벤트 처리하는 것도 가능
	// (단점- readyState4에 해당하는 처리만 가능하다)
	xhttp.addEventListener("load", (e) => {
		console.log("xhttp에 대한 응답이 도착함")
		console.log(xhttp.responseText)
	})
	
	// form은 GET/POST 밖에 못쓰지만
	// xhttp는 모든 메서드를 사용한 요청을 보낼 수 있다
	xhttp.open("PATCH", "/entity/test3");
	xhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded")
	xhttp.send("fid=3&fname=포도&price=3300");
})

btn3.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();
	
	xhttp.addEventListener("load", (e) => {
		if (xhttp.status == 200) {
			console.log("성공했다: " + xhttp.responseText)
		} else if (xhttp.status == 502) {
			console.log("실패!: " + xhttp.responseText)
		}
	})
	
	xhttp.open("PUT", "/entity/test4");
	xhttp.setRequestHeader("content-type", "application/json");
	// JSON 형식 문자열을 실어보내면
	// 서버측의 jackson-databind가 받은 JSON을 데이터를 DTO로 바인딩 해준다.
	// xhttp.send("{\"fid\":3,\"fname\":\"감귤\"}"); 수동은 힘들지
	
	// javascript에서는 Javascript object를 쉽게 JSON 문자열로 변환할 수 있다
	const newFruit = {
		fid: 3,
		fme: "딸기",
		price: 3500,
		qty: 30
	}
	
	const jsonFruit = JSON.stringify(newFruit);
	
	// 오브젝트를 JSON형으로 변환시킨거
	console.log("json으로 변환된 newfruit: ", jsonFruit);
	xhttp.send(jsonFruit)
})

btn4.addEventListener("click", (e) => {
	const xhttp = new XMLHttpRequest();
	
	xhttp.addEventListener("load", (e) => {
		if (xhttp.status == 200) {
			// JSON.parse(문자열) : 해당 문자열을 자바스크립트 오브젝트 타입으로 변환한다
			const fruit = JSON.parse(xhttp.responseText)
			
			for (key in fruit) {
				console.log("key: ", key)
				const newDiv = document.createElement('div')
				
				newDiv.classList.add(key)
				newDiv.innerText = fruit[key]
				
				out2.appendChild(newDiv)
			}
		}
	})
	
	xhttp.open("GET", "/entity/test5?id=110")
	xhttp.send();
	
})



