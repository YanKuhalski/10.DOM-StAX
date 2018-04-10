import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements MakeChoice {
    private static Map<Integer, Operation> operations = new HashMap<>();

    Menu() {
        operations.put(1, new GetInfoFromOnlineBase());
        operations.put(2, new GetInfoFromOfflineBase());
        operations.put(3, new Registration());
        operations.put(0, new EndOfWork());
    }

    public Operation chooseOperation(int number) {
        return operations.get(number);
    }

    @Override
    public int getChoice() {
        System.out.println("1.Получить информацию из онлайн базы.");
        System.out.println("2.Получить информацию из офлайн базы.");
        System.out.println("3.Добавить пациентов.");
        System.out.println("0.Завершить работу.");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        while (choice > 3 || choice < 0) {
            System.out.println("Вы ввели неверное значение , повторите попытку");
            choice = in.nextInt();
        }
        return choice;
    }
}