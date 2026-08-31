
/*	Basic import definitions	*/
	import java.util.*;

/*	Basic Class definitions*/
	public class A339
	{
		public static void main(String[] args) 
		{
			Scanner sc = new Scanner(System.in);

			int i , j , k;
			int T,N;

			String s = sc.next();
                        int l = s.length();
                        int a[] = new int[l/2+1];

			for ( i=0 , j=0 ; i<l ; i++ ) 
			{
                            if(s.charAt(i) != '+')
                            {
                                a[j] = s.charAt(i)-48;
                                j++;
                            }
			}
                        Arrays.sort(a);
                        for(i=0;i<a.length-1;i++)
                        {
                            System.out.print(a[i]+"+");
                        }
                        System.out.println(a[a.length-1]);
		}
	}