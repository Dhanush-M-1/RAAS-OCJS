import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class A63{
public static long mod = 1000000007;
public static int dx[] = {-1,0,1,0,-1,-1,1,1,-1};//primero ady, despues esq
public static int dy[] = {0,1,0,-1,1,1,-1,-1};
public static void main(String args[]) throws IOException{
StringBuilder sb = new StringBuilder("");
BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
//String tmp[] = lector.readLine().split(" ");
int cas = Integer.parseInt(lector.readLine());
String b = lector.readLine();
String bb = "";
int n1 = 0;
int n2 = 0;
boolean t = true;
for(int n = 1;n<b.length();n++){
if(b.charAt(n)<b.charAt(n-1)){
t=false;
n1 = n;
n2 = n+1;
//bb = b.substring(0,n-1)+b.charAt(n)+""+b.charAt(n-1)+b.substring(n+1);
}

}
System.out.println(!t?"YES\n"+n1+" "+n2:"NO");
}

}
class p implements Comparable{
public int a;
public p(int a){
this.a = a;
}
public String toString(){
return "";
}
public int compareTo(Object o){
p pp = (p)o;
return (int)Math.signum(a-pp.a);
}
}
//sergio1
