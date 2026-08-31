import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
                int p1=0,c1=0;
                int n=Integer.parseInt(br.readLine());
                boolean ff=false;
                for(int j=0;j<n;j++) {
                    String[] ss = br.readLine().split(" ");
                    int p = Integer.parseInt(ss[0]);
                    int c = Integer.parseInt(ss[1]);
                    if(((p==p1 && c==c1) || (p>p1 && c>=c1 && c-c1<=p-p1)) && p>=c){
                        p1=p;
                        c1=c;
                    }else{

                        ff=true;
                    }
                }
                if(!ff){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }




        } catch (Exception e) {
            System.out.println("kkkk"+e.getMessage());
        }
    }

    static class pair{
        int a,b;
        public pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
}




