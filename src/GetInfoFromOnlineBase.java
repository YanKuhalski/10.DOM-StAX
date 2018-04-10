import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;
import java.util.TreeSet;

public class GetInfoFromOnlineBase implements Operation {
    @Override
    public void perform() {
        OnlineBase patientBase = new OnlineBase("https://raw.githubusercontent.com/YanKuhalski/Different/master/OnlinePatientBase.xml");
        try {
            TreeSet<Patient> patients = patientBase.getAllInfo();
            for (Patient patient : patients) {
                System.out.println(patient);
            }
            System.out.println("Операция завершена , произведите выбор необходимой операции повторно");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
