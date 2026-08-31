import java.util.*;
 public class remainder {
		public static void main(String args[]) {
			Scanner sc= new Scanner(System.in);
			
			int n=sc.nextInt(),cnt=0;
			long x=sc.nextInt();
			long y=sc.nextInt();
			String array1[]=new String[200000];
			String array2[]=new String[200000];
			
				array1=sc.next().split(""); 
			
			for(int i=0;i<n;i++)
			{
				array2[i]="0";
			}
			
			array2[(int) (n-y-1)]="1";
			for(int i=(int) (n-x);i<n;i++)
			{
				if(!array1[i].equals(array2[i]))
//					System.out.println(str1[i]+" "+str2[i]);
					cnt++;
			}
			System.out.println(cnt);


		} 
}
