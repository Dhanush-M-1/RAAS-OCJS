

import java.util.Scanner;

public class Fake_NP {
	public static void main(String[] args) {
		
		int[] arr = new int[8];
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] linesplit = line.split(" ");
		int l = Integer.parseInt(linesplit[0]);
		int r = Integer.parseInt(linesplit[1]);
		for(int counter=2;counter<=9;counter++) {
			arr[counter-2]=r/counter - l/counter;
			if(arr[counter-2]==0) {
				if(r%counter==0 || l%counter==0) {
					arr[counter-2]=1;
				}
			}
		}
		int max = arr[0];
		int index =2;
		for(int counter=3;counter<=9;counter++) {
			if(arr[counter-2]>max) {
				arr[counter-2]=max;
				index = counter+2;
			}
		}
		if(r==l) {
			index=r;
		}
		System.out.println(index);
	}
}
