import java.util.*;

public class Registrator implements AddNewPatients {
    private List<Patient> newPatientList = new ArrayList<>();

    @Override
    public void getInfo() {
        PatientImput patientImput = new ConsolePatientImput();
        newPatientList.add(patientImput.input());
    }

    @Override
    public List<Patient> addNewInfo(List<Patient> patientList) {
        Set<Patient> allPatients = new TreeSet<>(new PatientComparator());
        allPatients.addAll(newPatientList);
        allPatients.addAll(patientList);
        patientList.clear();
        patientList.addAll(allPatients);
        return patientList;
    }
}