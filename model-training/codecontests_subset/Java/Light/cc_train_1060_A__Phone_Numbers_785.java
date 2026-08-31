import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			String a = sc.next();
			int Count = 0;
			for(int i=0;i<n;i++) 
				if(a.charAt(i) == '8')
					Count++;
			if(Count > n/11)
				System.out.println(n/11);
			else
				System.out.println(Count);
		}
	}
}
