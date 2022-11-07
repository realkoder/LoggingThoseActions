public class Main {
    LoggingThoseActions loggingThoseActions = new LoggingThoseActions();

    public void run() {
        loggingThoseActions.logAction("STARTING PROGRAM\n");
        loggingThoseActions.makeChoice();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
