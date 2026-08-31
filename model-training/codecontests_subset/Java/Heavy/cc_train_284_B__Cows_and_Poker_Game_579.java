
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String []args)throws IOException{
       
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String line;
    line=br.readLine();
    int n;
    char c[];
    n=Integer.parseInt(line);
    line=br.readLine();
    HashMap<Character,Integer> h=new HashMap();
    int i,f,a;
    f=0;
    i=0;
    a=0;
    c=line.toCharArray();
    int tama=c.length;
    for(int e=0;e<tama;e++){
        if(c[e]=='A')
            a++;
        else if(c[e]=='F')
            f++;
        else if(c[e]=='I')
            i++;
    }
    int cont=0;
    for(int e=0;e<tama;e++){
        if(c[e]=='A' || c[e]=='I'){
            if(c[e]=='I'){
            if(i==1)
                cont++;
            }
            if(c[e]=='A'){
                if(i==0)
                    cont++;
            }
        }
    }
    System.out.println(cont);
        
    
    }
}

