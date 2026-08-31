import java.util.*;
import java.io.*;

public class Woodcutters {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num=input.nextInt();
		int arr[][]=new int[num][2];
		int ans=1;
		for(int i=0;i<num;i++)
		{
			arr[i][0]=input.nextInt();
			arr[i][1]=input.nextInt();
		}
		
		int position=arr[0][0];
		for(int i=1;i<num;i++)
		{
			if(i==num-1) ans++;
			else if(arr[i][0]-arr[i][1]>position)
			{
				position=arr[i][0];
				ans++;
			}
			else if(arr[i][0]+arr[i][1]<arr[i+1][0])
			{
				position=arr[i][0]+arr[i][1];
					ans++;
			}
			else position=arr[i][0];
		}
		System.out.println(ans);
	}
}
