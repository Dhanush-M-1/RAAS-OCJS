import java.util.*;

public class CF_658_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T>0)
		{
			int n = s.nextInt();
			int m = s.nextInt();
			
			int arr1[] = new int[n];
			HashSet<Integer> hset = new HashSet<>();
			for(int i = 0;i<arr1.length;++i)
			{
				arr1[i] = s.nextInt();
				hset.add(arr1[i]);
			}
//			System.out.println(hset);
			int f = -1;
			int arr2[] = new int[m];
			for(int i = 0;i<arr2.length;++i)
			{
				arr2[i] = s.nextInt();
//				System.out.print(arr2[i] + " ");
				if(hset.contains(arr2[i]))
				{
//					System.out.print("hello");
					f = i;
				}
			}
			if(f == -1)
				System.out.println("NO");
			else
			{
				System.out.println("YES");
				System.out.println(1 + " " + arr2[f]);
			}
			T--;
		}
	}

}
