import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsolePatientImput implements PatientImput {
    private Scanner in = new Scanner(System.in);

    @Override
    public Patient input() {
        System.out.println("Введите имя ");
        String name = in.nextLine();
        System.out.println("Введите фамилию ");
        String secondName = in.nextLine();
        System.out.println("Введите дату рождения ");
        Date birthday = birthday(in.nextLine());
        System.out.println("Болин ли пациет ");
        boolean healthy = in.hasNextBoolean();
        return new Patient(name, secondName, birthday, healthy);
    }

    private Date birthday(String birthday) {
        SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return std.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Неверный формат ввода даты , попробуйте снова");
            return birthday(in.nextLine());
        }
    }
}