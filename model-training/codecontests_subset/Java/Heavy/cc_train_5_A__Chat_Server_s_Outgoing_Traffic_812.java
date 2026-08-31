import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;

import javax.jws.WebParam.Mode;

public class Main{
   
	public static void main(String[] args) {
        	Scanner sc = new Scanner(new BufferedInputStream(System.in));
        	String string;
        	int sum = 0;
        	HashSet hs = new HashSet<String>();
        	while(sc.hasNextLine()) {
        		string = sc.nextLine();
        		if(string.isEmpty()) break;
        		if(string.charAt(0) == '+') {
        			hs.add(string.substring(1,string.length()));        		
        		}
        		else if(string.charAt(0) == '-') {
        			hs.remove(string.substring(1,string.length()));
        		}
        		else {
        			String[] str = string.split( ":");
        			if(str.length != 1)
        				sum += hs.size() * str[1].length();
        		}
        	}
        	System.out.println(sum);
    }
}
  		 		 	  		   	 										  	