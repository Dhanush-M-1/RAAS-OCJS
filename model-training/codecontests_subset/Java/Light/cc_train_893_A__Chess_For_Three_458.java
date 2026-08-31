/*	Basic import definitions	*/
	import java.util.*;

/*	Basic Class definitions*/
	public class A893
	{
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in);

			int i , j , k;
			int T,n;
                        int t=0;

			n = sc.nextInt();
                        
                        int a,b,c;
                        a=1;
                        b=2;
                        c=3;
                        
			for ( i = 0 ; i < n ; i++ ) 
			{
                            k = sc.nextInt();
                            if(k==c)
                            {
                                System.out.println("NO");
                                return;
                            }
                            
                            if(k==a)
                            {
                                t=b;
                                b=c;
                                c=t;
                            }
                            else
                            {
                                t=a;
                                a=b;
                                b=c;
                                c=t;
                            }
			}
                        System.out.println("YES");
		}
	}