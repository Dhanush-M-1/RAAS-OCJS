import java.util.*;
import java.lang.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ip;
        int[] apple= new int[2];
        for(int i=0; i<n; i++){
            ip = in.nextInt();
            if(ip==100)
                apple[0]= apple[0]+1;
            else
                apple[1]= apple[1]+1;
        }
        if(apple[0]%2==0 && (apple[1]%2==0 || apple[1]%2==1 && apple[0]>=2)){
            System.out.println("YES");
        }
        else
            System.out.println("NO");
    }
}