import java.util.Arrays;
import java.util.Scanner;


public class B {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numBooks = in.nextInt();
		int[] freq = new int[in.nextInt()+1];
		for(int i = 0; i<numBooks; i++){
			freq[in.nextInt()]++;
		}
		int ops = 0;
		for(int i = 0; i<freq.length; i++){
			for(int j =i+1 ; j<freq.length; j++){
				ops+=freq[i]*freq[j];
			}
		}
		System.out.println(ops);
	}
}