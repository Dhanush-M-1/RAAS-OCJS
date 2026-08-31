
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		
		int ans = selectionSort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			if(i==arr.length-1)
			{
				System.out.print(arr[i]);
			}
			else
			{
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		
		System.out.println(ans);
		
	}
	
	
	public static int selectionSort(int[] arr)
	{
		
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			int min = i;
			//找到最小的那个
			for(int j=i;j<arr.length;j++)
			{
				if(arr[j]<arr[min])
				{
					min = j;
				}
			}
			
			//换  把最小的放到现在这个位置
			int temp = arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
			if(i!=min)
			{
				count++;
			}

		}
		
		return count;
	}
}

