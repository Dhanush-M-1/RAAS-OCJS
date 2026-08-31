import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int array[] = new int[5];
		
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			array[i] = sc.nextInt();
			sum += array[i];
		}
		if(sum == 0){
			System.out.println("-1");
		}
		else if(sum % 5 == 0){
			int init = sum / 5;
			System.out.println(init);
		}
		else
			System.out.println("-1");
		sc.close();
	}
	
}