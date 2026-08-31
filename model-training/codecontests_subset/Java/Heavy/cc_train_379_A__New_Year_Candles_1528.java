import java.io.*;
import java.lang.*;
 public class NewYearCandle
{
public static void main(String args[]) throws IOException
{
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader stdin = new BufferedReader(isr);

boolean flag = false;
int a,b,x,y,z;
int gsum,rsum,sum;
gsum = rsum = 0;




String inputstring = null;

inputstring = stdin.readLine();
String[] split = inputstring.split(" ");
 a = Integer.parseInt(split[0]);
 b = Integer.parseInt(split[1]);

sum = a;
x = sum;y = x%b;

while(flag!=true)
{
while(x!=0)
{y = x%b;
x = x/b;

sum = sum + x;
rsum = rsum + y;

}

gsum = gsum + sum;

if(rsum>=b)
{
z = rsum/b;
sum = rsum;
x = sum;
rsum = 0;
y = x%b;
x = x/b;

rsum = rsum + y;
sum = x;
}
else
flag = true;
}


System.out.println(gsum);


}
}