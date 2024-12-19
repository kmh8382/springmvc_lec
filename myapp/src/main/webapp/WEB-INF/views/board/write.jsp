<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>

<jsp:include page="../layout/header.jsp">
  <jsp:param name="title" value="마이 페이지"/>
</jsp:include>

  <h1>마이 페이지</h1>
  
  <form id="form-mypage" method="post">
    <input type="hidden" name="user_id" value="${sessionScope.loginUser.userId}">
    이메일 : <input type="text" name="user_email" value="${sessionScope.loginUser.userEmail}" readonly>
    <br/>
    성명 : <input type="text" name="user_name" value="${sessionScope.loginUser.userName}" readonly>        
  </form>
  
  <button type="button" id="btn-remove">회원탈퇴</button>
  
  <script>
  const formMypage = document.getElementById('form-mypage');
  
    document.getElementById('btn-remove').addEventListener('click', (event) => {
      if(confirm('현재 계정을 회원탈퇴 하시겠습니까?')) {        
        formMypage.action = '${contextPath}/user/remove.do';
        formMypage.submit();
      }
    })
  </script>
</body>
</html>