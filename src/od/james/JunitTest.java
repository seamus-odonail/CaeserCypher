package od.james;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class JunitTest {
	private Main mainTest;
	
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;
	
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;


    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

	@Test
	void testEncryptLetter() {
		EncryptionMachine encryptionMachine = new EncryptionMachine(Main.SHIFT, Main.ALPHABET);
		char encryptedLetter = encryptionMachine.encryptLetter('a');
		assertEquals('d', encryptedLetter);
		char encryptedLetterWrapped = encryptionMachine.encryptLetter('z');
		assertEquals('c', encryptedLetterWrapped);
	}
	
	@Test
	void testEncryptLetterNegitiveShift() {
		EncryptionMachine encryptionMachine = new EncryptionMachine(Main.SHIFT * -1, Main.ALPHABET);
		char encryptedLetter = encryptionMachine.encryptLetter('a');
		assertEquals('x', encryptedLetter);
		char encryptedLetterWrapped = encryptionMachine.encryptLetter('z');
		assertEquals('w', encryptedLetterWrapped);
	}
	
	@Test
	void testEncryptedWord() {
		EncryptionMachine encryptionMachine = new EncryptionMachine(Main.SHIFT, Main.ALPHABET);
		String encryptedWord = encryptionMachine.encryptWord("yza");
		assertEquals("bcd", encryptedWord);
	}
	
	@Test
	void testEncryptedWordNegitiveShift() {
		EncryptionMachine encryptionMachine = new EncryptionMachine(Main.SHIFT * -1, Main.ALPHABET);
		String encryptedWord = encryptionMachine.encryptWord("zab");
		assertEquals("wxy", encryptedWord);
	}
	
	@Test
	void testWrongEncryptionKeyMain() {
		final String testWrongEncryptionKey = "csc";
		provideInput(testWrongEncryptionKey);

		Main.main(new String[0]);
		
		assertEquals("Enter encryption key: \r\nIncorrect encryption key.\r\n", getOutput());

	}
	
	@Test
	void testMain() {
		final String testEncryptionKey = "csci\n9\nThe\nQuick\nBrown\nFox\nJumped\nOver\nThe\nLazy\nDog";

		provideInput(testEncryptionKey);
		
		mainTest = new Main();
		
		mainTest.main(null);
		
		assertEquals("Enter encryption key: \r\n"
				+ "How many words is your message?: \r\n"
				+ "Next word: \r\n"
				+ "\"The\" has been encrypted to: wkh\r\n"
				+ "Next word: \r\n"
				+ "\"Quick\" has been encrypted to: txlfn\r\n"
				+ "Next word: \r\n"
				+ "\"Brown\" has been encrypted to: eurzq\r\n"
				+ "Next word: \r\n"
				+ "\"Fox\" has been encrypted to: ira\r\n"
				+ "Next word: \r\n"
				+ "\"Jumped\" has been encrypted to: mxpshg\r\n"
				+ "Next word: \r\n"
				+ "\"Over\" has been encrypted to: ryhu\r\n"
				+ "Next word: \r\n"
				+ "\"The\" has been encrypted to: wkh\r\n"
				+ "Next word: \r\n"
				+ "\"Lazy\" has been encrypted to: odcb\r\n"
				+ "Next word: \r\n"
				+ "\"Dog\" has been encrypted to: grj\r\n"
				+ "Message fully encrypted. Happy secret messaging!: wkh txlfn eurzq ira mxpshg ryhu wkh odcb grj\r\n"
				, getOutput());

	}

}
