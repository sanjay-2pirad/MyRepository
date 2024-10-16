<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dependent List</title>
</head>
<body>
<h2>Dependents</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach var="dependent" items="${dependents}">
        <tr>
            <td>${dependent.name}</td>
            <td>${dependent.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
