	
	import java.util.Scanner;
	
	public class CF_385AA {
	
		public static void main(String[] args) {
			new CF_385AA().run();
		}
		public void run(){
			Scanner sc  = new Scanner(System.in);
			int n = sc.nextInt();
			int k = sc.nextInt();
			int max = 0;
			int temp = sc.nextInt();
			int a[] = new int[n];
			for(int i = 1; i<n;i++){
				a[i] = sc.nextInt();
				max = Math.max(max, (temp-a[i]));
				//System.out.println(max);
				temp = a[i];
			}
			if(max -k <= 0)
				System.out.println(0);
			else
			System.out.println(max -k);
		}
	}
