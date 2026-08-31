
import java.util.Scanner;

public class Rebus {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		StringBuffer exp = new StringBuffer(sc.nextLine());
		
		int p=0,m=0;
		for(int i=0;i<exp.length();i++)
		{
			if(exp.charAt(i)=='+')
				p++;
			else if(exp.charAt(i)=='-')
				m++;
		}
		p++;
		int index = exp.indexOf("=");
		int sum = Integer.parseInt(exp.substring(index+2));
		
		if((p*sum)-m < sum)
		{
			System.out.println("Impossible");
		}
		else if(p==1 && m==0) // ? = 10
		{
			System.out.println("Possible");
			System.out.println(sum+" = "+sum);
		}
		else if(p==m) // ? + ? - ? - ? = 10
		{
			int a[] = new int[p+m];
			int ap=0;
			//sum = sum - (m*1); // initialize -? with 1
			int c = p;
			
			for(int i=1;i<=c-2;i++)
			{
				
				a[ap] = 1;
				ap++;
			}
			a[ap++] = 2;
			
			a[ap] = sum;
			
			//////////////
			StringBuffer res = new StringBuffer("");
			ap=0;
			res.append(a[ap++]);
			char op = '/';
			for(int i=1;i<exp.length();i++)
			{
				if(exp.charAt(i)=='?' && op=='+')
					res.append(" + "+a[ap++]);
				else if(exp.charAt(i)=='?' && op=='-')
					res.append(" - 1");
				
				if(exp.charAt(i)=='+')
					op='+';
				else if(exp.charAt(i)=='-')
					op='-';
			}
			System.out.println("Possible");
			System.out.println(res+" = "+sum);
			///////////////
		}
		else if(m > p)
		{
			int a[] = new int[p+m];
			int ap=0;
			
			int c = p;
			int val = m/(c-1);
			int valRem = m%(c-1);
			for(int i=1;i<=c-1;i++) //c-2
			{
				if(valRem > 0){
					a[ap++] = val+1;
					valRem--;
				}
				else
					a[ap++] = val;
			}
			//a[ap++] = m-(c-2);
			
			a[ap] = sum;
			
			//////////////
			StringBuffer res = new StringBuffer("");
			ap=0;
			res.append(a[ap++]);
			char op = '/';
			for(int i=1;i<exp.length();i++)
			{
				if(exp.charAt(i)=='?' && op=='+')
					res.append(" + "+a[ap++]);
				else if(exp.charAt(i)=='?' && op=='-')
					res.append(" - 1");
				
				if(exp.charAt(i)=='+')
					op='+';
				else if(exp.charAt(i)=='-')
					op='-';
			}
			System.out.println("Possible");
			System.out.println(res+" = "+sum);
		}
		else // ? + ? + ? - ? - ? = 10
		{
			int a[] = new int[p+m];
			int ap=0;
			
			int c = p-m;
			if(p-(m*sum) > sum)
			{
				System.out.println("Impossible");
				System.exit(0);
			}
			
			if(c >= sum && m!=0) // 80? - 19? = 4
			{
				int val = (p-sum)/m;
				int valRem = (p-sum)%m;
				for(int i=1;i<=m;i++)
				{
					if(valRem > 0)
					{
						a[ap++] = val+1;
						valRem--;
					}
					else
						a[ap++] = val;
				}
				
				////////////////
					StringBuffer res = new StringBuffer("");
					ap=0;
					res.append("1");
					char op = '/';
					for(int i=1;i<exp.length();i++)
					{
						if(exp.charAt(i)=='?' && op=='+')
						{
							res.append(" + 1");
							
						}
						else if(exp.charAt(i)=='?' && op=='-')
						{
							if(a[ap]==0){
								res.append(" - 1");
								ap++;
							}
							else
								res.append(" - "+a[ap++]);
						}
						
						if(exp.charAt(i)=='+')
							op='+';
						else if(exp.charAt(i)=='-')
							op='-';
					}
					System.out.println("Possible");
					System.out.println(res+" = "+sum);
					/////////////
			}
			else
			{
				for(int i=1;i<=c-1;i++)
				{
					a[ap] = 1;
					ap++;
				}
				a[ap] = sum - (c-1);
				////////////////
				StringBuffer res = new StringBuffer("");
				ap=0;
				res.append(a[ap++]);
				char op = '/';
				for(int i=1;i<exp.length();i++)
				{
					if(exp.charAt(i)=='?' && op=='+')
					{
						if(a[ap]==0){
							res.append(" + 1");
							ap++;
						}
						else
							res.append(" + "+a[ap++]);
					}
						
					else if(exp.charAt(i)=='?' && op=='-')
						res.append(" - 1");
					
					if(exp.charAt(i)=='+')
						op='+';
					else if(exp.charAt(i)=='-')
						op='-';
				}
				System.out.println("Possible");
				System.out.println(res+" = "+sum);
				/////////////
			}
			
			
			
		}
		
	}

}
