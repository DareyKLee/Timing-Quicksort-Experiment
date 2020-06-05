import java.util.Random;

public class Main {

	static boolean questionSet1 = true;
	static boolean questionSet2 = false;
	static boolean questionSet3 = false;
	
	static int arraySize = 100000000;
	static int array[] = new int[arraySize];
	static int rangeOfValues = arraySize * 10;
	static int regionSize = 10;
	
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("==================== TRIAL " + i + " ====================");
			
			setUpArray();
			
			LomutoQuicksort lomutoQuicksort = new LomutoQuicksort(array.clone());
			lomutoQuicksort.analyze();
			
			HoareQuicksort hoareQuicksort = new HoareQuicksort(array.clone());
			hoareQuicksort.analyze();
			
			MedianOfThreeQuicksort medianQuicksort = new MedianOfThreeQuicksort(array.clone());
			medianQuicksort.analyze();
			
			CutoffQuicksort cutoffQuickSort = new CutoffQuicksort(array.clone(), regionSize);
			cutoffQuickSort.analyze();
		}
	}
	
	private static void setUpArray() {
		Random random = new Random();
		
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(rangeOfValues);
		}
	}
}
