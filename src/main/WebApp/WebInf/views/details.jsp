<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Details</title>
</head>
<body>

<h2>Details for: ${duty}</h2>

<!-- ADD -->
<form action="/details/create" method="post">
    <input type="hidden" name="duty" value="${duty}"/>
    <input type="text" name="title" placeholder="New detail" required/>
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
                <form action="/details/delete" method="post">
                    <input type="hidden" name="duty" value="${duty}"/>
                    <input type="hidden" name="title" value="${detail.title}"/>
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

