import java.util.Scanner;
import java.util.Arrays;
public class Kstring{
public static  void main(String []args)
{
Scanner s = new Scanner(System.in);
int k = s.nextInt();
String str  = s.next();
int chars[] = new int[125];
Arrays.fill(chars, 0);
for(int i = 0; i < str.length(); ++i)
  {
    char ch = str.charAt(i);
    ++chars[(int)ch];
  }
int cnt = 0; 
String result = "";
int j;
for(int i = 95; i < 123; ++i)
  {
    if((cnt = chars[i]) != 0 ){
    char ch  = (char) i;
    if(cnt % k != 0)
    {
      System.out.println("-1");return;
     }
      j = 0;
     while(j++ < (cnt / k))
         result += ch;
     }
   }
j = 0;
String temp = result;
while(j++ < k - 1)
   result += temp;
System.out.println(result);
}
}