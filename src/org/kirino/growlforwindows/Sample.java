package org.kirino.growlforwindows;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Sample {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Application app = new Application("customTest");
		Notification notification1 = new Notification("test", "test", true);
		Notification notification2 = new Notification("test2", "test2", true);
		Notification notification3 = new Notification("test3", "test3", true);

		List<Notification> notificationList = new ArrayList<Notification>();
		notificationList.add(notification1);
		notificationList.add(notification2);
		notificationList.add(notification3);

		GrowlControler gc = new GrowlControler();
		gc.registerNotify(app, notificationList);
		gc.sendNotify("customTest", "test", "魔法少女", "まどか☆マギカ");
	}

}
