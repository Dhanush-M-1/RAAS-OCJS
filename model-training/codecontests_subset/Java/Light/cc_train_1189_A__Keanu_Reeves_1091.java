import java.util.Scanner;
import java.util.Arrays;
public class cf2{
	
	public static void main(String[] args)
	{
		Scanner o=new Scanner(System.in);
		int n,a,b,c,d,i,j,m;
		
		
		
		//nt ar[]=new int[m];
	
	
			String s;
		
			n=o.nextInt();
			s=o.next();
			char atashi[]=s.toCharArray();
			//Arrasys.sort(atashi);
			c=0;
			for(char t:atashi)
			{
				if(t=='1')
					c++;
			}
			if(n%2==0&&c!=n/2||n%2!=0)
				System.out.println(1+"\n"+s);
			else
			{System.out.println(2);
					for(j=0;j<n-1;j++)
			           System.out.print(s.charAt(j));
                      System.out.println(" "+s.charAt(n-1));				   
			
				
			}
			
			
		}
		//System.out.println(ar[i]);
		
	
		}
		//System.out.println(min);
	
