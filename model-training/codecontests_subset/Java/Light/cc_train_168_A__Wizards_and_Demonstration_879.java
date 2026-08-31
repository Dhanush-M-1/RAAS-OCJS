import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int w = sc.nextInt();
        int y = sc.nextInt();
        
        int needed = (n*y)/100;
        if((n*y)%100!=0) needed++;
        if(needed-w<0) System.out.println(0);
        else
        System.out.println(needed-w);
        
    }
}