package co.sy.exam1001;

import java.util.Arrays;

/****************
 * Hello world! *
 ****************
 ****************/
public class App {
	private static int[] arr = { 7, 9, 3, 6, 1, 4, 2, 5, 8, 10 };

	public static void main(String[] args) {
//		selectionSort();
//		toPrint();
//		System.out.println("================================");
//		newSelectionSort();
//		toPrint();
		RankAlgorithm rankAlgorithm = new RankAlgorithm();
		rankAlgorithm.toString();
	}

	private static String toPrint() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		} 
		System.out.println();
		return null;
	}
	
	private static void selectionSort() {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static void newSelectionSort() {
		int min, temp;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}

			if (i != min) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
