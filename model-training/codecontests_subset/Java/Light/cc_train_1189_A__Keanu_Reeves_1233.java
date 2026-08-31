import java.util.*;

public class Main {
	public static void main (String[] args){
	    Scanner scan = new Scanner(System.in);
		    int n = scan.nextInt();
		    String str = scan.next();
		    int one = 0;
		    int zero = 0;
		    for(int i=0;i<n;i++){
		        if(str.charAt(i)=='1'){
		            one++;
		        }else{
		            zero++;
		        }
		    }
		    if(one!=zero){
		        System.out.println(1);
		        System.out.println(str);
		    }else{
		        System.out.println(2);
		        System.out.println(str.substring(0,str.length()-1) + " " + str.substring(str.length()-1));
		    }
	}
}