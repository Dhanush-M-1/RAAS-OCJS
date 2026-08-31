import java.io.*;
import java.util.*;
public class ppp1
{
    public static void main(String[] args) throws IOException
    {
    	Scanner f = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(f.nextLine());
        int n = 0;
        for(int i = 0; i<5;i++){
        	n += Integer.parseInt(st.nextToken());
        }
        //System.out.println(n);
        
        f.close();
        
        if(n == 0 || n%5 != 0){
        	System.out.println(-1);
        }
        else{
        	System.out.println(n/5);
        }
        
    }
}