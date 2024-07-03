<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Modify</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
    For more information about DataTables, please visit the <a target="_blank"
                                                               href="https://datatables.net">official DataTables documentation</a>.</p>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Board Modify</h6>
    </div>
    <div class="card-body">
        <form id="actionForm" action="/board/modify" method="post">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Bno</span>
                </div>
                <input type="text" name="bno" value="<c:out value="${vo.bno}"/>" class="form-control" readonly>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Title</span>
                </div>
                <input type="text" name="title" value="<c:out value="${vo.title}"/>" class="form-control">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Content</span>
                </div>
                <input type="text" name="content" value="<c:out value="${vo.content}"/>" class="form-control">
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Writer</span>
                </div>
                <input type="text" value="<c:out value="${vo.writer}"/>" class="form-control" readonly>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Register Date</span>
                </div>
                <input type="text" value="<c:out value="${vo.regDate}"/>" class="form-control" readonly>
            </div>
            <button type="submit" class="btn btn-info btnList">LIST</button>
            <button type="submit" class="btn btn-warning btnModify">MODIFY</button>
            <button type="submit" class="btn btn-danger btnRemove">REMOVE</button>
        </form>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>

<script>

    const bno = '${vo.bno}' // 문자열로?

    const actionForm = document.getElementById("actionForm");

    document.querySelector(".btnList").addEventListener("click", (e) => {
        window.location = "/board/list"
    }, false)

    document.querySelector(".btnModify").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        actionForm.action = `/board/modify/\${bno}`
        actionForm.method = 'post'
        actionForm.submit()

    }, false)

    document.querySelector(".btnRemove").addEventListener("click", (e) => {
        e.preventDefault()
        e.stopPropagation()

        actionForm.action = `/board/remove/\${bno}`
        actionForm.method = 'post'
        actionForm.submit()

    }, false)
</script>

<%@include file="../includes/end.jsp"%>
