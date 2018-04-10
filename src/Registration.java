import java.util.List;
import java.util.Scanner;

public class Registration implements Operation {

    @Override
    public void perform() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество новых пациентов");
        int quantity = in.nextInt();
        Registrator registrator = new Registrator();
        for (int i = 0; i < quantity; i++) {
            registrator.getInfo();
        }
        OfflineBase patientBase = new OfflineBase("OfflinePatientBase.xml");
        List<Patient> patientList = patientBase.getAllInfo();
        registrator.addNewInfo(patientList);
        patientBase.addAllInfo(patientList);
        System.out.println("Операция завершена , произведите выбор необходимой операции повторно");
    }
}