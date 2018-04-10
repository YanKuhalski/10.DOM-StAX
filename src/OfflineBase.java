import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class OfflineBase extends PatientBase implements InfoBase {
    OfflineBase(String name) {
        super(name);
    }

    public List<Patient> getAllInfo() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(name);
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getChildNodes();
            addPatientsInListByDOM(nodeList);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void addPatientsInListByDOM(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                try {
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String secondName = eElement.getElementsByTagName("secondName").item(0).getTextContent();
                    String date = eElement.getElementsByTagName("birthday").item(0).getTextContent();
                    Date birthday = sdf.parse(date);
                    boolean healthy = Boolean.valueOf(eElement.getElementsByTagName("healthy").item(0).getTextContent());
                    list.add(new Patient(name, secondName, birthday, healthy));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addAllInfo(List<Patient> patientList) {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer;
            writer = output.createXMLStreamWriter(new FileWriter("OfflinePatientBase.xml"));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("patientBase");
            for (Patient patient : patientList) {
                writer.writeStartElement("patient");
                writer.writeStartElement("name");
                writer.writeCharacters(patient.getName());
                writer.writeEndElement();
                writer.writeStartElement("secondName");
                writer.writeCharacters(patient.getSecondName());
                writer.writeEndElement();
                writer.writeStartElement("birthday");
                writer.writeCharacters(sdf.format(patient.getBirthday()));
                writer.writeEndElement();
                writer.writeStartElement("healthy");
                writer.writeCharacters(String.valueOf(patient.isHealthy()));
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
