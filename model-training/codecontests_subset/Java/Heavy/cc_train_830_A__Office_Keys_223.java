import java.util.Arrays;
import java.util.Scanner;

public class OfficeKeys {
	
	static int[][] DP = new int[1000][2000];
	
	private static void intializeDP (int p, int k) {
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < k; j++) {
				DP[i][j] = -1;
			}
		}
	}
	
	public static int solveOfficeKeys (int[] people, int[] keys, int pIndex, int kIndex, int office){
		if (pIndex < people.length && kIndex == keys.length) {
			return Integer.MAX_VALUE;
		}
		
		if (pIndex == people.length && kIndex <= keys.length ) {
			return 0;
		}
		
		if (DP[pIndex][kIndex] == -1) {
			int currentCost  = Math.abs(people[pIndex] - keys[kIndex]) + Math.abs(office - keys[kIndex]);			
			DP[pIndex][kIndex] = Math.min(Math.max(currentCost,solveOfficeKeys(people, keys,pIndex + 1, kIndex + 1, office))
					,solveOfficeKeys(people, keys,pIndex, kIndex + 1, office));
		}
		return DP[pIndex][kIndex];
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		int k = scanner.nextInt();
		int office = scanner.nextInt();
		scanner.nextLine();
		int[] people = new int[p];
		int[] keys = new int[k];
		for (int i = 0; i < p; i++) {
			people[i] = scanner.nextInt();
		}
		scanner.nextLine();
		for (int i = 0; i < k; i++) {
			keys[i] = scanner.nextInt();
		}
		scanner.nextLine();
		Arrays.sort(people);
		Arrays.sort(keys);
		intializeDP(p, k);
		System.out.println( solveOfficeKeys (people, keys, 0, 0,  office));
	}

}
