<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Details</title>
</head>
<body>

<h2>Details for: ${duty}</h2>

<!-- ADD -->
<form action="${pageContext.request.contextPath}/details/create" method="post">
    <input type="text" name="title" placeholder="Detail title" />
    <input type="hidden" name="duty" value="${duty}" />
    <button type="submit">Add</button>
</form>


<br/>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Action</th>
    </tr>

    <c:forEach var="detail" items="${details}">
        <tr>
            <td>${detail.title}</td>
            <td>
                <!-- DELETE -->
                <form action="${pageContext.request.contextPath}/details/delete" method="post">
                    <input type="hidden" name="id" value="${detail.id}" />
                    <input type="hidden" name="duty" value="${duty}" />
                    <button type="submit">Delete</button>
                </form>



            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="/todo">⬅ Back to Todos</a>

</body>
</html>

