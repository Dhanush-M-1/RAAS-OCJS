//package com.primary.test;
import java.util.Scanner;

public class CF545C
{
	private void run(Scanner in)
	{
		//process input data
		int num = in.nextInt();
		
		int[][] data = new int[num][2];
		
		for(int i = 0 ; i < num; i++)
		{
			for(int j = 0 ; j < 2; j++)
			{
				data[i][j] = in.nextInt();
			}
		}
		
		//greedy algo impl
		int count = 0;
		if(num == 1)
		{
			count = 1;
			System.out.println(count);
			return;
		}
		else if(num == 2)
		{
			count = 2;
			System.out.println(count);
			return;
		}
		else
		{
			count = 2;
		}
		
		for(int i = 1 ; i < num - 1; i++)
		{
			int left = data[i][0] - data[i-1][0];
			int right = data[i+1][0] - data[i][0];
			int length = data[i][1];
			if(left > length)
			{
				count++;
				continue;
			}
			else if(right > length)
			{
				count++;
				data[i][0] += length;
				continue;
			}
			else
			{
				continue;
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		CF545C solution = new CF545C();
		
		solution.run(in);
		
	}
}
