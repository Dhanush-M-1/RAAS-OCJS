
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays; 
public class Main{
	static long __gcd(long a, long b)  
    {  
        // Everything divides 0  
        if (a == 0)  
        return b;  
        if (b == 0)  
        return a;  
          
        // base case  
        if (a == b)  
            return a;  
          
        // a is greater  
        if (a > b)  
            return __gcd(a%b, b);  
        return __gcd(a, b%a);  
    } 
      
    // Function to return the LCM of a and b 
    static long lcm(long a, long b) 
    { 
        return (a / __gcd(a, b) * b); 
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		int cases=Integer.valueOf(br.readLine());
//		while(cases!=0)
//		{
//			cases--;
			long c=Long.valueOf(br.readLine());
			long ans =(long) Math.pow(10, 18); 
			String as="";
	        // To find the factors 
	        for (int i = 1; i <= Math.sqrt(c); i++)  
	        {
	            if (c % i == 0 && lcm(i, c / i) == c) 
	            { 
	                if(ans>Math.max(i,c/i))
	            	{
	                	ans =Math.max(i, c / i); 
	                	as=i+" "+(c/i);
	            	}
	            } 
	        } 
	        System.out.println(as);
//		}
	}

}
