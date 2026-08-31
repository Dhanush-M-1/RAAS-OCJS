import java.util.*;
import java.lang.*;
import java.io.*;

public final class Main
{
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n= in.nextInt();
            int m = in.nextInt();
            Set<Integer> set = new HashSet<>();
            
            for(int i =0; i< n ; i++) {
                set.add(in.nextInt());
            }
            boolean ff = false;
            int f =0;
            for(int i =0; i<m; i++){
                int v = in.nextInt();
                if(set.contains(v)){
                    f =v;
                    ff= true;
                }
            }
            
            if(ff){
                System.out.println("YES");
                 System.out.println("1 "+f);
            } else
            System.out.println("NO");
        }

    }
}