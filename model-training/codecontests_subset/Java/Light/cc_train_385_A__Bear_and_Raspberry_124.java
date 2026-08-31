import java.util.*;
public class CleaverBear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt(),c=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int z=Integer.MIN_VALUE;
		for(int i=0;i<n-1;i++)
		{
			if(z<a[i]-a[i+1]-c)
				z=a[i]-a[i+1]-c;
		}
		if(z<=0)
			System.out.println(0);
		else
			System.out.println(z);
	}

}
