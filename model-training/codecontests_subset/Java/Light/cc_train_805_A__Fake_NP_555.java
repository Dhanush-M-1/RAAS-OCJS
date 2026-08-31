import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = new Integer(st.nextToken());
        int m = new Integer(st.nextToken());
        if(l==m){
            System.out.println(l);
        }
        else{
            System.out.println("2");
        }
    }
}