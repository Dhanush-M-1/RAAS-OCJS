import java.util.*;


public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int card = sc.nextInt();
		int a[][] = new int[4][13];
		//文字だけを取り除く
		for (int i = 0; i < card; i++) {
		    String b = sc.next();
		    int c = sc.nextInt();
		    if ("S".equals(b))
		        a[0][c - 1] = 1;
		    else if ("H".equals(b))
		        a[1][c - 1] = 1;
		    else if ("C".equals(b))
		        a[2][c - 1] = 1;
		    else
		        a[3][c - 1] = 1;
		}
		
		for (int i = 0; i < 4; i++) {
		    for (int t = 0; t < 13; t++) {
		        if (a[i][t] == 0)
		            if(i == 0)
		                System.out.println("S " + (t + 1));
		            else if (i == 1)
		                System.out.println("H " + (t + 1));
		            else if (i == 2)
		                System.out.println("C " + (t + 1));
		            else if (i == 3)
		                System.out.println("D " + (t + 1));
		    }
		}
    }
}
