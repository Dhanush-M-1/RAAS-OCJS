
import java.util.* ;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in) ;
		int n=s.nextInt();
		int arr[]=new int[n] ;
		int sum=0 ;
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
			sum=sum+arr[i] ;
		}
		int votes=2*sum+1 ;
		int ans=votes/n ;
		if(votes%n!=0)
		{
			ans++ ;
		}
		for(int i=0;i<arr.length;i++)
		{
			if(ans<arr[i])
			{
				ans=arr[i] ;
			}
		}
		System.out.println(ans);
	}

}
