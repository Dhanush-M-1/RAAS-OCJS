import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
	
	public class Main {
	
		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			
			long n =input.nextLong();
			long m =input.nextInt();
			long counter=0;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int temp = input.nextInt();
				arr.add(temp);
				
			}
			Collections.sort(arr);
			for(int i=0;i<arr.size();){
				counter+=(arr.size()-Collections.frequency(arr, arr.get(i)))*Collections.frequency(arr, arr.get(i));
				i+=Collections.frequency(arr, arr.get(i));
			}
			
			System.out.println(counter/2);
			input.close();
			
		}
	}