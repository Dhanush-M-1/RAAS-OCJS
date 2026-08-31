import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while((t--)>0){
		    int a[] = new int[3];
		    a[0] = sc.nextInt();
		    a[1] = sc.nextInt();
		    int n = sc.nextInt();
		    a[2] = myXOR(a[0],a[1]);
		    System.out.println(a[n%3]);
		}
	}
	
	static int myXOR(int x,int y){
	    return (x|y)&(~x|~y);
	}
}