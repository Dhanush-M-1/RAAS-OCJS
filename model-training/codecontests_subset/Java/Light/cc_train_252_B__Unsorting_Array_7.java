import java.util.*;
import java.io.*;
public class UnsortingArray
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] array = new int[n];
		for(int x = 0; x < n; x++)
		{
			array[x] = in.nextInt();
		}
		
		if(array.length < 3)
		{
			System.out.println("-1");
		}
		else if(array.length == 3 && array[0] == array[2])
		{
			System.out.println("-1");
		}
		else if(sameNum(array))
		{
			System.out.println("-1");
		}
		else
		{
			for(int y = 0; y < array.length; y++)
			{
				for(int z = y + 1; z < array.length; z++)
				{
					if(array[y] != array[z])
					{
						swap(array, y, z);
						
						if(!sorted(array))
						{
							System.out.println((y + 1) + " " + (z + 1));
							return;
						}
						
						swap(array, y, z);
					}
				}
			}
		}
	}
	
	public static boolean sameNum(int[] array)
	{
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] != array[i - 1])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static boolean sorted(int[] array)
	{
		int i;
		for(i = 1; i < array.length; i++)
		{
			if(array[i] < array[i - 1])
			{
				break;
			}
		}
		
		int j;
		for(j = 1; j < array.length; j++)
		{
			if(array[j] > array[j - 1])
			{
				break;
			}
		}
		
		return (i == array.length || j == array.length);
	}
}
