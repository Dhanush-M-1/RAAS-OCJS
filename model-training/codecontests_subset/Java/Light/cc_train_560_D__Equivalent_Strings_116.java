import java.util.Scanner;

/**
 * Created by Александр on 22.07.2015.
 */
public class Test {
    static boolean eq(String ch1, String ch2){
        if(ch1.length()%2 == 1)
            return ch1.equals(ch2);

        if(ch1.equals(ch2))
            return true;

        String ch1half1 = ch1.substring(0, ch1.length()/2), ch1half2 = ch1.substring(ch1.length()/2),
                ch2half1 = ch2.substring(0, ch1.length()/2), ch2half2 = ch2.substring(ch1.length()/2);


        return eq(ch1half1, ch2half2) && eq(ch1half2, ch2half1) || eq(ch1half1, ch2half1) && eq(ch1half2, ch2half2) ;
    }


    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        String ch1 = in.next(), ch2 = in.next();

        System.out.println(eq(ch1, ch2) ? "YES" : "NO");
    }
}