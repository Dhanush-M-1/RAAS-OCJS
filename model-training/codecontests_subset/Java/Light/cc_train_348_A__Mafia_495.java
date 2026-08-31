import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       int n=scanner.nextInt();
       long x[]=new long[n];
       long sum=0,max=0;
       for (int i=0;i<n;i++){
           x[i]=scanner.nextLong();
           sum+=x[i];
           if (x[i]>max){
               max=x[i];
           }
       }
        System.out.println((long)Math.max(Math.ceil(((double) sum)/(n-1)),max));

    }
}