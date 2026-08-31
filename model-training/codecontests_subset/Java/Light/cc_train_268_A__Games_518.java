import java.util.*;
import java.io.*;
//import est.*;
public class Game
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int n=Integer.parseInt(in.readLine());
        int i,j=0;
        StringTokenizer dates;
        int[] vec1=new int[100];
        int[] vec2=new int[100];
        int cont=0;
        for(i=0;i<n;i++)
        {
            dates=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(dates.nextToken());
            int b=Integer.parseInt(dates.nextToken());
            vec1[a-1]++;
            vec2[b-1]++;
        }
        for(i=0;i<100;i++)
        {
            if(vec1[i]!=0&&vec2[i]!=0)
                cont+=vec1[i]*vec2[i];
        }
        System.out.println(cont);
    }
}