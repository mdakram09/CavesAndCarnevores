import Items.InventoryItem;

import java.io.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;


public class FileManager {


    public FileManager(){
    }

    public JSONObject readFile(String resourceName) throws IOException, ClassNotFoundException {

        InputStream is = Class.forName("FileManager").getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONObject content = new JSONObject(tokener);

        // Convert JSON string to JSONObject
        return content;
    }


}
