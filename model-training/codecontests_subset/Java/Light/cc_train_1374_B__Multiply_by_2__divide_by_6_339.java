import java.util.*;
public class Sample{

    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0) {
        int n = sc.nextInt();
        int count =0;
        if(n==1) 
        System.out.println("0");
        else if(n==2)
        System.out.println("-1");
        else { 
        while(n>1) {
            if(n%6==0)
            n /= 6;
            else 
            n *= 2;
            count++;
        }
        if(n==1)
        System.out.println(count);
        else 
        System.out.println("-1");
        }
    }
       // System.out.println("Hello World");
    }
}
