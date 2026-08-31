import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
        new Main();
    }
	
	public Main() throws Exception{
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new FileReader("input"));
		
		
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		if (a==b){
			System.out.println(a);
		}else{
			System.out.println(2);
		}
		
        sc.close();
	}
	
	
	
	void printArr(int[] arr){
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	
	
	
	
	
	
	
	
}
