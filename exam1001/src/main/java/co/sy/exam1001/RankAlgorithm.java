package co.sy.exam1001;

public class RankAlgorithm {
	private int[] grade = {80, 100, 77, 24, 35, 58, 80, 47 };
	private int[] rankArr;
	
	private void rank() {
		rankArr = new int[grade.length];
		for(int i = 0 ; i < rankArr.length; i++) {
			rankArr[i] = 1;
		}
		
		for(int i = 0 ; i < grade.length; i++) {
			for(int j = i + 1; j < grade.length; j++) {
				if(grade[i] > grade[j]) {
					rankArr[j]++;
				} else if(grade[i] < grade[j]) {
					rankArr[i]++;
				}
			}
		}
	}
	
	public String toString() {
		rank();
		for(int g : grade) {
			System.out.print(g + " ");
		}
		System.out.println();
		for(int r : rankArr) {
			System.out.print(r + " ");
		}
		System.out.println();
		return null;
	}
}
