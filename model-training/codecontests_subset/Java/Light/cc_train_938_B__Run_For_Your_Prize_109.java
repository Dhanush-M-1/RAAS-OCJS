import java.util.Scanner;

public class prizes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int x = 1; int y = 1000000;
		int max=1;
		for(int i = 0; i<n;i++){
			a[i] = in.nextInt();
			if(a[i]>500000){
				if(y-a[i]>max)max = y-a[i];
			}else{
				if(a[i]-x>max)max = a[i]-x;
			}
		}
		System.out.println(max);
	}

}
