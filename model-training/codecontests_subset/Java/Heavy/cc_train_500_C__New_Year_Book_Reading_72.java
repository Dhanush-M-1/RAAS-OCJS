import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 public   class Main {
    static class Reader
    {
    BufferedReader r;
    StringTokenizer str;
    Reader()
    {
    r=new BufferedReader(new InputStreamReader(System.in));
    }
    Reader(String fileName) throws FileNotFoundException
    {
    r=new BufferedReader(new FileReader(fileName));
    }
    public String getNextToken() throws IOException
    {
    if(str==null||!str.hasMoreTokens())
    {
    str=new StringTokenizer(r.readLine());
    }
    return str.nextToken();
    }
    public int nextInt() throws IOException
    {
    return Integer.parseInt(getNextToken());
    }
    public long nextLong() throws IOException
    {
    return Long.parseLong(getNextToken());
    }
    public double nextDouble() throws IOException
    {
    return Double.parseDouble(getNextToken());
    }
    public String nextString() throws IOException
    {
    return getNextToken();
    }
    public int[] intArray(int n) throws IOException
    {
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        
        return a;
        
    }
    public long[] longArray(int n) throws IOException
    {
        long a[]=new long[n];
        for(int i=0;i<n;i++)
            a[i]=nextLong();
        
        return a;
        
    }
    public String[] stringArray(int n) throws IOException
    {
        String a[]=new String[n];
        for(int i=0;i<n;i++)
            a[i]=nextString();
        
        return a;
        
    }
    public int gcd(int a, int b) {
if(b == 0){
return a;
}
return gcd(b, a%b);
}
    }
  
   
    public static void main(String args[]) throws IOException{
    
     
       Reader r=new Reader();
       PrintWriter pr=new PrintWriter(System.out,false);
 int n=r.nextInt();
 int k=r.nextInt();
int w[]=r.intArray(n);
boolean a[]=new boolean[n];
int b[]=new int[n];

int q[]=r.intArray(k);
for(int i=0;i<k;i++)
    q[i]--;
int top=0;
for(int i=0;i<k;i++)
{
    if(!a[q[i]])
    {
        a[q[i]]=true;
        b[top++]=q[i];
        
    }
    
    
}
long sum=0;
for(int i=0;i<k;i++)
{
    int j=0;
    while(j<n&&b[j]!=q[i])
    {
        
        sum+=w[b[j]];
        j++;
        
        
    }
    
    for(;j>0;j--)
    {
     b[j]=b[j-1];   
        
    }
    b[0]=q[i];
    
    
}

pr.println(sum);


       pr.flush();
       pr.close();
    }


 } 
