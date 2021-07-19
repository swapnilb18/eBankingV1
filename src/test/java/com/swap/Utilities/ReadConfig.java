package com.swap.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		return prop.getProperty("baseURL");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getChromePath() {
		return prop.getProperty("chromePath");
	}

	public String getFirefoxPath() {
		return prop.getProperty("firefoxPath");
	}

	public String getEdgePath() {
		return prop.getProperty("edgePath");
	}
}
