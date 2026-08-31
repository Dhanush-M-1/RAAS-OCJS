import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BarkUnlock {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		String pswrd = scanner.nextLine();
	    Integer numbersTry = Integer.parseInt(scanner.nextLine());

	    String[] input = new String[numbersTry];
	    for(int i=0; i<numbersTry; i++){
	    	String value = scanner.nextLine();

	    	if(pswrd.contains(value.substring(0,1)) || pswrd.contains(value.substring(1,1))) input[i] = value;
	    }

	    Boolean isFound = false;

	    for(int i=0; i<numbersTry;i++){
	    	for(int j=0; j<numbersTry;j++){
	    		String text = input[i].substring(0,1) + input[i].substring(1,2) + input[j].substring(0,1) + input[j].substring(1,2); 
	    		if(text.indexOf(pswrd) != -1) isFound = true;
	
	    		text = input[j].substring(0,1) + input[j].substring(1,2) + input[i].substring(0,1) + input[i].substring(1,2); 
	    		if(text.indexOf(pswrd) != -1) isFound = true;

	    		if(isFound) break;
	    	}
	    }

	    System.out.println((isFound)? "YES" : "NO");
	}
}