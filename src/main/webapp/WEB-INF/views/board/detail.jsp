<%@ page language="java" contentType="text/html; charset=UTF-16"
         pageEncoding="UTF-16" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../layout/header.jsp" %>
<div class="container" >
    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <button id="btn-update" class="btn btn-warning">수정</button>
    <c:if test="${principal.user.id eq board.user.id}">
        <button id="btn-delete" class="btn btn-danger">삭제</button>
    </c:if>
    <var id="data-board-id" data-id="${board.id}"></var>
    <hr/>
    <div>
        <h3>${board.title}</h3>
        <div class="d-flex">
                <span id="board-userid">${board.user.username}</span>
                <span id="board-createDate"  ><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${board.createDate}"/></span>
        </div>
    </div>
    <hr/>
    <div>
        <h5>${board.content}</h5>
    </div>

</div>
<script src="/js/board.js"></script>

<%@include file="../layout/footer.jsp" %>