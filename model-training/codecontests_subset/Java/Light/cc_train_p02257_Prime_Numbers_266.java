import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Set<BigInteger> set=new HashSet<BigInteger>();
		int c=0;
		int n=scan.nextInt();
		for(int i=1;i<=n;i++)
		{	
			set.add(scan.nextBigInteger());
		}
		
		ArrayList<BigInteger> bi=new ArrayList<BigInteger>(set);
		
		
		int m=set.size();
		for(int i=0;i<m;i++)
		{
			if(bi.get(i).isProbablePrime(10)==true)
			{
				c++;
			}
		}
		System.out.println(c);
		bi.clear();
		set.clear();

	}

}