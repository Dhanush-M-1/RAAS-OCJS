import java.util.*;
import java.io.*;
public class chC{
public static void main(String args[]) throws IOException{
BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
String tmp = lector.readLine();
int a = Integer.parseInt(tmp.substring(0,tmp.indexOf(" ")));
int b = Integer.parseInt(tmp.substring(tmp.indexOf(" ")+1));
String j[] = lector.readLine().split(" ");
int p[] = new int[a];
for(int n =0;n<p.length;n++)
p[n]=Integer.parseInt(j[n]);
String k[] = lector.readLine().split(" ");
int o[] = new int[b];
for(int n =0;n<o.length;n++)
o[n]=Integer.parseInt(k[n])-1;
int res = 0;
boolean lib[] = new boolean[a];
int pos[] = new int[a];
int sumP[] = new int[a];
Arrays.fill(pos,-1);
int t = 0;
for(int n = 0;n<o.length;n++){
if(!lib[o[n]]){
lib[o[n]]=true;
res+=t;
t+=p[o[n]];
}else{
res+=sumP[o[n]];
}
//System.out.println("-->"+res);
int posv =pos[o[n]];
pos[o[n]]=0;
sumP[o[n]]=0;
for(int m = 0;m<p.length;m++){
if(lib[m] && m!=o[n]){
pos[m]++;
if(posv>pos[m]-1 || posv==-1)
sumP[m]+=p[o[n]];
}
//System.out.println(m+" "+pos[m]+" "+sumP[m]);
}
}
System.out.println(res);
}
}
