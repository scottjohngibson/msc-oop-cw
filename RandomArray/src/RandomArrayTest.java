import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RandomArrayTest {

	
	@Test
	void addStringTest() {
		
		RandomArray ra = new RandomArray();
		ra.addString(null);
		assertTrue(Arrays.asList(ra.internal).contains(null));
	
	}

	public static void main(String[] args) {
		
		RandomArrayTest rat = new RandomArrayTest();
		rat.addStringTest();
	}
}
