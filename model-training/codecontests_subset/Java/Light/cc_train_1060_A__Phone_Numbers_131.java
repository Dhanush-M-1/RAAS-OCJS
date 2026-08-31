import java.util.Scanner;

public class phonenumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String line = in.next();
		int[] arr = new int[n];
		int eight = 0;
		for (int i=0;i<n; i++) {
			arr[i]=Integer.parseInt(line.substring(i,i+1));
			if(arr[i]==8) eight++;
		}
		int count=0;
		while(eight-->0 && n>=11) {
			n-=11;
			count++;
		}
		System.out.println(count);
	}
}