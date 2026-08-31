import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/** Oct 5, 2012 **/

/**
 * @author DOAN Minh Quy
 * @email mquy.doan@gmail.com
 */
public class A150 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new A150().run();
    }
    void run(){
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        long numberQ = scanner.nextLong();
        scanner.close();
        if ( numberQ == 1 ){
            printer.println("1\n0");
            return;
        }
        int sqrt = (int) Math.sqrt(numberQ)+1;
        ArrayList<Long> nonTrivial = new ArrayList<Long>();
        for(int i = 2 ; i < sqrt ; ++i){
            if ( i > numberQ ) break;
            while (numberQ % i == 0){
                nonTrivial.add((long)i);
                numberQ /= i;
            }
        }
        
        if ( numberQ > 1L ) nonTrivial.add(numberQ);
        if ( nonTrivial.size() == 1 ){
            printer.println("1\n0");
        }else if ( nonTrivial.size() == 2 ){
            printer.println("2");
        }else{
            printer.printf("1\n%d\n", 1L * nonTrivial.get(0) * nonTrivial.get(1));
        }
    }
}
