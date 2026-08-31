//package CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class WoodCutters {
	
	static class node{
		int x;
		int y;
		node(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		ArrayList<node> arr=new ArrayList<node>();
		for(int i=0;i<n;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			node newnode=new node(a,b);
			arr.add(newnode);
		}
		int count=Math.min(2,n);
		for(int i=1;i<n-1;i++)
		{
			if(arr.get(i-1).x<arr.get(i).x-arr.get(i).y)
			{
				count++;
			}
			else if(arr.get(i).x+arr.get(i).y<arr.get(i+1).x)
			{
				arr.get(i).x=arr.get(i).x+arr.get(i).y;
				count++;
			}
		}
		
		System.out.println(count);

	}

}
