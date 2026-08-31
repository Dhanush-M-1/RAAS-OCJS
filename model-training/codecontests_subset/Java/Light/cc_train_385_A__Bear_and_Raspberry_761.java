import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = input.nextInt(),y = input.nextInt(),a=0,b=1,mx=0,k=0,j=0;
		int ans=0;
		int []arr = new int[x];
		for(int i=0;i<x;i++)
		{
			arr[i]= input.nextInt();
		}
		input.close();
		//mx=arr[0]-arr[1];
		while(b<=x-1)
		{
			if(arr[a]-arr[b]>mx&&arr[a]-arr[b]-y>=0)
			{
				j=a;
				k=b;
				mx=arr[a]-arr[b];
				 ans = arr[a]-arr[b]-y;
			}
			a++;
			b++;
		}
		System.out.printf("%d", ans );
	}

}
