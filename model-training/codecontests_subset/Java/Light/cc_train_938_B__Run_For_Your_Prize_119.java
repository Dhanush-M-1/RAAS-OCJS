import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int m = 1 , f = 1000000 , n = in.nextInt();
		int [] p = new int[n], min = new int[n];
		for(int i=0;i<n;i++){
			p[i]=in.nextInt();
			min[i] = Math.min(p[i] - m, f - p[i]);
		}
		Arrays.sort(min);
		System.out.println(min[min.length-1]);
    }
}