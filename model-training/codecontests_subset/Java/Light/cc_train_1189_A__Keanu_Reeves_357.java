import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = new Integer(br.readLine());
        String s = br.readLine();
        br.close();
        int one=0,zero=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                one++;
            }
            else{
                zero++;
            }
        }
        if(one!=zero){
            System.out.println("1");
            System.out.println(s);
        }
        else{
            System.out.println("2");
            System.out.println(s.charAt(0)+" "+s.substring(1,s.length()));
        }
    }
}