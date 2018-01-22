<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>BeautiProduct</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>ProductCustList For Admin</h2>
<table class="table table-hover" id="ap1" class="display" border="2" width="80" align="center">
<tr>
<th>S1 no</th>
<th>PID</th>
<th>Product Name</th>
<th>Product Supplier</th>
<th>Product Category</th>
<th>Description</th>
<th>Stock</th>
<th>Price</th>
<th>Image</th>
<th class="span2">Action</th>
</tr>
<c:if test="${empty prodList}">
<tr>
<td colspan="10" align="center">No record exists!!</td>
</tr>
</c:if>
<c:forEach var="p" varStatus="st" items="${ProdList}">
<tr>
<td><c:out value="${st.count}"></c:out></td>
<td><c:out value="${p.pid }"></c:out></td>
<td><c:out value="${p.pname}"></c:out></td>
<td><c:out value="${p.supplier.sname}"></c:out></td>
<td><c:out value="${p.category.cname}"></c:out></td>
<td class="span3">
<c:out value="${p.pdescription}"></c:out>
<td><c:out value="${p.price}"></c:out></td>
<td><c:out value="${p.pstock}"></c:out></td>
<td><img src="${pageContext.request.contextPath}/resources/${p.imagName}" height="50px" width="50px"></td>
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a class="btn btn-info" role="button" href="<c:url value="/prodDetails/${p.pid}"/>">Details</a>
<tr>
</c:forEach>
</table>

</div>

</body>
</html>
