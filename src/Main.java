public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        int operationNumber;
        do {
            operationNumber = menu.getChoice();
            menu.chooseOperation(operationNumber).perform();
        } while (!(operationNumber == 0));
    }
}