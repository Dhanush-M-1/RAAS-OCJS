import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		while(t>0){
		    int n = sc.nextInt();
		    long l[] = new long[n];
		    long r[] = new long[n];
		    for(int i=0;i<n;i++){
		        l[i] = sc.nextLong();
		        r[i] = sc.nextLong();
		    }
		    Arrays.sort(l);
		    Arrays.sort(r);
		    long ans = l[n-1] - r[0];
		    System.out.println(Math.max(0,ans));    
		    
		    
            
            t--;
		}
	}
}