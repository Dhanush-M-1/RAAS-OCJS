import java.util.Scanner;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    String name = input.nextLine();
	    ArrayList<String> integ = new ArrayList<>();
	    ArrayList<String> integ2 = new ArrayList<>();
	    for (String i : name.split("")){
	        if (i.equals("1") || i.equals("2") || i.equals("3")){
	            integ.add(i);
	        }
	    }
	    Collections.sort(integ);
	    String listString = String.join("+", integ); 
	    System.out.println(listString);
	}
}

