package lolapp;

import java.net.URL;

public class InternetConnection {

	public boolean getConnection() {
		try {
			URL url = new URL("http://www.google.com");
			url.openConnection().connect();
			
			return true;
		} catch (Exception e) {
			return false;

		}
	}

}
