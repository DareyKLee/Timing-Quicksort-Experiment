/*
 * Hoare Quicksort implementation obtained from geeksforgeeks.org
 */

public class HoareQuicksort {
	private int[] array;
	private long startTime;
	private long endTime;
	
	public HoareQuicksort(int[] array) {
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
		
			int pivot = array[low];
			int i = low - 1;
			int j = high + 1;
			
			while (true) {
				do {
					i++;
				} while (array[i] < pivot);
				
				do {
					j--;
				} while (array[j] > pivot);
				
				if (i < j) {
					exchange(i, j);
				} else {
					break;
				}
			}
			
			quicksort(low, j);
			quicksort(j + 1, high);
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
		System.out.println("Hoare Quicksort Total Time : " + (endTime - startTime));
	}
}
