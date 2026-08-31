import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class semianr8 {

	public static void main(String [] args){
		 Scanner scan = new Scanner(System.in);
	        String input = scan.nextLine();

	        String inputAsArray[] = input.split("\\+");
	        int inputAsIntArray[] = new int[inputAsArray.length];

	        for (int i = 0; i < inputAsArray.length; i++) {
	            inputAsIntArray[i] = Integer.parseInt(inputAsArray[i]);
	        }

	        Arrays.sort(inputAsIntArray);

	        for (int i = 0; i < inputAsIntArray.length - 1; i++) {
	            System.out.print(inputAsIntArray[i] + "+");
	        }
	        System.out.print(inputAsIntArray[inputAsIntArray.length - 1]);
	    }
	}

