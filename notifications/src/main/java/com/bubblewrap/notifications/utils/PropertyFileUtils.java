package com.bubblewrap.notifications.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtils {

	private static PropertyFileUtils utils = null;
	private Properties properties;

	private PropertyFileUtils() {
		properties = new Properties();
	}

	public static PropertyFileUtils getInstance() {
		if (utils == null) {
			utils = new PropertyFileUtils();
		}
		return utils;
	}

	public void loadPropertiesFile(String propFile) {
		InputStream input = null;
		try {

			// load the file
			InputStream in = PropertyFileUtils.class.getClassLoader().getResourceAsStream(propFile);
			properties.load(in);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Object getProperty(String propName) {
		return properties.get(propName);
	}

}
