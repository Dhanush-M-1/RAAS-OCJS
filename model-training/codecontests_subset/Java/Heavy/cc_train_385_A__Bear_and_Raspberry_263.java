import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import java.util.List; 
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
//https://codeforces.com/problemset/problem/385/A
//A. Bear and Raspberry
public class Problem385A
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        StringTokenizer dates=new StringTokenizer(in.readLine());
        int n=Integer.parseInt(dates.nextToken());
        int c=Integer.parseInt(dates.nextToken());
        dates=new StringTokenizer(in.readLine());
        int[] day=new int[n];
            int mayor=0;
            int i;
            int pos=0;
            for(i=0;i<n;i++)
            {
            	day[i]=Integer.parseInt(dates.nextToken());
            	if(i>0&&day[i-1]-day[i]-c>mayor)
            	{
            		mayor=day[i-1]-day[i]-c;
            		pos=i;
            	}
            }
            if(mayor<0)
            	out.println(0);
            else
            	out.println(mayor);
        out.close();
    }
}