import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class LoggingThoseActions {
    File file = new File("src/Files/Log.txt"); //Creating file
    PrintStream printStream = null;
    LocalDateTime dateTime = LocalDateTime.now(); //used for printing to logfile
    UI ui = new UI(); //dealing with inputs from user
    Menu menu = new Menu(); //menuPrint
    private ArrayList<String> lines = new ArrayList<>(); //saves users string inputs
    public void makeChoice() {
        boolean keepgoing = true;
        while (keepgoing) {
            menu.printMenu();
            switch (ui.readInputInt()) {
                case 1:
                    addLine();
                    break;
                case 2:
                    viewLines();
                    break;
                case 3:
                    deleteLine();
                    break;
                case 9:
                    logAction("TERMINATING PROGRAM\n");
                    keepgoing = false;
                    terminateSystemPrint();
                    break;
            }
        }
    }

    public void addLine() { //makes user able to add lines to array and log the action
        try {
            System.out.println("Write something and finish with enter");
            String input = ui.readString();
            lines.add(input);
            printStream = new PrintStream(new FileOutputStream(file, true));
            printStream.append(getFormattedDateTimeWithAction("Adding new line: ") + "\"" + input +
                    "\"" + "\n");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private void viewLines() { //makes the user able to see all lines from array
        try {
            printStream = new PrintStream(new FileOutputStream(file, true));
            printStream.append(getFormattedDateTimeWithAction("Viewing all lines.") + "\n");
            printArray();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void printArray() { //printing the array for viewlines method
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private void deleteLine() { //makes the user able to delete lines from array and log the action
        try {
            System.out.println("What position does the line have?");
            int index = ui.readInputInt();
            System.out.println("Line: " + lines.get(index) + ". Will now be deleted.");
            printStream = new PrintStream(new FileOutputStream(file, true));
            printStream.append(getFormattedDateTimeWithAction("Deleting line: " + "#" + index + ": ") +
                    lines.get(index) + "\n");
            lines.remove(index);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void logAction(String action) { //method for logging only an action start or terminate
        try {
            printStream = new PrintStream(new FileOutputStream(file, true));
            printStream.append(getFormattedDateTimeWithAction(action));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void terminateSystemPrint() { //this is just for fun xD
        try {
            System.out.println("System gonna terminate in");
            Thread.sleep(1000);
            System.out.println(3);
            Thread.sleep(1000);
            System.out.println(2);
            Thread.sleep(1000);
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getFormattedDateTimeWithAction(String action) { //a formatted string for date and action logs
        return dateTime.getYear() + ":" + dateTime.getMonth().getValue() + ":" + dateTime.getDayOfMonth() +
                ":" + dateTime.getHour() + ":" + dateTime.getMinute() + ":" +
                dateTime.getSecond() + ": " + action;
    }
}
