<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<c:if test="${empty userinfo}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/board/list?pgno=1&key=&word=";
	</script>
</c:if>
      <div class="row justify-content-center">
        <div class="col-lg-10 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">회원 수정</mark>
          </h2>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-12">
          <form id="form-modify" method="POST" action="">
            <div class="mb-3">
              <label for="userName" class="form-label">이름: </label>
              <input type="text" class="form-control" id="userName" name="userName" value="${member.userName}" />
            </div>
            <div class="mb-3">
              <label for="emailId" class="form-label">이메일 아이디:</label>
              <input class="form-control" id="emailid" name="emailId" rows="7"value="${member.emailId}"></input>
            </div>
			<div class="mb-3">
              <label for="userPwd" class="form-label">비밀번호:</label>
              <input type="password"class="form-control" id="userPwd" name="userPwd" rows="7"></input>
            </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-modify" class="btn btn-outline-primary mb-3">
                글수정
              </button>
              <button type="button" id="btn-list" class="btn btn-outline-danger mb-3">
                목록으로이동...
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script>
      document.querySelector("#btn-modify").addEventListener("click", function () {
        if (!document.querySelector("#userName").value) {
          alert("변경할 이름 입력!!");
          return;
        } else if (!document.querySelector("#emailid").value) {
          alert("변경할 이메일id 입력!!");
          return;
        }else if (!document.querySelector("#userPwd").value){
            alert("변경할 비밀번호 입력!!");
        }
        else {
          let form = document.querySelector("#form-modify");
          form.setAttribute("action", "${root}/user/modify");
          form.submit();
        }
      });
      
      document.querySelector("#btn-list").addEventListener("click", function () {
      	if(confirm("취소를 하시면 작성중인 글은 삭제됩니다.\n취소하시겠습니까?")) {
    		  let form = document.querySelector("#form-param");
         	  form.setAttribute("action", "${root}/board/list");
            form.submit();
     	    }
        });
    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
