
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by chinh on 7/19/14.
 */
public class R282D1A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chrs = br.readLine().toCharArray();
        int n = chrs.length;
        int open=0, close=0;
        int m=0;
        for(int i=0; i<n; i++){
            if(chrs[i]=='(') open++; else
            if(chrs[i]==')') close++; else m++;
            if(open<close+m) {
                System.out.println(-1);
                return;
            }
        }
        int added = open-close;
        open=0; close=0;
        for(int i=n-1; i>=0; i--){
            if(chrs[i]=='(') open++; else
            if(chrs[i]==')') close++; else break;
            if(open>close){
                System.out.println(-1);
                return;
            }
        }
        for(int i=1; i<m; i++) System.out.println(1);
        System.out.println(added-(m-1));
    }
}