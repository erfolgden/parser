import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Den on 3/7/15.
 */
public class Parser {
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultDoc = "";
    String resultUrl = "";
    int count = 0;

    public Parser(String url) {
        this.resultUrl = url;
    }

    String doInBackground() {
        try {
            URL url = new URL(resultUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            resultDoc = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDoc;
    }

    protected void parseJson(String strJson) throws JSONException {
            JSONArray array = new JSONArray(strJson);
            for (int i = 0; i < array.length(); i++) {
                JSONObject row = array.getJSONObject(i);
                System.out.println(row);
//                String id = row.getString("id");
//                String type = row.getString("type");
                count++;
            }
    }

    protected void parseXML(String strXml) {

    }

    public int getCount() {
        System.out.println("\n" + "Number of records = " + count + "\n");
        return count;
    }
}
