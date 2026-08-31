import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.abs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;
import static java.lang.Short.parseShort;
import static  java.lang.Integer.parseInt;
import static  java.lang.Long.parseLong;
import static  java.lang.Double.parseDouble;

public class demo implements Runnable
{demo(){}
String str1,str2;
public static void main(String strgs[])throws IOException,InterruptedException
{ Thread t=new Thread(null, new demo(),"demo", 1<<25);
t.start();
t.join();

}
public void run()
{Fastinput in=new Fastinput();
    PrintWriter pr=new PrintWriter(System.out,true);
str1=in.readString();
str2=in.readString();
int n=in.readInt();
String a,b;
for(int i=1;i<=n;i++)
{a=in.readString();
b=in.readString();
pr.println(str1+" "+str2);
if(str1.equals(a))
{
    str1=b;
    
}
else
    str2=b;}
pr.println(str1+" "+str2);}
}
class Fastinput
{ StringTokenizer st;
 BufferedReader br;
Fastinput(){br=new BufferedReader(new InputStreamReader(System.in));}
String nexttoken() throws IOException
{while(st==null||!(st.hasMoreTokens())){st=new StringTokenizer(br.readLine());}
return st.nextToken();
}
int readInt()
{try
{return parseInt(nexttoken());}
catch(Exception  e)
{return 0;}
}
double readDouble()
{try
{return parseDouble(nexttoken());}
catch(Exception  e)
{return 0;}
}

Long readLong()
 {try
{return parseLong(nexttoken());}
catch(Exception  e)
{return (long)0;}
}

String readString()
{try
{return nexttoken();}
catch(Exception  e)
{return "";}
}        
short readShort()
{try
{return parseShort(nexttoken());}
catch(Exception  e)
{return 0;}
}        
}