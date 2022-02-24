/**
 * 
 */
package uf2181;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



/**
 * @author Fernando
 *
 */
class FuncionesDGTTest {

	private static FuncionesDGT f;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		f = new FuncionesDGT();
	}
	
	@Test
	void mediaPuntosTest() {
		int v1[] = {1,2,3,4};
		int v2[] = {2,2,2,2};
		int v3 [] = new int [0];
		assertEquals(2.5, f.mediaPuntos(v1));
		assertNotEquals(2.9, f.mediaPuntos(v1));
		assertEquals(2, f.mediaPuntos(v2));
		assertNotEquals(2.1, f.mediaPuntos(v2));
		assertThrows(ArrayIndexOutOfBoundsException.class, ()-> f.mediaPuntos(v3));
	}
	
	
	
	@Test
	void maximaTasaPermitidaTest() {
		assertEquals(0.25, f.maximaTasaPermitida("General", true));
		assertNotEquals(0.25, f.maximaTasaPermitida("General", false));
		assertNotEquals(0.25, f.maximaTasaPermitida("Novel", true));
		
		assertEquals(0.5, f.maximaTasaPermitida("General", false));
		assertNotEquals(0.5, f.maximaTasaPermitida("Novel", false));
		assertNotEquals(0.5, f.maximaTasaPermitida("General", true));
		
		assertEquals(0.15, f.maximaTasaPermitida("Novel", true));
		assertNotEquals(0.15, f.maximaTasaPermitida("Novel", false));
		assertNotEquals(0.15, f.maximaTasaPermitida("General", true));
		
		assertEquals(0.3, f.maximaTasaPermitida("Novel", false));
		assertNotEquals(0.3, f.maximaTasaPermitida("Novel", true));
		assertNotEquals(0.3, f.maximaTasaPermitida("General", true));
	}
	
}
