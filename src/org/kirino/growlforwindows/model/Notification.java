package org.kirino.growlforwindows.model;

public class Notification {
	private String notificationName = ""; //Growlに登録するnotificationName
	private String displayName = ""; //Growlに登録するdisplayName
	private boolean notificationEnable = true; //notifyの利用する・しないのフラグ
	private String notificationIconUrl = ""; //notifyに利用するアイコンURL


	/**
	 * コンストラクタ<br>
	 * notifyのアイコンはGrowlのデフォルトのものが利用される
	 * @param notificationName
	 * @param displayName
	 * @param notificationEnable
	 */
	public Notification(String notificationName, String displayName,
			boolean notificationEnable) {
		super();
		this.notificationName = notificationName;
		this.displayName = displayName;
		this.notificationEnable = notificationEnable;
		this.notificationIconUrl = "";
	}

	/**
	 * コンストラクタ<br>
	 * notifyのアイコンは指定されたものが利用される。URL形式であること。
	 * @param notificationName
	 * @param displayName
	 * @param notificationEnable
	 * @param notificationIconUrl
	 */
	public Notification(String notificationName, String displayName,
			boolean notificationEnable, String notificationIconUrl) {
		super();
		this.notificationName = notificationName;
		this.displayName = displayName;
		this.notificationEnable = notificationEnable;
		this.notificationIconUrl = notificationIconUrl;
	}



	public String getDisplayName() {
		return displayName;
	}

	public String getNotificationIconUrl() {
		return notificationIconUrl;
	}

	public String getNotificationName() {
		return notificationName;
	}

	public boolean isNotificationEnable() {
		return notificationEnable;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setNotificationEnable(boolean notificationEnable) {
		this.notificationEnable = notificationEnable;
	}

	public void setNotificationIconUrl(String notificationIconUrl) {
		this.notificationIconUrl = notificationIconUrl;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

	@Override
	public String toString() {
		return "Notification [notificationName=" + notificationName
		+ ", displayName=" + displayName + ", notificationEnable="
		+ notificationEnable + ", notificationIconUrl="
		+ notificationIconUrl + "]";
	}


}
