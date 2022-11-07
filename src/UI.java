import java.util.Scanner;

public class UI {
    Scanner scanInput = new Scanner(System.in);

    public String readString() {
        return scanInput.nextLine();
    }

    public int readInputInt() {
        boolean keepgoing = true;
        while (keepgoing) {
            System.out.println("Type a number:");
            if (scanInput.hasNextInt()) {
                int input = scanInput.nextInt();
                scanInput.nextLine();
                keepgoing = false;
                return input;
            } else {
                scanInput.next();
                System.out.println("It must be an integer!");
            }
        }
        return 0;
    }
}
