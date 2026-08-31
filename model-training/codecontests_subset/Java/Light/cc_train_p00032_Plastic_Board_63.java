import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hishi = 0; int choho = 0;
		while(sc.hasNext()){
			String[] temp = sc.nextLine().split(",");
			int[] a = new int[3];
			for(int i=0; i<3; i++)	a[i] = Integer.parseInt(temp[i]);
			if(a[0]==a[1]) hishi++;
			else if(a[0]*a[0]+a[1]*a[1] == a[2]*a[2]) choho++;
		}
		System.out.printf("%d%n%d%n",choho,hishi);
	}

}