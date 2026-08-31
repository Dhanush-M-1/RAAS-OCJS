/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> even = new ArrayList<Integer>();
		ArrayList<Integer> odd = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < n; ++i){
			int tmp;
			tmp = in.nextInt();
			if (tmp % 2 == 0){
				even.add(tmp);
			}
			else{
				odd.add(tmp);
			}
			sum += tmp;
		}
		Collections.sort(even);
		Collections.sort(odd);
		if (even.size() == 0){
			System.out.println(sum - odd.get(odd.size() - 1));
			System.exit(0);
		}
		else if (odd.size() == 0){
			System.out.println(sum - even.get(even.size() - 1));
			System.exit(0);
		}
		boolean start = false;
		if (even.size() < odd.size()) start = true;
		while (true){
			//System.out.print(cte);
			//System.out.println(cto);
			if (start){
				if (odd.size() == 0) break;
				odd.remove(odd.size() - 1);
				start = false;
			}
			else {
				if (even.size() == 0) break;
				even.remove(even.size() - 1);
				start = true;
			}
		}
		int ans = 0;
		for (int i = 0; i < even.size(); ++i){
			ans += even.get(i);
		}
		for (int i = 0; i < odd.size(); ++i){
			ans += odd.get(i);
		}
		System.out.println(ans);
	}
}