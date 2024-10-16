<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container my-4 p-4 border rounded shadow-sm bg-light">
    <h4 class="text-center mb-4">Dependents List</h4>

    <c:if test="${not empty dependents}">
        <div class="row">
            <c:forEach var="dependent" items="${dependents}">
                <div class="col-md-6 mb-3">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title"><i class="bi bi-person-fill"></i> ${dependent.name}</h5>
                            <p class="card-text"><strong>Age:</strong> ${dependent.age}</p>
                            <p class="card-text"><strong>Sex:</strong> ${dependent.sex}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>

    <c:if test="${empty dependents}">
        <div class="alert alert-warning text-center" role="alert">
            <i class="bi bi-exclamation-triangle-fill"></i> No dependents found for this employee.
        </div>
    </c:if>
</div>

<!-- Bootstrap CSS and Icons -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.min.css" rel="stylesheet">
