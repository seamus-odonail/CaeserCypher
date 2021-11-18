package od.james;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EncrpytedWordTest.class, EncryptionKeyTest.class, EncryptLetterTest.class, FunctionalTest.class })
public class WhiteBoxTestSuite {

}
