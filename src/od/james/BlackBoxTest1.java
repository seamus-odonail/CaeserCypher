package od.james;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlackBoxTest1 {

	
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;
	
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    public void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    
	@Test
	public void testBlackBox1() {
		final String testWrongEncryptionKey = "hello\n9\nThe\nQuick\nBrown\nFox\nJumped\nOver\nThe\nLazy\nDog";
		provideInput(testWrongEncryptionKey);

		Main.main(new String[0]);
		
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
