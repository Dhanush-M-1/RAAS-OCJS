import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        new A();
    }
        public A() {
                Scanner scan = new Scanner(System.in);
                int r1 = scan.nextInt();
                int r2 = scan.nextInt();
                int c1 = scan.nextInt();
                int c2 = scan.nextInt();
                int d1 = scan.nextInt();
                int d2 = scan.nextInt();

                int y1 = (r1 - d1 + c2) / 2;
                int y2 = c2 - y1;
                int x1 = r1 - y1;
                int x2 = r2 - y2;

                if (x1 < 1 || x2 < 1 || y1 < 1 || y2 < 1) {
                        System.out.println("-1");
                } else if(y1 + x2 != d2){
                        System.out.println("-1"); 
                } else if (x1 > 9 || x2 > 9 || y1 > 9 || y2 > 9) {
                        System.out.println("-1");
                } else if (x1 == x2 || x1 == y1 || x1 == y2 || y1 == x2 || y1 == y2
                                || x2 == y2) {
                        System.out.println("-1");
                } else {

                        System.out.print(x1 + " ");
                        System.out.print(y1);
                        System.out.println();
                        System.out.print(x2 + " ");
                        System.out.print(y2);
                }
        }

}