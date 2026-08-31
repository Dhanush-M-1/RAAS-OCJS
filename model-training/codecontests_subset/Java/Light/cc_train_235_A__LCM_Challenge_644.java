import java.util.*;
import java.io.*;
public class Main
{
    public static long gcd(long a , long b){
        if(b == 0){
            return a;
        }
        return gcd(b , a%b);
    }
    public static long lcm(long n){
        if(n <=2){
       	    return n;
       	}
       	else if(n == 3){
       	    return 6;
       	}
       	long prod = n*(n-1);
       	long max =n-2;
       	for(long i=n-2;i>=2;i--){
       	    if(gcd(prod , i) == 1){
       	        max = i;
       	        break;
       	    }
       	}
       	return ((prod*max)/gcd(prod , max));   
      
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
       	System.out.println(Math.max(lcm(n) , lcm(n-1)));
	}
}
