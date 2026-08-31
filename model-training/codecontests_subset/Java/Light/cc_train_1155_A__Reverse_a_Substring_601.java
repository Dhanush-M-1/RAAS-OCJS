import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		boolean chk = false;
		for(int i=1;i<n;++i){
		    if(s.charAt(i) < s.charAt(i-1)){
    		    System.out.println("YES");
    		    System.out.println(i+" "+(i+1));
			    chk = true;
			    break;
		    }
		}
	    if(!chk){
	        System.out.println("NO");    
	    }
	}
}
