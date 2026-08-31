import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class Again{
	public static void main(String[] args){
		Scanner kbd = new Scanner(System.in);
		Long a = kbd.nextLong();  
		if (a >= 14){
			System.out.println("25");
		}else{
			System.out.println((int)Math.pow(5,a)%100);
		}
	}
}