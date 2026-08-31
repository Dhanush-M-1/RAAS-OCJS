import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt(),p=sc.nextInt();
		int count=x;
		while(x>=p){
			count += x/p;
			x=(x/p)+(x%p);
		}
		System.out.println(count);
	}
}