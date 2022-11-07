import java.util.ArrayList;

public class Menu {
    private String menuHeader = "Menu";
    private String[] menuText = {"1. Add line", "2. View lines", "3. Delete line", "9. Quit"};

    public void printMenu() {
        System.out.println(menuHeader);
        for (String text : menuText) {
            System.out.println(text);
        }
    }
}
