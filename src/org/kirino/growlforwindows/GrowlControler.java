package org.kirino.growlforwindows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class GrowlControler {
	public static final String LINE_SEPARATOR = "\r\n";
	public static final String SEQTION_SEPARATOR = "";
	public static final String END_OF_REQUEST = "\r\n\r\n";

	public static final String LOCALHOST = "localhost";
	public static final int GROWL_PORT = 23053;


	public void registerNotify(Application app,List<Notification> notificationList) throws UnknownHostException, IOException {
		List<String> requestParameterList = new ArrayList<String>();
		requestParameterList.add("GNTP/1.0 REGISTER NONE");
		requestParameterList.add(String.format("Application-Name: %s",app.getApplicationName()));

		if(app.getApplicationIconUrl().equals("") == false) {
			requestParameterList.add(String.format("Application-Icon: %s",app.getApplicationName()));
		}
		requestParameterList.add(String.format("Notifications-Count: %s",notificationList.size()));
		for(Notification param:notificationList) {
			requestParameterList.add(SEQTION_SEPARATOR);
			requestParameterList.add(String.format("Notification-Name: %s",param.getNotificationName()));
			if(param.getDisplayName().equals("") == false) {
				requestParameterList.add(String.format("Notification-Display-Name: %s",param.getDisplayName()));
			}

			requestParameterList.add(String.format("Notification-Enabled: %s",String.valueOf(param.isNotificationEnable())));
			if(param.getNotificationIconUrl().equals("") == false) {
				requestParameterList.add(String.format("Notification-Icon: %s",param.getNotificationIconUrl()));
			}
		}
		sendToGrowl(requestParameterList);

	}

	public void sendNotify(String applicationName,String notificationName,String notificationTitle,String notificationText) throws UnknownHostException, IOException {
		List<String> requestParameterList = new ArrayList<String>();
		requestParameterList.add("GNTP/1.0 NOTIFY NONE");
		requestParameterList.add(String.format("Application-Name: %s",applicationName));
		requestParameterList.add(String.format("Notification-Name: %s",notificationName));
		requestParameterList.add(String.format("Notification-Title: %s",notificationTitle));
		requestParameterList.add(String.format("Notification-Text: %s",notificationText));
		sendToGrowl(requestParameterList);
	}



	private void sendToGrowl(List<String> requestParameterList) throws UnknownHostException, IOException {
		Socket socket = new Socket(LOCALHOST,GROWL_PORT);
		socket.setSoTimeout(5000);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8") );

			for (String param:requestParameterList) {
				out.write(param + LINE_SEPARATOR);
			}
			out.write(END_OF_REQUEST);
			out.flush();

			String line = in.readLine();

			if(line.contains("-OK") == false) {
				throw new GrowlException();
			}

			out.close();
			in.close();
			socket.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
