import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient {
    private String name;
    private String secondName;
    private Date birthday;
    private boolean healthy;

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public boolean isHealthy() {
        return healthy;
    }

    Patient(String name, String secondName, Date birthday, boolean healthy) {
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.healthy = healthy;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String info = "Name : " + name
                + "\n" + "Surname : " + secondName
                + "\n" + "Birthday : " + sdf.format(birthday)
                + "\n" + "Healthy : " + healthy + "\n";
        return info;
    }
}