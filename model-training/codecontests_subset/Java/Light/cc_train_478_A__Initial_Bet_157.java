import java.util.*;

public class solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] t=new int[5];
		int sum=0;
		for(int i=0;i<5;i++) {
			t[i]=sc.nextInt();
			sum+=t[i];
		}
		if(sum%5==0 && sum!=0) {
			System.out.println(sum/5);
		}
		else {
			System.out.println(-1);
		}
	}
}