
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t= scn.nextInt();
		List<Integer[]> listOfArr = new ArrayList<Integer[]>();
		for(int i=0 ; i<t; i++) {
			int n = scn.nextInt();
			Integer[] arr = new Integer[n];
			for(int j=0; j<n; j++) {
				arr[j] = scn.nextInt();
			}
			listOfArr.add(arr);
		}
		for(Integer[] item: listOfArr) {
			if(item[0]+ item[1] <= item[item.length-1] ) {
				System.out.println("1 2 "+(item.length));
			}else{
				System.out.println(-1);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
	
