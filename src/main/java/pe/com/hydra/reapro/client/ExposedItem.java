package pe.com.hydra.reapro.client;

import java.io.Serializable;

public class ExposedItem implements Serializable {
	private static final long serialVersionUID = 4885042571604275878L;
	String itemType;
	String itemID;
	String itemReference;
	String processAppID;
	String snapshotID;
	String snapshotName;
	String snapshotCreatedOn;
	String display;
	String tip;
	String branchID;
	String branchName;
	String startURL;
	String ID;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemReference() {
		return itemReference;
	}

	public void setItemReference(String itemReference) {
		this.itemReference = itemReference;
	}

	public String getProcessAppID() {
		return processAppID;
	}

	public void setProcessAppID(String processAppID) {
		this.processAppID = processAppID;
	}

	public String getSnapshotID() {
		return snapshotID;
	}

	public void setSnapshotID(String snapshotID) {
		this.snapshotID = snapshotID;
	}

	public String getSnapshotName() {
		return snapshotName;
	}

	public void setSnapshotName(String snapshotName) {
		this.snapshotName = snapshotName;
	}

	public String getSnapshotCreatedOn() {
		return snapshotCreatedOn;
	}

	public void setSnapshotCreatedOn(String snapshotCreatedOn) {
		this.snapshotCreatedOn = snapshotCreatedOn;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStartURL() {
		return startURL;
	}

	public void setStartURL(String startURL) {
		this.startURL = startURL;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
}
