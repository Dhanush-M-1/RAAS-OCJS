import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
        int n = sc.nextInt();
        int p=0,c=0;
        boolean flag = true;
        while(n-->0){
            int pi = sc.nextInt();
            int ci = sc.nextInt();
            if(pi < p || ci < c || pi - p < ci - c || pi < ci){
                flag = false;
            }
            p = pi;
            c = ci;
        }
        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        }
    }
}