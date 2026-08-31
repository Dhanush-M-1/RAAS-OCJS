import java.util.*;

public class Main
{
	public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);
	 int buttons = scan.nextInt();
	 int bulbs = scan.nextInt();
	 scan.nextLine();
	 
	 Boolean [] size = new Boolean [bulbs];
	 
	 Arrays.fill(size, false);
	 
	 for(int i = 0; i < buttons; i++){
	     String [] bean = scan.nextLine().split(" ");
	     for(int j = 1; j < bean.length; j++){
	         int num = Integer.parseInt(bean[j]);
	         size[num-1] = true;
	     }
	     
	 }
	
	    boolean wee = true;
	    for(int i = 0; i < bulbs; i++){
	        if (size[i]== false){
	            wee = false;
	        }
	    }
	    if (wee== true){
	        System.out.println("YES");
	    }else{
	        System.out.println("NO");
	    }
	}
}