<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Blog List</title>
</head>
<body>

  <h1>Blog List</h1>
  
  <div>전체 블로그 : ${count}개</div>
  
  <c:forEach var="blog" items="${bloglist}">
    <div class="blog">      
      <a href="${contextPath}/blog/increseHit.do?blog_id=${blog.blog_id}">${blog.blog_id}, ${blog.title}, ${blog.hit}, ${blog.modify_dt}, ${blog.create_dt}}</a>
    </div>
  </c:forEach>

</body>
</html>