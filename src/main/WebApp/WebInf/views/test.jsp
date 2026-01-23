<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Todo List</title>
    </head>
    <body>

        <h2>Todo Ekle</h2>
        <c:set var="errors" value="${requestScope['org.springframework.validation.BindingResult.todo'].fieldErrors}" />
x
        <!-- CREATE -->
        <form action="${pageContext.request.contextPath}/todo/create" method="post">

            <input type="text" name="duty" placeholder="Görev adı"
                   value="${todo.duty}" />

            <!-- DUTY ERROR -->
            <c:if test="${not empty errors.duty}">
                <div style="color:red">${errors.duty}</div>
            </c:if>

            <select name="importance">
                <option value="">Seçiniz</option>
                <option value="insignificant"
                ${todo.importance == 'insignificant' ? 'selected' : ''}>
                    insignificant
                </option>
                <option value="important"
                ${todo.importance == 'important' ? 'selected' : ''}>
                    important
                </option>
            </select>

            <!-- IMPORTANCE ERROR -->
            <c:if test="${not empty errors.importance}">
                <div style="color:red">${errors.importance}</div>
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

                            
                            <button type="submit">Update Status</button>
                        </form>
                        <c:if test="${not empty errors}">
                            <ul style="color:red">
                                <c:forEach var="error" items="${errors}">
                                    <li>${error}</li>
                                </c:forEach>
                            </ul>
                        </c:if>

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

