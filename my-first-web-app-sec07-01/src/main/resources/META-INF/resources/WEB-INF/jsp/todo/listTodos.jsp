<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>	

${name}
<div class="container">
	<table class="table">
		<tr>
			<th>user name</th>
			<th>descriptions</th>
			<th>target date</th>
			<th>done?</th>
			<th></th>
			<th></th>
		</tr>
		
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.username}</td>
				<td>${todo.description}</td>
				<td>${todo.target}</td>
				<td>${todo.done}</td>
				<td > <a href="delete-todo?id=${todo.id}" class="btn btn-warning"> Delete </a> </td>
				<td > <a href="update-todo?id=${todo.id}" class="btn btn-success"> Update </a> </td>
			</tr>
		</c:forEach>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="../common/footer.jspf" %>
	



