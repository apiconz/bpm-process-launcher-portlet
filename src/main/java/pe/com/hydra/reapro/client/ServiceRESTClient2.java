package pe.com.hydra.reapro.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bpm.rest.client.BPMClient;
import bpm.rest.client.BPMClientException;
import bpm.rest.client.BPMClientImpl;
import bpm.rest.client.authentication.AuthenticationTokenHandler;
import bpm.rest.client.authentication.AuthenticationTokenHandlerException;
import bpm.rest.client.authentication.was.WASAuthenticationTokenHandler;

public class ServiceRESTClient2 {

	private JSONObject resultados;
	private JSONObject argumentosDeConsulta;

	private BPMClient client;
	private final String BPD_ID = "25.c904b3b1-afc1-4698-bf5a-a20892c20275";
	private final String PROCESS_APP_ID = "2066.9ab0d0c6-d92c-4355-9ed5-d8a05acdc4b0";

	public ServiceRESTClient2(String hostname, int port)
			throws AuthenticationTokenHandlerException, BPMClientException {
		AuthenticationTokenHandler handler = new WASAuthenticationTokenHandler();

		client = new BPMClientImpl(hostname, port, handler);
	}

	public List<ExposedItem> obtenerListaDeProcesos() throws BPMClientException,
			AuthenticationTokenHandlerException, JSONException {
		System.out.println("--> obtenerListaDeProcesos");
		
		resultados = client.getExposedProcess();
		
		System.out.println("" + resultados.toString());
		
		JSONArray exposedItems = resultados.getJSONObject("data").getJSONArray("exposedItemsList");
		List<ExposedItem> exposedItemList = new ArrayList<ExposedItem>();
		System.out.println("expoItems.size:" + exposedItems.length());
		for (int i = 0; i < exposedItems.length(); i++) {
			JSONObject exposedItem = exposedItems.getJSONObject(i);
			ExposedItem item = new ExposedItem();
			System.out.println(":::" + exposedItem.getString("itemID"));
			item.setItemType(exposedItem.getString("type"));
			item.setItemID(exposedItem.getString("itemID"));
			item.setItemReference(exposedItem.getString("itemReference"));
			item.setProcessAppID(exposedItem.getString("processAppID"));
//			item.setSnapshotID(exposedItem.getString("snapshotID"));
//			item.setSnapshotName(exposedItem.getString("snapshotName"));
//			item.setSnapshotCreatedOn(exposedItem.getString("snapshotCreatedOn"));
//			System.out.println(":::" + exposedItem.getString("snapshotCreatedOn"));
			item.setDisplay(exposedItem.getString("display"));
//			item.setTip(exposedItem.getString("tip"));
//			item.setBranchID(exposedItem.getString("branchID"));
//			item.setBranchName(exposedItem.getString("branchName"));
			item.setStartURL(exposedItem.getString("startURL"));
			System.out.println(":::" + exposedItem.getString("startURL"));
			item.setID(exposedItem.getString("ID"));
			System.out.println(":::" + exposedItem.getString("ID"));
			exposedItemList.add(item);
			System.out.println("::::::::::::");
		}
		System.out.println("process items::::::" + exposedItemList.size());

		System.out.println("<-- obtenerListaDeProcesos");
		return exposedItemList;
	}

	private String formateDate(String originalDate) {
		System.out.println("originalDate=" + originalDate);
		SimpleDateFormat formatter, FORMATTER;
		formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date date = null;
		try {
			date = formatter.parse(originalDate.substring(0, 20));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FORMATTER = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
		return FORMATTER.format(date);
	}

}
