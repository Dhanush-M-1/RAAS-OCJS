import java.util.*;

public class main {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int robots,k;
		robots=sc.nextInt();
		k=sc.nextInt();
		int[] id=new int[robots];
		for(int j=0;j<robots;j++)
		{
			id[j]=sc.nextInt();
		}
		int sum=0,psum=0,i=1;
		while(sum<k)
		{
			 psum=sum;
			sum+=i;
			i++;
		}
		System.out.println(id[k-psum-1]);
	}

}
