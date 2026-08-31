import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String args[]) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int n=Integer.parseInt(br.readLine());
	int ans=0;
	
	for(int i=0;i<n;i++){
	    int a=Integer.parseInt(br.readLine());
	    if(isPrime(a)){
		ans++;
	    }
	}
	System.out.println(ans);

	
    }
    static boolean isPrime(int n){

	if(n==1)
	    return true;
	
	
	for (int i = 2; i * i <= n; i++) {
	    if(n % i == 0)
		return false;
	}
	return true;
    }
}

