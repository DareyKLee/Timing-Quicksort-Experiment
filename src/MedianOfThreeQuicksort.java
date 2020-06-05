/*
 * Median of three partitioning quicksort implementation obtained from javacodegeeks.com
 */

public class MedianOfThreeQuicksort {

	private int[] array;
	private long startTime;
	private long endTime;
	
	public MedianOfThreeQuicksort(int[] array) {
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
	
	private void quicksort(int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = getMedian(left, right);
		int partition = partition(left, right, pivot);
		
		quicksort(left, partition - 1);
		quicksort(partition + 1, right);
	}
	
	private int partition(int left, int right, int pivot) {
		int leftCursor = left - 1;
		int rightCursor = right;
		while (leftCursor < rightCursor) {
			while (array[++leftCursor] < pivot);
			while (rightCursor > 0 && array[--rightCursor] > pivot);
			if (leftCursor >= rightCursor) {
				break;
			} else {
				exchange(leftCursor, rightCursor);
			}
		}
		exchange(leftCursor, right);
		return leftCursor;
	}
	
	private int getMedian(int left, int right) {
		int center = (left + right) / 2;
		
		if (array[left] > array[center]) {
			exchange(left, center);
		}
		
		if (array[left] > array[right]) {
			exchange(left, right);
		}
		
		if (array[center] > array[right]) {
			exchange(center, right);
		}
		
		exchange(center, right);
		return array[right];
	}
	
	private void exchange(int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	private void start() {
		startTime = System.nanoTime();
	}
	
	private void end() {
		endTime = System.nanoTime();
	}
	
	private void result() {
		System.out.println("Median Quicksort Total Time : " + (endTime - startTime));
	}
}
