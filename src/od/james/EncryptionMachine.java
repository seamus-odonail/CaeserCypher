package od.james;

import java.util.Locale;

/**
 * The encryption class
 */
public class EncryptionMachine {
    private final String charSet;
    private final int encShift;

    public EncryptionMachine(int encryptionShift, String alphabet){
        encShift = encryptionShift;
        charSet = alphabet;
    }

    /**
     * Encrypt letter allows shifting in either a positive or negative direction
     * @param letter the original character to be encrypted
     * @return the encrypted character
     */
    public char encryptLetter(char letter){
        char[] explodedAlphabet = charSet.toCharArray();
        int baseIdx = charSet.indexOf(letter);
        int newIdx;
        if(encShift > 0){
            //moving right
            newIdx = baseIdx + encShift >= explodedAlphabet.length
                    ? (baseIdx + encShift) - (explodedAlphabet.length)
                    : baseIdx + encShift;
        }else{
            //moving left
            newIdx = baseIdx + encShift >= 0
                    ? baseIdx + encShift
                    : (baseIdx + encShift) + (explodedAlphabet.length);
        }
        return explodedAlphabet[newIdx];
    }

    /**
     * Allows for the encryption of a string
     * @param word a set of non-whitespace characters
     * @return the encrypted word
     */
    public String encryptWord(String word){
        StringBuilder builder = new StringBuilder();
        char[] explodedWord = word.toLowerCase(Locale.ROOT).toCharArray();
        for(char letter: explodedWord){
            builder.append(encryptLetter(letter));
        }
        return builder.toString();
    }
}
