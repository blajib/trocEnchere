<%-- <a href="${pageContext.request.contextPath}/ModifierProfil">
	<img alt="modifier" src="images/modification.png" width="20" height="20">
</a> --%>

<form action="${pageContext.request.contextPath}/ModifierProfil" method="post">
	<label for="${param.nomAttribut}">${param.nomAttribut} : </label>
	<input class="input" type="text" readonly="readonly" name="${param.nomAttribut}" value="${sessionScope.utilisateurSession[param.nomAttribut]}">
	<input type="image" alt="modifier" src="images/modification.png" width="20" height="20">
</form>