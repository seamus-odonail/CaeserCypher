package od.james;

import java.util.Locale;
import java.util.Scanner;

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
            return;
        }
        // System.out.println("Shift amount (positive or negative value): ");
        // int shiftAmount = userInput.nextInt();
        System.out.println("How many words is your message?: ");
        int wordCount = userInput.nextInt();

        EncryptionMachine encMachine = new EncryptionMachine(SHIFT, ALPHABET);

        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 1; i <= wordCount; i++) {
            System.out.println("Next word: ");
            String userWord = userInput.next();
            String encWord = encMachine.encryptWord(userWord);
            encryptedMessage.append(encWord);
            if (i < wordCount) encryptedMessage.append(" ");
            System.out.println("\"" + userWord + "\" has been encrypted to: " + encWord);
        }
        System.out.println("Message fully encrypted. Happy secret messaging!: " + encryptedMessage);
    }
}
