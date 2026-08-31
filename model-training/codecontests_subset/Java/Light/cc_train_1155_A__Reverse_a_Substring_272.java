
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.Math.*;

public class ReverseSubstring {


    public static void main(String[] args)throws IOException {
        BufferedReader gi = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(gi.readLine());
        String inp= gi.readLine();
        int cmp = inp.charAt(0);
        int k=0;
        int ans=0;
        for (int i = 1; i < n; i++) {
            k=inp.charAt(i);
            if(k<cmp){
                ans=i;
                break;
            }else{
                cmp=k;
            }
        }
        if(ans==0){out.println("NO");out.close();}
        else{
            out.println("YES");
            out.print(ans);
            out.print(" ");
            out.print(ans+1);
            out.println("");
            out.close();
        }
    }
}
