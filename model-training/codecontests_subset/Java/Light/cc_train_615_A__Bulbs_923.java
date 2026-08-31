import java.util.*;
public class Test {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=0,m=0;
		n=sc.nextInt();m=sc.nextInt();
		int arr[]=new int[m];
		
		for(int i=0;i<n;i++)
		{
			int k=sc.nextInt();
			for(int j=0;j<k;j++){
				arr[sc.nextInt()-1]=1;
			}
		}
		int flag=0;
		for(int i=0;i<m;i++){
			if(arr[i]==0) {
				System.out.println("NO");
				flag=1;
				break;
			}
		}
		if(flag==0) System.out.println("YES");
	}

}
