package pe.com.hydra.reapro.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.json.JSONException;

import pe.com.hydra.reapro.client.ServiceRESTClient2;
import bpm.rest.client.BPMClientException;
import bpm.rest.client.authentication.AuthenticationTokenHandlerException;

public class BPMProcessLauncherPortlet extends GenericPortlet {

	@ProcessAction(name = "startProcess")
	public void startProcess(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {

		PortletPreferences preferences = request.getPreferences();
		String hostname = preferences.getValue("bpm.hostname",
				"bpm8.onp.gob.pe");
		int port = Integer.parseInt(preferences.getValue("bpm.port", "9080"));
		try {
			
			String bpdId = request.getParameter("itemID");
			String processAppId = request.getParameter("processAppID");
			
			System.out.println("---> bpdId=" + bpdId + ";processAppId=" + processAppId);
			
			ServiceRESTClient2 client = new ServiceRESTClient2(hostname, port);
			client.startProcess(bpdId,processAppId);
		} catch (AuthenticationTokenHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BPMClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		response.setContentType("text/html");
		// response.getWriter().println("Hello World");
		PortletPreferences preferences = request.getPreferences();
		// Hostname of the IBM Business Process Manager server
		String hostname = preferences.getValue("bpm.hostname",
				"bpm8.onp.gob.pe");
		System.out.println("hostname=" + hostname);
		// IBM Business Process Manager server port number
		int port = Integer.parseInt(preferences.getValue("bpm.port", "9080"));
		System.out.println("port=" + port);

		List processList = null;

		try {
			ServiceRESTClient2 client = new ServiceRESTClient2(hostname, port);
			processList = client.obtenerListaDeProcesos();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuthenticationTokenHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BPMClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PortletSession portletSession;
		if (request.isRequestedSessionIdValid()) {
			System.out.println("session is valid");
			portletSession = request.getPortletSession(false);
		} else {
			System.out.println("session is not valid");
			portletSession = request.getPortletSession(true);
		}
		portletSession.setAttribute("processList", processList);

		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/launcher.jsp")
				.include(request, response);

	}

}
