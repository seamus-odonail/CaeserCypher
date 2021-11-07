package od.james;

import java.util.Locale;
import java.util.Scanner;
/* CODE REVIEW COMMENT: Please include a comment that describes the purpose for 'Main' and its general functionality. */
public class Main {

    public static final int SHIFT = 3;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String ENCRYPTION_KEY = "csci";

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter encryption key: ");
        String encryptionKey = userInput.next();
        if(!ENCRYPTION_KEY.equals(encryptionKey.toLowerCase(Locale.ROOT)))
        {
            System.out.println("Incorrect encryption key.");
            /* CODE REVIEW COMMENT: It maybe better to throw an exception or return a specific value to indicate that the program did not complete execution. */
            return;
        }
        /* CODE REVIEW COMMENT: The following 2 lines can be removed as they are not being used. */
        // System.out.println("Shift amount (positive or negative value): ");
        // int shiftAmount = userInput.nextInt();
        System.out.println("How many words is your message?: ");
        /* CODE REVIEW COMMENT: If a user enters a values that is not an integer, the program throws a non-handled exception.
                                Please add exception handling that will gracefully fail the program*/
        int wordCount = userInput.nextInt();

        EncryptionMachine encMachine = new EncryptionMachine(SHIFT, ALPHABET);

        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 1; i <= wordCount; i++) {
            System.out.println("Next word: ");
            String userWord = userInput.next();
            /* CODE REVIEW COMMENT: Nit 'encWord' could maybe updated to be more clear on what this variable is. */
            String encWord = encMachine.encryptWord(userWord);
            encryptedMessage.append(encWord);
            if (i < wordCount) encryptedMessage.append(" ");
            System.out.println("\"" + userWord + "\" has been encrypted to: " + encWord);
        }
        System.out.println("Message fully encrypted. Happy secret messaging!: " + encryptedMessage);
    }
}
