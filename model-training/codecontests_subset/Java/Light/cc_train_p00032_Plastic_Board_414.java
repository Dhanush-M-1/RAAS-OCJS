import java.io.*;

class Main{
public static void main(String[] args) throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int rec=0;
int loz=0;
String line;
while((line=br.readLine())!=null){
String[] value=line.split(",");
int s1=Integer.parseInt(value[0]);
int s2=Integer.parseInt(value[1]);
int d=Integer.parseInt(value[2]);
if(d==Math.hypot(s1,s2)){
rec++;
}
if(s1==s2){
loz++;
}
}
System.out.println(rec);
System.out.println(loz);
}
}