import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Main
{
public static void main(String[] args)throws java.lang.Exception
{
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
PrintWriter out=new PrintWriter(System.out);
int i,len,o1,c1,cnt,open,close,close1,cur;
String str;
boolean exists;


exists=true;

str=in.readLine().trim();

len=str.length();


o1=0;
c1=0;
cnt=0;

for(i=0;i<len;i++)
{
if(str.charAt(i)=='(')
	++o1;
else if(str.charAt(i)==')')
	++c1;
else if(str.charAt(i)=='#')
	++cnt;
}


open=0;
close=0;
cur=1;

for(i=0;i<len;i++)
{
if(str.charAt(i)=='(')
	++open;
else if(str.charAt(i)==')')
	++close;
else
	{
	if(cur<cnt)
		{
		++close;
		}
	else
		{
		close1=(o1-c1)-(cnt-1);
		if(close1<1)
			{
			exists=false;
			break;
			}
		else
			{
			close+=close1;
			}
		}

	++cur;
	}

if(open<close && i<len-1)
	{
	exists=false;
	break;
	}

}

if(!exists)
	{
	out.println(-1);
	}
else
	{
	if(open!=close)
		{
		out.println(-1);
		}
	else
	{

	for(i=0;i<cnt-1;i++)
		out.println(1);
	
	out.println((o1-c1)-(cnt-1));
	}
		
	}


out.flush();
out.close();
}
} 