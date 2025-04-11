package org.voltMoney.stepDefinitions;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonReader {

    private JSONObject jsonObject;

    public JsonReader(String filePath) throws IOException {
//        File file = new File(filePath);
//        InputStream inputStream = new FileInputStream(file);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        System.out.println(inputStream.read());
        if(inputStream == null){
            throw new RuntimeException("File not found: " + filePath);
        }
        JSONTokener tokener = new JSONTokener(inputStream);
        jsonObject = new JSONObject(tokener);
    }

    public String getValue(String...keys){
        JSONObject tempObject = jsonObject;
        for(int i = 0; i < keys.length - 1; i++){
            tempObject = tempObject.getJSONObject(keys[i]);
        }
        return tempObject.getString(keys[keys.length - 1]);
    }
}
