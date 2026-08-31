import java.util.*;
public class Solution {

	
	public static long getMinSteps(long array[], long s) {
		
		long steps = 0;
		int mid = array.length/2;
		long median = array[(array.length/2)];
		if(median == s) {
			return steps;
		}
		
		steps = Math.abs(median - s);
		median = s;
		
		if((array[mid] - s) < 0) {
			int index=mid+1;
			while(index < array.length && array[index] < median ) {
				steps+= median - array[index];
				index++;
			}
		}
		else {
			int index=mid-1;
			while(index >= 0 && array[index] > median) {
				steps+= array[index] - median;
				index--;
			}
		}
		return steps;
	}
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		long s = input.nextLong();
		long array[] = new long[size];
		for(int index=0; index < size; index++) {
			array[index] = input.nextLong();
		}
		Arrays.sort(array);
		System.out.println(getMinSteps(array,s));
	}
	
}
