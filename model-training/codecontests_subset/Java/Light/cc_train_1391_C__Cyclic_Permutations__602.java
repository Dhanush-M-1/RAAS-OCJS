import java.util.*;
import java.io.*;

public class Solution{

	static final long mod = (int)1e9+7;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long fact = 1;
		for(int i=1;i<=n;i++){
			fact = (fact*i)%mod;
		}

		long twoPower = 1;
		for(int i=0;i<n-1;i++){
			twoPower = (twoPower*2)%mod;
		}

		System.out.println((fact-twoPower+mod)%mod);
		


	}

	

	

		
	
}