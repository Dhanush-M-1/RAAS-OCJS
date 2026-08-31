
import java.io.*;
import java.util.*;
public class Main2 {
    public static boolean check(String s, char c){
        if (s.equals("")) return true;
        boolean x=true;
         for (int j=0; j<s.length(); j++){
             if (s.charAt(j)==c){
                 x=false;
                 break;
             }
         }
         return x;
    }
    
    
    public static int count (String s, char c){
        int i=0;
        for (int j=0; j<s.length(); j++)
            if (s.charAt(j)==c)i++;
        return i;
    }

    public static void main(String[] args)throws IOException {
         BufferedReader  buffer = new BufferedReader (new InputStreamReader(System.in)) ;
         int n=Integer.parseInt((buffer.readLine()));
         String s=buffer.readLine();
         String c="";
         boolean x=true;
         for (int i=0; i<s.length(); i++){
             int k= count(s,s.charAt(i));
             if (k%n==0){
                 if (check(c, s.charAt(i)))
                     for (int j=0; j<k/n; j++)
                         c+=s.charAt(i);
             }
             else {
                 x=false ;
                 break;
             }
         }
         if (x){
             String r="";
             for (int i=0; i<n;i++)
                 r+=c;
             System.out.print(r);
         }
         else
             System.out.print(-1); 
         
         
         

    }

}
