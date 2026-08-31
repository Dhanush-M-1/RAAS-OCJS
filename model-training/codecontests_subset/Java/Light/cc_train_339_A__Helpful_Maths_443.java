
import java.util.*;
public class seven {
    public static int[] fillar(String s){
    	int [] a=new int[(s.length()/2)+1];
    	int cnt=0;
    	for(int i=0; i<s.length(); i+=2){
    		a[cnt]= s.charAt(i)-'0';
    		cnt++;
    	}
    	return a;
    }
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s=new String(input.next());
		int[] a;
		a=fillar(s);
		Arrays.sort(a);
		
		for(int i=0; i<a.length-1; i++)
			System.out.print(a[i]+"+");
		
		System.out.println(a[a.length-1]);
		

	}

}
