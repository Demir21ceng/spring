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
            <input type="String" name="duty" placeholder="Görev adı" required />

            <select name="importance">

                <option value="insignificant">insignificant</option>
                <option value="important">important</option>
            </select>
            <button type="submit">Ekle</button>
        </form>

        <hr>

        <h2>Todo List</h2>

        <!-- READ -->
        <table border="1">
            <tr>
                <th>Duty</th>
                <th>Importance</th>
                <th>Date</th>
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
                        <a href="${pageContext.request.contextPath}/todo/delete?duty=${todo.duty}">
                            Sil
                        </a>
                        |

                        <!-- UPDATE -->
                        <form action="/todo/update/importance" method="post">
                            <input type="hidden" name="duty" value="${todo.duty}"/>

                            <select name="importance">
                                <option value="insignificant">insignificant</option>
                                <option value="important">important</option>
                            </select>

                            <button type="submit">Update Importance</button>
                        </form>

                        <form action="/todo/update/status" method="post">
                            <input type="hidden" name="duty" value="${todo.duty}"/>

                            <select name="completionStatus">
                                <option value="continues">continues</option>
                                <option value="completed">completed</option>
                            </select>

                            <button type="submit">Update Status</button>
                        </form>
                    </td>
                    <!-- DETAILS -->
                    <td>
                        <a href="/details/${todo.duty}">Details</a>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </body>
</html>

