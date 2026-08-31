import java.io.*;
import java.util.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int tempa=a,tempb=b;
        int a2=0,a3=0,a5=0,b2=0,b3=0,b5=0;
        while(tempa%2==0){
            a2++;
            tempa/=2;
        }
        while(tempa%3==0){
            a3++;
            tempa/=3;
        }
        while(tempa%5==0){
            a5++;
            tempa/=5;
        }
        tempb=b;
        while(tempb%2==0){
            b2++;
            tempb/=2;
        }
        while(tempb%3==0){
            b3++;
            tempb/=3;
        }
        while(tempb%5==0){
            b5++;
            tempb/=5;
        }
        System.out.print((tempa==tempb)?(Math.abs(a2-b2)+Math.abs(a3-b3)+Math.abs(a5-b5)):-1);

    }
}