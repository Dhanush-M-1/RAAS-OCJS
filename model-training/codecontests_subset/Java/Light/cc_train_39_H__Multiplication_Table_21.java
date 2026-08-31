import java.util.Scanner;

public class H39 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for (int i=1;i<k;i++) { System.out.print(i+"  "); } System.out.println();
		for (int i=2;i<k;i++) {
			System.out.print(i+" ");
			for(int j=2;j<k;j++) {
				int z = i*j;
				int q = 0;
				if (z>=k) {
					for (int w=1;z>0;w++) {
						q = q*10;
						q += (z%k);
						z = z/k;
					} q = (q%10)*10+q/10;
				} else q=z;
				if (q<10) { System.out.print(" "+q+" "); } else { System.out.print(q+" ");}
			}
			System.out.println();
		}
	}

}
