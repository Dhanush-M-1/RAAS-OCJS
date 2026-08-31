/**
 * Created by hapsi on 28.09.2015.
 */
import javafx.util.Pair;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        int m=in.nextInt();
        HashMap<Integer,Long>lib=new HashMap<Integer, Long>();
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            if(lib.get(a)==null)
                lib.put(a,(long)1);
            else
                lib.put(a,lib.get(a)+1);
        }
        long total_score=0;
        for(int i=1;i<m;i++){
            long score=0;
            for(int j=i+1;j<=m;j++){
                score+=lib.get(i)*lib.get(j);
            }
            total_score+=score;
        }
        System.out.println(total_score);
    }
}