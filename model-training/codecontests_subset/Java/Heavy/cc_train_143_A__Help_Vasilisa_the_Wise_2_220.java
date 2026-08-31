import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
    import java.math.BigDecimal;
    import java.util.ArrayList;
    import java.lang.reflect.Array;
    import java.math.BigInteger;
    import java.util.*;

    public class Main {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            ArrayList<String> main = new ArrayList<>();
            ArrayList<Integer> inter = new ArrayList<>();
            int count = 0;

            int row1 = Integer.valueOf(scan.nextInt());
            int row2 = Integer.valueOf(scan.nextInt());
            int colum1 = Integer.valueOf(scan.nextInt());
            int colum2 = Integer.valueOf(scan.nextInt());
            int diag1 = Integer.valueOf(scan.nextInt());
            int diag2 = Integer.valueOf(scan.nextInt());


            for (int a = 1; a < 10; a++) {
                for (int b = 1; b < 10; b++) {
                    for (int c = 1; c < 10; c++) {
                        for (int d = 1; d < 10; d++) {

                            if (a+b==row1 && c+d==row2 && a+c==colum1 && d+b==colum2 && a+d==diag1 && b+c==diag2 && a!=b&&a!=c&&a!=d&&b!=c&&b!=d&&c!=d) {
                                System.out.println(a + " " + b + "\n" + c + " " + d);
                                count=1;
                                break;
                            }

                        }
                    }
                }
            }
            if (count==1) {

            } else {
                System.out.println("-1");
            }

        }
    }