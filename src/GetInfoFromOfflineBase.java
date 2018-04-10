import java.util.List;

public class GetInfoFromOfflineBase implements Operation {
    @Override
    public void perform() {
        OfflineBase patientBase = new OfflineBase("OfflinePatientBase.xml");
        List<Patient> patients = patientBase.getAllInfo();
        for (Patient patient : patients) {
            System.out.println(patient);
        }
        System.out.println("Операция завершена , произведите выбор необходимой операции повторно");
    }
}