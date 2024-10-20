import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@Test
	public void testStringInBounds() {
		assertFalse(CryptoManager.isStringInBounds("{}||"));
	}
	
	@Test
	public void testEncryptCaesar() {
		assertEquals("MJQQT%LZ^X", CryptoManager.caesarEncryption("HELLO GUYS", 5));
		assertEquals("ZRUOG", CryptoManager.caesarEncryption("WORLD", 3));

	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO GUYS", CryptoManager.caesarDecryption("MJQQT%LZ^X", 5));
		assertEquals("WORLD", CryptoManager.caesarDecryption("ZRUOG", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("PJXX^(L!%\"", CryptoManager.bellasoEncryption("HELLO GUYS", "HELLO"));
		assertEquals("_XZUL", CryptoManager.bellasoEncryption("WORLD", "HI"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("HELLO GUYS", CryptoManager.bellasoDecryption("PJXX^(L!%\"", "HELLO"));
		assertEquals("WORLD", CryptoManager.bellasoDecryption("_XZUL", "HI"));
	}

}
