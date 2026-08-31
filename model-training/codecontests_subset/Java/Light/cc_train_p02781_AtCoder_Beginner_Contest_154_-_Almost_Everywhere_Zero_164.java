import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int k = sc.nextInt();
		
		//asume k = 3
		int d = s.length();
		boolean[] restiszero = new boolean[d];
		boolean[] hasNonZeroToTheLeft = new boolean[d];
		int fir = s.charAt(0)-'0';
		int rest = d-1;
		
		for(int i = s.length()-1; i >= 0; i--)
		{
			if(s.charAt(i) == '0')
			{
				restiszero[i] = true;
			}
			else break;
		}
		boolean foundz = false;
		for(int i = 1; i < s.length(); i++)
		{
			hasNonZeroToTheLeft[i] = foundz;
			if(s.charAt(i) != '0')
				foundz = true;
		}
		
		long an = 0;
		if(k==3)
		{
			if(d<3)
			{
				System.out.println(0);
				return;
			}
			
			//same digit cases
			
			//first digit lesser
			if(d>=3)
				an += (((d-1)*(d-2))/2) * (fir-1) * 9 * 9;
			if(an<0)System.out.println("ERROR");
//			System.out.println("test " + an);
			
			//first digit is same
			for(int pos1 = 1; pos1 < s.length(); pos1++)
			{
				boolean pos2foundz = false;
				for(int pos2 = pos1+1; pos2 < s.length(); pos2++)
				{
					if(hasNonZeroToTheLeft[pos1])
						an += 9*9;
					else
					{
						int d1 = s.charAt(pos1)-'0';
						int d2 = s.charAt(pos2)-'0';
						int num = (d1-1)*9 + d2;
						if(d2==0)num=0;
						if(pos2foundz)num = d1 * 9;
						if(d1==0)num=0;
						if(num<0)System.out.println("ERROR");
//						if(num>0)System.out.println(pos1 + " " + pos2 + ": " + num);
						an+=num;
					}
					if(s.charAt(pos2) != '0')pos2foundz = true;
				}
			}
//			System.out.println("test " + an);
			//less digit cases
			long les = 0;
			for(int dig = k; dig < d; dig++)
			{
				//k=3
				les = (((dig-1)*(dig-2))/2) * 9 * 9 * 9;
				if(les<0)System.out.println("ERROR");
				an += les;
//				System.out.println(les);
			}
		}
		else if(k==2)
		{
			if(d<2)
			{
				System.out.println(0);
				return;
			}
			
			//same digit cases
			
			//first digit lesser
			if(d>=2)
				an += (d-1) * (fir-1) * 9;
			
			//first digit is same
			for(int pos1 = 1; pos1 < s.length(); pos1++)
			{
				int d1 = s.charAt(pos1)-'0';
				if(hasNonZeroToTheLeft[pos1])
				{
					an += 9;
				}
				else an += d1;
			}

			
			//less digit cases
			long les = 0;
			for(int dig = k; dig < d; dig++)
			{
				//k=2
				les = (dig-1) * 9 * 9;
				an += les;
			}
		}
		else if(k==1)
		{
			an = 9 * (d-1);
			an += fir;
		}
		System.out.println(an);
	}

}
