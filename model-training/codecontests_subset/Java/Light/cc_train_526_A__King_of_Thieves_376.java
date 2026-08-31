import java.util.*;
import java.io.*;
public class juegomarica{
public static void main(String args[]) throws IOException{
BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
int a = Integer.parseInt(lector.readLine());
String tmp = lector.readLine();
for(int n = 0;n<a;n++){
if(tmp.charAt(n)=='.')continue;
for(int m = 1;m<a;m++){
int c = 1;
for(int p = n+m;p<a;p+=m)
if(tmp.charAt(p)=='*')c++;
else break;
if(c>=5){
System.out.println("yes");
return;
}
}
}
System.out.println("no");

}
}
