<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>계층형게시판</title>
</head>
<body>

  <h1>게시글 작성하기(원글만 작성)</h1>
  <form action="${contextPath}/bbs/registBbs.do" method="post">
    <!-- 로그인 안 한 사용자가 textarea 태그를 클릭하면 로그인 여부는 묻는 대화상자 띄우기 -->
    <textarea rows="5" cols="30" name="contents" placeholder="작성하려면 로그인 해 주세요."></textarea><br/>
    <button type="submit">작성완료</button>
  </form>
  
  <hr/>
  
  <h1>게시글 목록</h1>
  <div>전체 게시글 개수 ${count}개</div>
  
  <div>${paging}</div>


  <script>
    function displayMsg() {
      const msg = '${msg}';
      if(msg !== '')
        alert(msg);
    }
    displayMsg();
  </script>

</body>
</html>