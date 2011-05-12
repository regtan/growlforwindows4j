package org.kirino.growlforwindows.sample;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.kirino.growlforwindows.GrowlControler;
import org.kirino.growlforwindows.model.Application;
import org.kirino.growlforwindows.model.Notification;

public class Sample {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("register application --start");
		Application app = new Application("customTest");
		Notification notification1 = new Notification("test", "test", true,"https://github.com/regtan/quickjunit_growlforwindows/blob/master/resource/icons/tsuiteerror.gif?raw=true");
		Notification notification2 = new Notification("test2", "test2", true);
		Notification notification3 = new Notification("test3", "test3", true);

		List<Notification> notificationList = new ArrayList<Notification>();
		notificationList.add(notification1);
		notificationList.add(notification2);
		notificationList.add(notification3);
		System.out.println("register application --end");

		System.out.println("send notify --start");
		GrowlControler gc = new GrowlControler();
		gc.registerNotify(app, notificationList);
		gc.sendNotify("customTest", "test", "タイトル", "メッセージ");
		System.out.println("send notify --end");
	}

}
