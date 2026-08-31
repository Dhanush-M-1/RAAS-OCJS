import java.io.*;
import java.lang.*;
import java.util.*;
public class PairProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			int k = s.nextInt();
			int n = s.nextInt();
			int m = s.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			for(int i = 0 ; i < n ; i++)
				a[i] = s.nextInt();
			for(int i = 0 ; i < m ; i++)
				b[i] = s.nextInt();
			int i = 0;
			int j = 0;
			boolean flag = true;
			ArrayList<Integer> ans = new ArrayList<>();
			while(i < n && j < m) {
				int x = a[i];
				int y = b[j];
				if(x < y) {
					if(x > k) {
						flag = false;
						break;
					}
					if(x == 0)
						k++;
					ans.add(x);
					i++;
				}
				else {
					if(y > k)
					{
						flag = false;
						break;
					}
					if (y == 0)
						k++;
					ans.add(y);
					j++;
				}
			}
			while(i < n)
			{
				int x = a[i];
				if(x > k)
				{
					flag = false;
					break;
				}
				if(x == 0)
					k++;
				ans.add(a[i]);
				i++;
			}
			while(j < m) {
				int x = b[j];
				if(x > k)
				{
					flag = false;
					break;
				}
				if(x == 0)
					k++;
				ans.add(b[j]);
				j++;
			}
			if(flag == false)
				System.out.println(-1);
			else {
				for(int mm = 0 ; mm < ans.size() ; mm++)
					System.out.print(ans.get(mm)+" ");
				System.out.println();
			}
			
		}
	}

}
