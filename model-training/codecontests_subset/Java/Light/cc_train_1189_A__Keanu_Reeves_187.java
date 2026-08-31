import java.util.*;
public class KeanuReeves {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String str  = s.next();
		int sum=0;
		int res=0;
		for(int i=0;i<n;i++) {
			if(str.charAt(i)=='1') {
				sum++;
			}
			if(str.charAt(i)=='0') {
				res++;
			}
		}
       if(sum==res) {
    	   System.out.println(2);
    	   for(int i=0;i<n-1;i++) {
    		   System.out.print(str.charAt(i));
    	   }
    	   System.out.print(" "+str.charAt(n-1));
       }
       else {
    	   System.out.println(1);
    	   System.out.println(str);
       }
	}

}
