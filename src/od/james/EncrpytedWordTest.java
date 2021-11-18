package od.james;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class EncrpytedWordTest {

	@Test
	public void testEncryptLetterNegitiveShift() {
		EncryptionMachine encryptionMachine = new EncryptionMachine(Main.SHIFT * -1, Main.ALPHABET);
		char encryptedLetter = encryptionMachine.encryptLetter('a');
		assertEquals('x', encryptedLetter);
		char encryptedLetterWrapped = encryptionMachine.encryptLetter('z');
		assertEquals('w', encryptedLetterWrapped);
	}
	
	@Test
	public void testEncryptedWord() {
		EncryptionMachine encryptionMachine = new EncryptionMachine(Main.SHIFT, Main.ALPHABET);
		String encryptedWord = encryptionMachine.encryptWord("yza");
		assertEquals("bcd", encryptedWord);
	}

}
