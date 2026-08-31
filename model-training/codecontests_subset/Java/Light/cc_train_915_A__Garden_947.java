import java.util.*;
public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,k;
		n = sc.nextInt();
		k = sc.nextInt();
		
		int a[] = new int[n];
		int max = 0;
		for(int i = 0 ; i<a.length; i++)
		{
			a[i] = sc.nextInt();
			if((a[i]>max)&&(k%a[i] == 0))
				max=a[i];
		}
		
		System.out.println(k/max);

	}

}
