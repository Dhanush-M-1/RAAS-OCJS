import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int n,ans;
        String k;
        String ans2[];
        n = in.nextInt();
        k = in.next();
        int[] count = new int[2];
        for(int i = 0; i< n;i++){
            if(k.charAt(i) == '1'){
                count[1]++;

            }
            else{
                count[0]++;
            }
        }
        //If equal number of 0s and 1s
        if(count[0] == count[1]){
            ans = 2;
            ans2 = new String[2];
            ans2[0] = k.substring(0,1);
            ans2[1] = k.substring(1,n);
        }
        else{
            ans = 1;
            ans2 = new String[1];
            ans2[0] = k;
        }
        System.out.println(ans);
        for(String i: ans2){
            System.out.print(i + " ");
        }
    }
}
