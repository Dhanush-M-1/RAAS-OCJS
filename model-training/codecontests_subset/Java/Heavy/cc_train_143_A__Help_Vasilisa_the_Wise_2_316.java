import java.io.PrintWriter;
import java.util.Scanner;

public class A143 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);   
        public static void main(String[] args) {
        int r1 = in.nextInt() , r2 =in.nextInt() ,c1 =in.nextInt(),c2 =in.nextInt(),d1 =in.nextInt() ,d2 =in.nextInt();
        boolean found = false;
            for (int first = 1; first < 10; first++) {
                int second = r1-first;
                int third = c1-first;
                int fourth = c2 - second;
                            if(second > 0 && second < 10 && third > 0 && third < 10 && fourth > 0 && fourth < 10 &&
                                    third + fourth == r2 && first + fourth == d1 && second + third == d2 &&
                                    first != second && first != third && first != fourth &&
                                    second != third && second != fourth && third != fourth){

                    found = true;
                    out.println(first+" "+second+"\n"+third+" "+fourth);
                }
            }
            if(!found)
                out.println("-1");
            out.flush();
        }
}

