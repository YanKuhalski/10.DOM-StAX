import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class PatientBase {
    public String name;
    protected List<Patient> list = new ArrayList<>();
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    PatientBase(String name) {
        this.name = name;
    }

}