import java.io.*;

public class Main
{
    public static void main(String args[]) throws java.lang.Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String[] S=br.readLine().split(" ");
        
        Solve(Integer.parseInt(S[0]),Integer.parseInt(S[1]));
    }
    
    static void Solve(int a,int b)
    {
        int time=a,a1=a,safe=0;
        while(a1>=b)
        {
            a=a1/b;
            safe=a1%b;
            time+=a;
            a1=a+safe;
        }
        
        System.out.println(time);
    }
}