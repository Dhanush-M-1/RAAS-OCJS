import java.util.*;
public class Hello {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long [] hash = new long[2000007];
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
        	arr[i]=in.nextInt();
        	hash[arr[i]]=1;
        }
        for(int i=2; i<=2000000; i++){
        	hash[i]+=hash[i-1];
        }
        long c=0;
        for(int i=0; i<n; i++){
        	if(hash[arr[i]+k]-hash[arr[i]]>0){
        		c++;
        	}
        }
        System.out.println(n-c);
    }
}