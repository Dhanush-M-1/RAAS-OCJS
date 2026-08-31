import java.util.*;
public class Bulbs
{
		public static void main(String args[])
		{
				Scanner sc = new Scanner(System.in);
				int s = sc.nextInt();
				int b = sc.nextInt();
				boolean flag = true;
				int arr[] = new int[b];
				while(s-->0)
				{
						int i = sc.nextInt();
						while(i-->0)
						{
									int a = sc.nextInt();
									arr[a-1]++;
						}
				}
				for(int j = 0; j<b; j++)
				{
						if(arr[j]==0)
						{
								flag = false;
								break;
						}
				}
				if(flag) System.out.println("YES");
				else System.out.println("NO");
		}
}
