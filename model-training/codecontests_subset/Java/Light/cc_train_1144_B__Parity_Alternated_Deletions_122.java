import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class sad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> even = new ArrayList<>() ;
        ArrayList<Integer> odd  = new ArrayList<>() ;
        for(int i=0;i<n;i++) {
            int temp = sc.nextInt() ;
            if(temp %2 == 0) {
                even.add(temp);
            }
            else {
                odd.add(temp) ;
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        int es,os ,ans;
        ans = 0 ;
        es = even.size() ;
        os = odd.size() ;
        if(Math.abs(es-os) <= 1) {
            ans = 0 ;
        }
        else {
            if(es > os) {
                for(int i=0;i<es-os-1;i++) {
                    ans += even.get(i)  ;
                }
            }
            else {
                for(int i=0;i<os-es-1;i++) {
                    ans += odd.get(i)  ;
                }
            }
        }
        System.out.println(ans);
    }
}
