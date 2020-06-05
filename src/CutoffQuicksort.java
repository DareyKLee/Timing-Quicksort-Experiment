/*
 * Insertion sort implementation obtained from geeksforgeeks.org
 */

public class CutoffQuicksort {
	private int[] originalArray;
	private int regionSize;
	private long startTime;
	private long endTime;

	private int[] copyArray;
	
	public CutoffQuicksort(int[] array, int regionSize) {
		this.originalArray = array;
		this.regionSize = regionSize;
	}

	public void analyze() {
		for ( ; regionSize <= 200; regionSize += 10) {
			copyArray = originalArray.clone();
			start();
			quicksort(0, copyArray.length - 1);
			insertionSort(0, copyArray.length - 1);
			end();
			result();
			
			/**************************************/
			for (int i = 0; i < copyArray.length - 1; i++) {
				if (copyArray[i] > copyArray[i + 1]) {
					System.out.println("NOT SORTED");
				}
			}
			/**************************************/
		}
	}

	public int[] getArray() {
		return copyArray;
	}
	
	private void quicksort(int low, int high) {
		if (low + regionSize <= high) {
			int pivot = copyArray[low];
			int i = low;
			int j = high;

			while (i <= j) {
				while (copyArray[i] < pivot) {
					i++;
				}
				while (copyArray[j] > pivot) {
					j--;
				}

				if (i <= j) {
					exchange(i, j);
					i++;
					j--;
				}
			}

			if (low < j) {
				quicksort(low, j);
			}

			if (i < high) {
				quicksort(i, high);
			}
		}
	}

	private void insertionSort(int start, int end) {
		for (int i = start + 1; i <= end; i++) {
			int key = copyArray[i];
			int j = i - 1;

			while (j >= 0 && copyArray[j] > key) {
				copyArray[j + 1] = copyArray[j];
				j--;
			}

			copyArray[j + 1] = key;
		}
	}

	private void exchange(int i, int j) {
		int temp = copyArray[i];
		copyArray[i] = copyArray[j];
		copyArray[j] = temp;
	}

	private void start() {
		startTime = System.nanoTime();
	}

	private void end() {
		endTime = System.nanoTime();
	}

	private void result() {
		System.out.println("Cutoff Quicksort, Region Size " + regionSize + ", Total Time : " + (endTime - startTime));
	}
}
