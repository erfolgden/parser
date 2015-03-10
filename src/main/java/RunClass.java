import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Den on 3/7/15.
 */
public class RunClass {
    public static String urlJson = "http://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice?output=json";
    public static String urlXml = "http://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice";

    public static void main(String[] args) throws JSONException, IOException, SAXException, ParserConfigurationException {
        Parser jsonDocument = new Parser(urlJson);
        String resultDoc = jsonDocument.doInBackground();
        jsonDocument.parseJson(resultDoc);
        jsonDocument.getCount();
        //System.out.println(test.doInBackground());

        Parser xmlDocument = new Parser(urlXml);
        String resultXml = xmlDocument.doInBackground();
        xmlDocument.parseXML(resultXml);
        //System.out.println(resultXml);

    }
}
