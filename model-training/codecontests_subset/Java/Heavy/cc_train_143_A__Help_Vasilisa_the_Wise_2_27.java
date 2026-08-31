import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
        //  System.out.print(i);
            for (int j = 1; j <= 9; j++) {
            //  if (j == i) break;
                for (int j2 = 1; j2 <= 9; j2++) {
            //      if (j2 == i || j2 == j)  break;
                    for (int k = 1; k <= 9; k++) {
                //      if (k == i || k == j || k == j2)  break;
                        if ((i+j)==r1 && (k+j2)==r2 && (i+j2)==c1 && (k+j)==c2 &&(i+k)==d1 && (j+j2)==d2 
                            && i != j && i != j2 && i != k && j2 != j && k != j && k != j2 ){
                            System.out.println(i+" "+j);
                            System.out.println(j2+" "+k);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("-1");       
    }
}
