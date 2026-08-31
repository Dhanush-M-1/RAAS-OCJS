
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //1: Declare and initalize variables
        int c, v0, v1, a, l, days = 1, unqiuePages = 0, numOfPagesPerDay, numOfUniquePagesPerDay=0;
        Scanner in = new Scanner(System.in);

        //2: Get input
        c = in.nextInt();
        v0 = in.nextInt();
        v1 = in.nextInt();
        a = in.nextInt();
        l = in.nextInt();

        unqiuePages = v0;

        //3: Calculate the number of days
        while (unqiuePages < c) {

            days++;
            numOfPagesPerDay = v0 +(days-1)*a;
            
            if (numOfPagesPerDay>v1) {
                numOfPagesPerDay=v1;
            }
            numOfUniquePagesPerDay=numOfPagesPerDay-l;
            
            unqiuePages+=numOfUniquePagesPerDay;

        }
        
        
        System.out.println(days);
    }
}
