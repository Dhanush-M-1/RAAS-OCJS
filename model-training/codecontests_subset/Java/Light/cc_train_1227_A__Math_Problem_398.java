import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int y=Integer.MAX_VALUE;
            int cnt=0;
            for (int i=0;i<n;i++) {
                cnt = Math.max(cnt, s.nextInt());
                y = Math.min(y, s.nextInt());

            }
            System.out.println(Math.max(cnt-y,0));
        }
    }
}
