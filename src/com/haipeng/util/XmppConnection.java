package com.haipeng.util;

import java.io.File;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class XmppConnection {
	private static int SERVER_PORT;
	private static String SERVER_NAME;
	private static String SERVER_HOST;
	private static XMPPConnection connection = null;

	private static void openConnection() {
		try {
			if(null == connection || !connection.isAuthenticated())
			{
				ConnectionConfiguration config = 
						new ConnectionConfiguration(SERVER_HOST,
								SERVER_PORT,SERVER_NAME);
				config.setReconnectionAllowed(true);
				config.setSendPresence(true);
				config.setReconnectionAllowed(true);
				config.setSecurityMode(ConnectionConfiguration.SecurityMode.enabled);
				
				File file = new File("/mnt/sdcard/security/");
				file.mkdirs();
				config.setKeystorePath(arg0)
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
