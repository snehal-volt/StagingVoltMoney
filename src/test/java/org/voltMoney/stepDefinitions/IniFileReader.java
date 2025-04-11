package org.voltMoney.stepDefinitions;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class IniFileReader {

    private static Ini ini;
    static {
        try {
            // Load the INI file
            File configFile = new File("src/test/java/org/voltMoney/configurations/config.ini");
            ini = new Ini(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl(){
        return ini.get("qa.staging", "base_url");
    }

    public static String getBrowser(){
        return ini.get("qa.staging", "browser");
    }


}
