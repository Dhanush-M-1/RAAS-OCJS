
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Igors
 */
public class CF174A {
    public static void main(String[] args) throws IOException{
        StreamTokenizer s=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        s.nextToken();
        long n=(long)s.nval;
        char[] ch=new char[200100];
        long a=0,f=0,in=0;
        s.nextToken();
        ch=s.sval.toCharArray();
        for(int i=0;i<n;i++){            
            if (ch[i]=='A'){
                a++;
            }
            else if (ch[i]=='F'){
                f++;
            }
            else if (ch[i]=='I'){
                in++;
            }
        }
        if (in>1){
            System.out.println('0');            
        } else if(in==1){
            System.out.println('1');
        }
        else System.out.println(a);
    }
}
