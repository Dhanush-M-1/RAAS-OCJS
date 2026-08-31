import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  import java.util.*;
 
public class Main 
{ 
    public static int ans(int a ,int b,int c){
    int f=0;
    while(b>=1 && c>=2){
        f=f+3;
        b--;
        c=c-2;
    }
      while(a>=1 && b>=2){
        f=f+3;
        a--;
        b=b-2;
    }      
       
    
     return f;   
    }
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
                     
        int t= Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int a = Integer.parseInt(st.nextToken()); 
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(ans(a,b,c));
        }
    }}