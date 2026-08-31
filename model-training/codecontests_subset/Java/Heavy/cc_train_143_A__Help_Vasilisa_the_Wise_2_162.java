import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main
{
static class FastReader
{
BufferedReader br;
StringTokenizer st;
public FastReader()
{
br = new BufferedReader(new
InputStreamReader(System.in));
}
String next()
{
while (st == null || !st.hasMoreElements())
{
try
{
st = new StringTokenizer(br.readLine());
}
catch (IOException e)
{
e.printStackTrace();
}
}
return st.nextToken();
}
int nextInt()
{
return Integer.parseInt(next());
}
long nextLong()
{
return Long.parseLong(next());
}
double nextDouble()
{
return Double.parseDouble(next());
}
String nextLine()
{
String str = "";
try
{
str = br.readLine();
}
catch (IOException e)
{
e.printStackTrace();
}
return str;
}
}


public static void main(String[] args)
{
FastReader fs=new FastReader();

int r1 = fs.nextInt();
int r2 = fs.nextInt();
int c1 = fs.nextInt();
int c2 = fs.nextInt();
int d1 = fs.nextInt();
int d2 = fs.nextInt();

int a=1,b=1,c=1,d=1;
boolean flag = false;

if(r1>18 || r2>18 || c1>18 || c2>18 || d1>18 || d2>18)
{
    // System.out.println("executed");
    System.out.println(-1);
}
else
{
    for(a=1;a<=9;a++)
    {
        for(b=1;b<=9;b++)
        {
            for(c=1;c<=9;c++)
            {
                for(d=1;d<=9;d++)
                {
                    // System.out.println(a+" "+b+" "+c+" "+d);
                    if( ((a+b)==r1) && ((a+c)==c1) && ((c+d)==r2) && ((b+d)==c2) && ((a+d)==d1) && ((b+c)==d2) )
                    {
                        if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d)
                        {
                            flag = true;
                            break;
                        }    
                    }
                }
                if(flag)
                {
                        flag = true;
                        break;
                }
            }
            if(flag)
                {
                        flag = true;
                        break;
                }
        }
        if(flag)
                {
                        flag = true;
                        break;
                }
    }
    
    if(flag)
    {
        System.out.println(a+" "+b);
        System.out.println(c+" "+d);
    }
    else
    {
        System.out.println(-1);
    }
}

}
}

