import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int numOfBack = scn.nextInt();//taking number of backet
		int lenOfSeg = scn.nextInt();//taking length of segment
		int[] backets = new int[numOfBack];
		
		for(int i = 0;i < numOfBack;i++) {
			int lenOfS = scn.nextInt();//length of segement
			backets[i] = lenOfS;
		}
		Arrays.sort(backets);
		
		for(int i = (numOfBack-1);i >= 0;i--) {
			//checking the minimum number of hours 
			if(lenOfSeg%backets[i] == 0) {
				System.out.println(lenOfSeg/backets[i]);
				break;
			}
		}
		scn.close();
	}
}
     			     									 		