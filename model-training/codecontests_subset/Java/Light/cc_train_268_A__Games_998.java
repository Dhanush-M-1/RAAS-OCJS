

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game_With_Sticks {

	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String arr[][]=new String[n][2];
		for(int i=0;i<n;i++)
		arr[i]=br.readLine().trim().split(" ");
		int c=0;
		for(int i=0;i<n;i++)
		{	String a=arr[i][0];
			for(int j=0;j<n;j++)
			{	
				if(i==j)
					continue;
				if(a.equals(arr[j][1]))
					c++;
			}
		}
		System.out.println(c);
		
		
		
		
		
		
	
}

}
