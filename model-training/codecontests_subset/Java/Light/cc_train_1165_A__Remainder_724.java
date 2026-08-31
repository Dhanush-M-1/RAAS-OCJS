import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;    
public class codeforces{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str=new StringBuilder();
        String[] lol;
        lol=br.readLine().split(" ");
        int n=Integer.parseInt(lol[0]);
        int x=Integer.parseInt(lol[1]);
        int y=Integer.parseInt(lol[2]);
        String h=br.readLine();
        h=h.substring(n-x-1);
        int j=h.length();
        int freq=0;
        for(int i=1;i<j;i++){
            if(h.charAt(i)=='1')
            freq++;
        }
        if(h.charAt(j-y-1)=='1')
        str.append(freq-1);
        else
        str.append(freq+1);
        System.out.println(str);
    }
}