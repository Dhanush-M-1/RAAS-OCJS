import java.util.*;
public class d{
	public static int n;
	public static int[] a;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = new int[n];
		for(int i = 0;i<n;i++)
			a[i] = scan.nextInt();
		scan.close();
		for(int i = 0;;i++)
			if(works(i)){
				System.out.println(i);
				return;
			}
	}
	public static boolean works(int k){
		int you = 0;
		int other = 0;
		for(int i = 0;i<n;i++)
			other += a[i];
		for(int i = 0;i<n;i++){
			you += (k-a[i]);
			if(k < a[i])
				return false;
		}
		return you > other;
	}
}
