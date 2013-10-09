<%@page import="pe.com.hydra.reapro.client.ExposedItem"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="javax.portlet.*"%>
<portlet:defineObjects />
<style>
<!--
.profile li {
	float: right;
	clear: right;
}
-->
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
<h1>Inicial</h1>

<%
	if (processList == null) {
%>
<p>nooooooooooo vinieron procesos</p>
<%
	} else {
%>

<table border="1">
	<thead>
		<tr>
			<th>Nombre</th>
		</tr>
	</thead>
	<tbody>

		<%
			for (int i = 0; i < processList.size(); i++) {
				ExposedItem item = (ExposedItem) processList.get(i);
		%>
		<tr>
			<td><portlet:actionURL var="actionURL">
					<portlet:param name="javax.portlet.action" value="startProcess" />
					<portlet:param name="itemID" value="<%=item.getItemID()%>" />
					<portlet:param name="processAppID" value="<%=item.getProcessAppID()%>" />
				</portlet:actionURL> <a href="http://wp8.onp.gob.pe<%=item.getStartURL()%>"><%=item.getDisplay()%></a></td>
		</tr>

		<%
			}
		%>

	</tbody>
</table>

<%
	}
%>


<portlet:renderURL var="renderURL" />

<a href="<%=renderURL%>">Render URL</a>
<br />