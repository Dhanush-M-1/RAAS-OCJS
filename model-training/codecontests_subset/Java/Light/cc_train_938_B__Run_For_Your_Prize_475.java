import java.util.*;
public class codeforce{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = 1;
        int r = 1000000;
        boolean ok = true;
        for(int i=0;i<n;i++){
            int k = sc.nextInt();
            if(k<=5*100000) l = k;
            else{
                if(ok){
                    r = k;
                    ok = false;
                }
            } 
        }
        int r1 = 499999-(500000-l);
        int r2 = 499999-(r-500001);
        System.out.println(Math.max(r1,r2));
    }
}