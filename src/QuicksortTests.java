
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuicksortTests {

	static int arraySize = 10000000;
	static int array[] = new int[arraySize];
	static int rangeOfValues = arraySize * 10;
	static int regionSize = 10;
	
	@BeforeEach
	void populateArray() {
		Random random = new Random();
		
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(rangeOfValues);
		}
	}
	
	@Test
	void LomutoQuicksortTest() {
		Boolean outOfOrder = false;
		
		LomutoQuicksort lomutoQuicksort = new LomutoQuicksort(array.clone());
		lomutoQuicksort.analyze();
		
		int[] lomutoArray = lomutoQuicksort.getArray();
		
		for (int i = 0; i < lomutoArray.length - 1; i++) {		
			if (lomutoArray[i] > lomutoArray[i + 1]) {
				outOfOrder = true;
			}
		}
		
		assertFalse(outOfOrder);
	}
	
	@Test
	void HoareQuicksortTest() {
		Boolean outOfOrder = false;
		
		HoareQuicksort hoareQuicksort = new HoareQuicksort(array.clone());
		hoareQuicksort.analyze();
		
		int[] hoareArray = hoareQuicksort.getArray();
		
		for (int i = 0; i < hoareArray.length - 1; i++) {
			if (hoareArray[i] > hoareArray[i + 1]) {
				outOfOrder = true;
			}
		}
		
		assertFalse(outOfOrder);
	}
	
	@Test
	void MedianOfThreeTest() {
		Boolean outOfOrder = false;
		
		MedianOfThreeQuicksort medianOfThreeQuicksort = new MedianOfThreeQuicksort(array.clone());
		medianOfThreeQuicksort.analyze();
		
		int[] medianOfThreeArray = medianOfThreeQuicksort.getArray();
		
		for (int i = 0; i < medianOfThreeArray.length - 1; i++) {
			if (medianOfThreeArray[i] > medianOfThreeArray[i + 1]) {
				outOfOrder = true;
			}
		}
		
		assertFalse(outOfOrder);
	}
	
	@Test
	void CutoffQuicksortTest() {
		Boolean outOfOrder = false;
		
		CutoffQuicksort cutoffQuicksort = new CutoffQuicksort(array.clone(), regionSize);
		cutoffQuicksort.analyze();
		
		int[] cutoffArray = cutoffQuicksort.getArray();
		
		for (int i = 0; i < cutoffArray.length - 1; i++) {
			if (cutoffArray[i] > cutoffArray[i + 1]) {
				outOfOrder = true;
			}
		}
		
		assertFalse(outOfOrder);
	}
}
