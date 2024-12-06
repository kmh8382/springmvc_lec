<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Detail</title>
</head>
<body>
  <form id="form-detail" method="post">
    <div>
      <label for="contact_id">Blog ID</label>
      <input type="text" name="blog_id" id="blog_id" value="${blog.blog_id}" readonly>
    </div>  
    <div>
      <label for="title">Title</label>
      <input type="text" name="title" id="title" value="${blog.title}">
    </div>  
    <div>
      <label for="contents">Content</label>
      <input type="text" name="contents" id="contents" value="${blog.contents}">
    </div>
    <div>
      <label for="user_email">User Email</label>
      <input type="text" name="user_email" id="user_email" value="${blog.user_email}">
    </div>    
    <div>
      <label for="hit">Hit</label>
      <input type="text" name="hit" id="hit" value="${blog.hit}">
    </div>   
    <div>
      <label for="modify_dt">modify_dt</label>
      <input type="text" name="modify_dt" id="modify_dt" value="${blog.modify_dt}">
    </div>  
    <div>
      <label for="create_dt">create_dt</label>
      <input type="text" name="create_dt" id="create_dt" value="${blog.create_dt}">
    </div>    
    <div>
      <button type="button" id="btn-modify">수정 </button>
      <button type="button" id="btn-remove">삭제</button>
      <button type="reset">취소</button>
      <button type="button" id="btn-confirm">확인</button>
    </div>           
  </form>
  <script>
    document.getElementById('btn-modify').addEventListener('click', (event) => {
      formdetail.action = '${contextPath}/blog/modify.do';
      formdetail.submit();
    });  
    
    document.getElementById('btn-remove').addEventListener('click', (event) => {
      if(confirm('해당 블로그를 삭제할까요?')) {
        formdetail.action = '${contextPath}/blog/remove.do';
        formdetail.submit();
      }
    });
  
    document.getElementById('btn-confirm').addEventListener('click', (event) => {
      location.href = '${contextPath}/blog/list.do';
    });
  </script>
  
</body>
</html>