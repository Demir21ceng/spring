<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todo List</title>
</head>
<body>

<h2>Todo Ekle</h2>

<!-- CREATE -->
<form action="${pageContext.request.contextPath}/todo/create" method="post">

    <input type="text" name="duty" placeholder="Görev adı"
           value="${param.duty}" />

    <!-- DUTY ERROR -->
    <c:if test="${not empty dutyError}">
        <div style="color:red">${dutyError}</div>
    </c:if>

    <select name="importance">
        <option value="">Seçiniz</option>
        <option value="insignificant">insignificant</option>
        <option value="important">important</option>
    </select>

    <!-- IMPORTANCE ERROR -->
    <c:if test="${not empty importanceError}">
        <div style="color:red">${importanceError}</div>
    </c:if>

    <button type="submit">Ekle</button>
</form>

<form action="${pageContext.request.contextPath}/todo/important" method="get">
    <button type="submit">Sadece Important Todo'ları Göster</button>
</form>

<form action="${pageContext.request.contextPath}/todo" method="get">
    <button type="submit">Tüm Todo'ları Göster</button>
</form>

<hr>

<h2>Todo List</h2>

<table border="1">
    <tr>
        <th>Duty</th>
        <th>Date</th>
        <th>Importance</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="todo" items="${todos}">
        <tr>
            <td>${todo.duty}</td>
            <td>${todo.date}</td>
            <td>${todo.importance}</td>
            <td>${todo.completionStatus}</td>

            <td>
                <!-- DELETE -->
                <form action="${pageContext.request.contextPath}/todo/delete" method="post">
                    <input type="hidden" name="duty" value="${todo.duty}" />
                    <button type="submit">Sil</button>
                </form>

                <!-- DETAILS -->
                <a href="${pageContext.request.contextPath}/details/${todo.duty}">
                    <button type="submit">details</button>
                </a>

                <!-- IMPORTANCE -->
                <form action="${pageContext.request.contextPath}/todo/update/importance" method="post">
                    <input type="hidden" name="duty" value="${todo.duty}" />

                    <select name="importance">
                        <option value="insignificant">insignificant</option>
                        <option value="important">important</option>
                    </select>

                    <button type="submit">Update Importance</button>
                </form>

                <!-- COMPLETİON STATUS -->
                <form action="${pageContext.request.contextPath}/todo/update/status" method="post">
                    <input type="hidden" name="duty" value="${todo.duty}" />
                    <button type="submit">Update Status</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- PAGINATION -->
<c:if test="${totalPages > 1}">
    <div style="margin-top:20px">
        <c:forEach var="i" begin="0" end="${totalPages - 1}">
            <a href="?page=${i}&size=5">[${i + 1}]</a>
        </c:forEach>
    </div>
</c:if>

</body>
</html>
