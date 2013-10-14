<%@page import="pe.com.hydra.reapro.client.ExposedItem"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="javax.portlet.*"%>
<portlet:defineObjects />
<style>
.processP {
	font: normal 12px/150% Arial, Helvetica, sans-serif;
	width: 100%;
	height: 100%
}
</style>
<script>
	function receiveFromCoach(aString) {
		alert(aString);
	}
</script>
<%
	List processList = (List) renderRequest.getPortletSession()
			.getAttribute("processList", PortletSession.PORTLET_SCOPE);

	//Portlet namespace
	String portletNS = renderResponse.getNamespace();
%>
<div class="processP">
	<h1>Procesos Participantes</h1>

	<%
		if (processList == null) {
	%>
	<p>No Existen Procesos a Iniciar</p>
	<%
		} else {
	%>


	<ul>
		<%
			for (int i = 0; i < processList.size(); i++) {
					ExposedItem item = (ExposedItem) processList.get(i);
		%>
		<li><portlet:actionURL var="actionURL">
				<portlet:param name="javax.portlet.action" value="startProcess" />
				<portlet:param name="itemID" value="<%=item.getItemID()%>" />
				<portlet:param name="processAppID"
					value="<%=item.getProcessAppID()%>" />
			</portlet:actionURL> <a href="<%=actionURL%>"><%=item.getDisplay()%></a></li>

		<%
			}
		%>
	</ul>
</div>

<%
	}
%>
