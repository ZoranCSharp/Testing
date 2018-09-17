package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class Test1 {
	
	
	private String str;

	@BeforeAll
	static void beforeAll() {
		System.out.println("Initialize connection to database");
	}
	
	@AfterAll
	static void AfterAll() {
		System.out.println("Close connection to database");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initalize test data for " + info.getDisplayName());
	}
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("Clean Up after each " + info.getDisplayName());
	}
	
	
	@Test
	void test() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		
		assertEquals(expectedLength, actualLength);
	}
	
	@Test
	
	void toUpperCase() {
		
		String str = "abcd";
		String result = str.toUpperCase();
		assertNotNull(result);
		assertEquals("ABCD", result);
		
	}
	
	@Test
	
	void contains_basic() {
		
		/*String str = "abcdefgh";
		boolean result = str.contains("ijk");
		//assertEquals(false, result);
		assertFalse(result); //or assertTrue
		//assertEquals(false, result);*/
		assertFalse("abcdefgh".contains("ijk")); //or assertTrue
	}
	
	@Test
	
	void split_basic() {
		String str = "abc def ghi";
		String actualResult[] = str.split(" ");
		String expectedResult[] = new String[] {"abc", "def", "ghi"};
		assertArrayEquals(expectedResult, actualResult);
	}
	
	@Test
	void lengthException() {
		String str = null;
		
		assertThrows(NullPointerException.class, ()->{str.length();});
	}
	
	@Test
	@DisplayName(" - When lenght is null, throw an exception")
	void lengthExceptionDisplayName() {
		String str = null;
		
		assertThrows(NullPointerException.class, ()->{str.length();});
	}
	
	@Test
	void lengthGreaterThanZero() {
		assertTrue("ABCDF".length()>0);
		assertTrue("AB".length()>0);
		assertTrue("CDF".length()>0);
		assertTrue("F".length()>0);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"ABCDF","AB","CDF","F"})
	void lengthGreaterThanZeroUsingParameterizedTest(String str) {
		assertTrue(str.length()>0);
		
	}
	
	@ParameterizedTest
	@CsvSource(value = {"abcdf,ABCDF","'',''","abcd,ABCD","abcdefgh,ABCDEFGH"})
	void upperCase(String word, String capitalizedWord) {
		assertEquals(capitalizedWord,word.toUpperCase());			
	}
	
	@ParameterizedTest(name = "{0} length is {1}")
	@CsvSource(value = {"abcdf,5","'',0","abcd,4","abcdefgh,8"})
	void length(String word, int expectedLength) {
		assertEquals(expectedLength,word.length());			
	}
	
	
	@RepeatedTest(10)
	@Disabled
	void containsRepeating() {
		assertFalse("abcdf".contains("ijk"));
	}
	
	@Test
	@Disabled //@Ignored
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(5), ()-> { for(int i =0; i<=1000000;i++) {
			                                        int j = i;
		                                            System.out.println(j);} });
	}
	
	@Nested
	@DisplayName(" - For an empty string")
	class EmptyStringTests{
		
		@BeforeEach
		void setToEmpty() {
			str = "";
		}
		
		@Test
		@DisplayName("Length should be zero")
		void lengthIsZero() {
			assertEquals(0,str.length());
		}
		
		@Test
		@DisplayName("upper case is empty")
		void upperCaseIsEmpty() {
			assertEquals("", str.toUpperCase());
		}
	}

}



































