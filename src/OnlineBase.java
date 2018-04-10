import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class OnlineBase extends PatientBase implements InfoBase {

    private TreeSet<Patient> onlineBase = new TreeSet<>(new PatientComparator());

    OnlineBase(String name) {
        super(name);
    }

    @Override
    public TreeSet<Patient> getAllInfo() throws IOException, ParseException, XMLStreamException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        URL URL;
        URL = new URL(this.name);
        HttpURLConnection connection;
        connection = (HttpURLConnection) URL.openConnection();
        connection.connect();
        XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(new InputStreamReader(connection.getInputStream()));

        String name = "";
        String secondName = "";
        String date = "2000-06-03";
        Date birthday = sdf.parse(date);
        String variableName = "";
        boolean healthy = false;
        while (xmlr.hasNext()) {
            xmlr.next();
            if (xmlr.isStartElement()) {
                variableName = xmlr.getLocalName();
            } else if (xmlr.isEndElement()) {
            } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                switch (variableName) {
                    case "name":
                        name = xmlr.getText();
                        break;
                    case "secondName":
                        secondName = xmlr.getText();
                        break;
                    case "birthday":
                        birthday = sdf.parse(xmlr.getText());
                        break;
                    case "healthy":
                        healthy = Boolean.valueOf(xmlr.getText());
                        break;
                }
            }
            if (xmlr.isEndElement()) {
                if (xmlr.getLocalName().equals("patient")) {
                    Patient patient = new Patient(name, secondName, birthday, healthy);
                    onlineBase.add(patient);
                }
            }
        }
        return onlineBase;
    }
}