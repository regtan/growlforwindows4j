package org.kirino.growlforwindows;

public class Application {
	private String applicationName = ""; //Growlに登録するアプリケーション名
	private String applicationIconUrl = ""; //Growlに登録するアプリケーションのアイコンURL

	/**
	 * コンストラクタ<br>
	 * アプリケーションのアイコンはgrowl for windowsのものが指定される
	 * @param applicationName
	 */
	public Application(String applicationName) {
		super();
		if (applicationName == null) {
			throw new IllegalArgumentException("applicationName must not be null");
		}
		this.applicationName = applicationName;
		this.applicationIconUrl = "";
	}

	/**
	 * コンストラクタ<br>
	 * アプリケーションのアイコンは指定されたものが利用される。URL形式であること。
	 * @param applicationName
	 * @param applicationIconUrl
	 */
	public Application(String applicationName, String applicationIconUrl) {
		super();
		if (applicationIconUrl == null) {
			throw new IllegalArgumentException("applicationIconUrl must not be null");
		}
		if (applicationName == null) {
			throw new IllegalArgumentException("applicationName must not be null");
		}

		this.applicationName = applicationName;
		this.applicationIconUrl = applicationIconUrl;
	}

	public String getApplicationIconUrl() {
		return applicationIconUrl;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationIconUrl(String applicationIconUrl) {
		if (applicationIconUrl == null) {
			throw new IllegalArgumentException("applicationIconUrl must not be null");
		}
		this.applicationIconUrl = applicationIconUrl;
	}

	public void setApplicationName(String applicationName) {
		if (applicationName == null) {
			throw new IllegalArgumentException("applicationName must not be null");
		}
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "Application [applicationName=" + applicationName
		+ ", applicationIconUrl=" + applicationIconUrl + "]";
	}


}
