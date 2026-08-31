import java.util.Arrays;
import java.util.Scanner;


public class errors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a,i,p=0,save=0;
		a=sc.nextInt();
		int e1[]=new int[a];
		int e2[]=new int[a-1];
		int e3[]=new int[a-2];
		int ee1[]=new int[a];
		int ee2[]=new int[a];
		int ee3[]=new int[a];
		for(i=0;i<a;i++)
		{
			e1[i]=sc.nextInt();
		}
		for(i=0;i<a-1;i++)
		{
			e2[i]=sc.nextInt();
		}
		for(i=0;i<a-2;i++)
		{
			e3[i]=sc.nextInt();
		}
		Arrays.sort(e1);
		Arrays.sort(e2);
		Arrays.sort(e3);
		for(i=0;i<a;i++)
		{
			ee1[i]=e1[i];
		}
		for(i=0;i<a-1;i++)
		{
			ee2[i]=e2[i];
		}
		for(i=0;i<a-2;i++)
		{
			ee3[i]=e3[i];
		}
		for(i=0;i<a;i++)
		{
			if(ee1[i]!=ee2[i])
				{
				System.out.print(e1[i]+"\n");
				save=i;
				break;
				}
		}
		for(i=0;i<a;i++)
		{
			if(ee2[i]!=ee3[i])
				{
				System.out.print(e2[i]+"\n");
				break;
				}
		}

	}

}
