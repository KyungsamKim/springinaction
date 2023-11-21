<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="${root}/assets/css/app.css" rel="stylesheet" />
<title>SSAFY</title>
</head>
<body>
	<!-- 중앙 content start -->
	<div class="container page-section">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">회원 정보</h2>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<form id="form-mvmodify" method="GET" action="">
					<input type="hidden" name="act" value="mvmodify"> <input
						type="hidden" name="userid" value="${member.userId}">
					<div class="mb-3">
						<label for="userid" class="form-label">아이디 : </label> <span
							id="user-id">${member.userId}</span>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">이름 : </label> <span
							id="user-name">${member.userName}</span>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">이메일 : </label> <span
							id="user-name">${member.emailId}@${member.emailDomain}</span>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">가입일 : </label> <span
							id="user-name">${member.joinDate}</span>
					</div>
					<div class="col-auto text-center">
						<button type="button" id="btn-home"
							class="btn btn-outline-success mb-3">홈으로</button>
						<button type="button" id="btn-mvmodify"
							class="btn btn-outline-primary mb-3">수정</button>
						<button type="button" id="btn-delete"
							class="btn btn-outline-danger mb-3">탈퇴하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<script>
		document.querySelector("#btn-mvmodify").addEventListener("click",
				function() {
					location.href = "${root}/user?act=mvmodify";
					let form = document.querySelector("#form-mvmodify");
					form.setAttribute("action", "${root}/user/modify");
					form.submit();
				});
		document.querySelector("#btn-delete").addEventListener("click",
				function() {
					location.href = "${root}/user/delete?userid=${member.userId}";
				});
		document.querySelector("#btn-home").addEventListener("click",
				function() {
					location.href = "${root}/";
				});
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- SimpleLightbox plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
	<script>
	</script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a5580340a10a883db7677c0bc170077&libraries=services,clusterer,drawing"></script>
	<!-- Core theme JS-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>