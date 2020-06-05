/*
 * Lomuto Quicksort implementation obtained from outofmemory.programmingwith.com
 */

public class LomutoQuicksort {
	private int[] array;
	private long startTime;
	private long endTime;
	
	public LomutoQuicksort(int[] array) {
		this.array = array;
	}
	
	public void analyze() {	
		start();
		quicksort(0, array.length - 1);
		end();
		result();
		/**************************************/
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				System.out.println("NOT SORTED");
			}
		}
		/**************************************/
	}
	
	public int[] getArray() {
		return array;
	}
	
	private void quicksort(int low, int high) {
		if (low < high) {
			int pivot = array[high];
			int i = low;
			
			for (int j = low ; j < high; j++) {
				if (array[j] < pivot) {
					exchange(i, j);
					i++;
				}
			}
			exchange(i, high);
			
			quicksort(low, i - 1);
			quicksort(i + 1, high);
		}
	}
	
	private void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private void start() {
		startTime = System.nanoTime();
	}
	
	private void end() {
		endTime = System.nanoTime();
	}
	
	private void result() {	
		System.out.println("Lomuto Quicksort Total Time : " + (endTime - startTime));
	}
}
