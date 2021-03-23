<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello goods <br/>

	page<br/>
	현재페이지 번호, 행개수  ${page.startPage }<br/> 
	화면에 표시되는 끝 페이지 번호${page.endPage }<br/>
	prev, next ${page.prev } ${page.next }<br/>
	총 갯수 ${page.total }<br/>
	화면 하단에 출력할 페이지 번호 개수 ${page.pagingNomCnt }<br/>
	${page.realEnd }<br/>
	
	data size : ${fn:length(goodsList)}<br/>

	<c:forEach var="list" items="${goodsList}">
		${list.GOODS_SEQ } <br/>
		${list.GOODS_NAME } <br/>
		${list.PRICE } <br/>
		${list.ECO_SCORE } <br/>
		<img src="${list.IMG_URL }"> <br/>
		
	</c:forEach>

	paging area <br/>
	<c:if test="${page.prev}">
		<a href="${page.startPage-1}">이전</a>
	</c:if>	
	
	<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
		<c:choose>
			<c:when test="${page.cri.pageNum eq num}">${page.cri.pageNum }</c:when>
			<c:otherwise><a href="#">${num }</a></c:otherwise>
		</c:choose>
	</c:forEach>

<c:if test="${page.next}">
	<a href="${page.endPage+1}">다음</a>
</c:if>

<script>
</script>
</body>
</html>