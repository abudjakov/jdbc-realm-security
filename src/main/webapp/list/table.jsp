<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%@ include file="heder.jsp" %>

<body>
<h2 align="center">Table List</h2>

<p>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>User ID</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>