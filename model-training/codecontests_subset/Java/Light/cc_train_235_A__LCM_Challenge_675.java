import java.util.*;
public class Lcm{
	public static long lcm(long a, long b){
		long t = a,s = b;
    	while (b > 0){
        	long temp = b;
        	b = a % b; // % is remainder
        	a = temp;
    	}
    	return t * (s / a);
	}
	public static void main(String[] args){
		Scanner al = new Scanner(System.in);
		long inp = al.nextLong();
		if(inp < 3){
			System.out.println(inp);
		} else{
			if(inp % 2 == 1){
				System.out.println(inp*(inp-1)*(inp-2));
			}else{
				long s = lcm(lcm(inp,inp-1),inp-3);
				long t = (inp-1)*(inp-2)*(inp-3);
				System.out.println(Math.max(s,t));
			}
		}
	}
}