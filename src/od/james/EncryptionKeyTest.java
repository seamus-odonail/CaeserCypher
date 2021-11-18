package od.james;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EncryptionKeyTest {
	
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
    public void coverage() {
    	WhiteBoxTestSuite a = new WhiteBoxTestSuite();
    }

	@Test
	public void testWrongEncryptionKeyMain() {
		final String testWrongEncryptionKey = "csc";
		provideInput(testWrongEncryptionKey);

		Main.main(new String[0]);
		
		assertEquals("Enter encryption key: \r\nIncorrect encryption key.\r\n", getOutput());
	}

}
