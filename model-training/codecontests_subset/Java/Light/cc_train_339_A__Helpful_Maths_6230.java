import java.util.*;
import java.io.*;
public class asdf
{
public static void main(String args[])
{
try
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = br.readLine();
br.close();
String nums[] =line.split("\\+");
ArrayList arr = new ArrayList();
for(String num: nums)
{
arr.add(Integer.parseInt(num));
}
Collections.sort(arr);
StringBuilder sbr = new StringBuilder();
for(Iterator it = arr.iterator();;)
{
sbr.append(it.next());
if(!it.hasNext())
{
break;
}
sbr.append("+");
}
System.out.println(sbr.toString());
}
catch(Exception e)
{
e.printStackTrace();
}
}
}
