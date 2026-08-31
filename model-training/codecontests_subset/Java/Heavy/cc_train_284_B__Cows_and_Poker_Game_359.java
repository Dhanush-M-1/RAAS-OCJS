
import java.util.Scanner;

public class B {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char a[];
        a = in.next().toCharArray();
        int all =0 ;
        int f = 0;
        int inn = 0;
        int ans = 0 ;
        for(int i = n-1 ; i >=0;i--){
            if(a[i]=='F')
                f++;
            else if(a[i]=='A')
                all++;
            else {
                
                inn++;
            }
        }
        if(inn==1){
            System.out.println(inn);
            return;
        }
        if(inn>1){
            System.out.println(0);
            return;
        }
        System.out.println(all);
    }
}
