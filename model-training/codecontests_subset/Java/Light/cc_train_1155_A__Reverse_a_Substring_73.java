import java.io.*;
import java.util.*;
public class Main3 {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        char[] c=scan.next().toCharArray();
        int minIdx=0;
        char min=c[0];
        for(int i=1;i<n;i++){
            if(c[i]<min){
                System.out.println("YES");
                System.out.print((minIdx+1)+" "+(i+1));
                return;
            }else{
                min=c[i];
                minIdx=i;
            }

    }
        System.out.print("NO");
    }
}
