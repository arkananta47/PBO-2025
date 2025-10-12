
/**
 * Write a description of class SupportSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class SupportSystem {
    private InputReader reader;
    private Responder responder;

    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
    }

    public void start() {
        boolean finished = false;
        printWelcome();

        while (!finished) {
            String input = reader.getInput();  // baca dari user
            if (input.equalsIgnoreCase("bye")) {
                finished = true;
            } else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }

        printGoodbye();
    }

    private void printWelcome() {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    private void printGoodbye() {
        System.out.println("Thank you for using the DodgySoft Support System. Goodbye!");
    }

    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.start();
    }
}
