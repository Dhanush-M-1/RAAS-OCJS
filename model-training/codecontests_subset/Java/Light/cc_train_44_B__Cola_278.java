import java.util.*;
import java.io.*;
public class cola{
public static void main(String args[]) throws IOException{
BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
String tmp[] = lector.readLine().split(" ");
int a = Integer.parseInt(tmp[0]);
int d = Integer.parseInt(tmp[1]);
int c = Integer.parseInt(tmp[2]);
int b = Integer.parseInt(tmp[3]);
long res = 0;
for(int n = 0;n<=b;n++)
for(int m = 0;m<=c;m++)
if(a-(n*2+m)>=0 && d>=2*(a-(n*2+m))){
res++;
//System.out.println(n+" "+m+" "+(a-(n*2+m))*2);
}
System.out.println(res);
}
}
