console.log("하이")

const saleForm = document.getElementById("sale-form");

const saleBtn = document.querySelectorAll(".sale-btn");
const getRandomFuritSaleCount = remainQty => Math.floor(Math.random() * remainQty) + 1;

const saleBtnHandler = (e) => {
	const clickedBtn = e.target;

	const fid = clickedBtn.dataset.fid;
	const remainQty = clickedBtn.dataset.remainQty;
	const saleCount = remainQty != 0 ? getRandomFuritSaleCount(remainQty) : 0;
	
	console.log(`판매해야 하는 과일ID: ${fid}`)
	console.log(`그 과일의 가격: ${clickedBtn.dataset.fruitPrice}`)
	console.log(`남은개수: ${remainQty}`)
	console.log(`랜덤으로 결정된 판매 개수: ${saleCount}`)
	
	saleForm.elements.fid.value = fid;
	saleForm.elements.qty.value = saleCount;
	
	saleForm.submit();
}

saleBtn.forEach(btn => btn.addEventListener("click", saleBtnHandler));
