import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Gift {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("src/Usb.in"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] set = new int[m+1];
		
		for(int i = 0; i < n; i++) {
			set[sc.nextInt()]++;
		}
		
		int sum = 0;
		for(int i = 1; i < m+1; i++) {
			for(int j = i+1; j < m+1; j++) {
				sum += set[i] * set[j];
			}
		}
		System.out.println(sum);
	}
}
