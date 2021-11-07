package od.james;

import java.util.Locale;

/* CODE REVIEW COMMENT: Please update this comment to be more descriptive on what the EncryptionMachine class is and its general functionality. */
/* CODE REVIEW COMMENT: Please ensure that the comment has the same class name as the actual class. */
/**
 * The encryption class
 */
public class EncryptionMachine {
    private final String charSet;
    private final int encShift;

    public EncryptionMachine(int encryptionShift, String alphabet){
        /* CODE REVIEW COMMENT: Nit 'enShift' could maybe updated to be more clear on what this variable is. */
        encShift = encryptionShift;
        charSet = alphabet;
    }

    /* CODE REVIEW COMMENT: Nit could update @return to include the data type in which it is returning
                            so that future users of this method know the return data type without looking in the method code. */
    /* CODE REVIEW COMMENT: BUG This method allows and attempts to encrypt non-alphabet characters. This method should either raise
                            an exception or indicate to the user that a non-alphabet characters can not be encrypted. */
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

    /* CODE REVIEW COMMENT: Nit could update @return to include the data type in which it is returning
                        so that future users of this method know the return data type without looking in the method code. */
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
