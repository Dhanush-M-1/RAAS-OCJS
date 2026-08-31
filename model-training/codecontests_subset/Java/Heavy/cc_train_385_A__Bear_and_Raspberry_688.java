import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bharanikrishna.c on 3/10/14.
 */
public class A385 {
    public static void main(String[] args) throws IOException{
        BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
        String s = ip.readLine();
        String[] sp1 = s.split(" ");
        s = ip.readLine();
        String[] sp2 = s.split(" ");
        int n,c,i,ans=0,tmp=0;

        n = Integer.parseInt(sp1[0]);
        c = Integer.parseInt(sp1[1]);

        for (i=1;i<n;i++) {
            tmp = Integer.parseInt(sp2[(i-1)]) - Integer.parseInt(sp2[i]) - c;
            if(tmp>ans)
                ans = tmp;
        }
        System.out.println(ans);
    }
}