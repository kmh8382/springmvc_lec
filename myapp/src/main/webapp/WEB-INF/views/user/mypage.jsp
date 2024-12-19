<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>

<jsp:include page="../layout/header.jsp">
  <jsp:param name="title" value="마이 페이지"/>
</jsp:include>

  <h1>마이 페이지</h1>
  <br/><br/><br/>
  
  <h3>개인정보변경</h3>
  <form id="form-mypage" method="post">
    <input type="hidden" name="userId" value="${u.userId}">
    <input type="hidden" name="profileImg" value="${u.profileImg}">
    이메일 : <input type="text" name="userEmail" value="${u.userEmail}">
    <br/>
    성명 : <input type="text" name="userName" value="${u.userName}">        
  </form>  
  <button type="button" id="btn-modify">개인정보변경하기</button>
  <br/><br/><br/>
  
  <h3>프로필이미지변경</h3>
  <form action="${contextPath}/user/modifyProfile.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="userId" value="${u.userId}">
    <div>
      <c:if test="${empty u.profileImg}"><img src="${contextPath}/assets/images/avatar.png" width="80px"></c:if>
      <c:if test="${not empty u.profileImg}"><img src="${contextPath}${u.profileImg}" width="80px"></c:if>  <%-- 이 경로를 해석하려면 servlet-context.xml 파일에 정적 파일의 경로 인식을 추가해 줘야 합니다. --%>
    </div>
    <div>
      <label for="profile">신규 프로필 선택</label><br/>
      <input type="file" name="profile" id="profile">
    </div>
    <div>
      <button type="submit">프로필 변경하기</button>
    </div>
  </form>
  <br/><br/><br/>
  
  
  
  <button type="button" id="btn-remove">회원탈퇴</button>
  
  <script>
  const formMypage = document.getElementById('form-mypage');
  
    document.getElementById('btn-remove').addEventListener('click', (event) => {
      if(confirm('현재 계정을 회원탈퇴 하시겠습니까?')) {        
        formMypage.action = '${contextPath}/user/remove.do';
        formMypage.submit();
      }
    })
    
    document.getElementById('btn-modify').addEventListener('click', (event) => {
      if(confirm('현재 계정의 정보를 변경 하시겠습니까?')) {        
        formMypage.action = '${contextPath}/user/modifyInfo.do';
        formMypage.submit();
      }
    })
  </script>
</body>
</html>