import java.util.*;
import java.io.*;
public class main{
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        while(t-->0){
            int c=0;
            char s[]=sc.next().toCharArray();
            for (int i=1;i<s.length;i++){
                if(s[i]==s[i-1]) {
                    s[i]='.';
                    c++;
                }
                else if(i>1 && (s[i]==s[i-2])) {
                    s[i]='.';
                    c++;
                }
        
            }
            System.out.println(c);
        }//testings
    }//main
}//class