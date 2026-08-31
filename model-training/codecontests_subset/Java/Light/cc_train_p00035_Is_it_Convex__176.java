import java.io.*;

class Main{
public static void main(String[] args) throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String line;
while((line=br.readLine())!=null){
String[] value=line.split(",");
double xa=Double.parseDouble(value[0]);
double ya=Double.parseDouble(value[1]);
double xb=Double.parseDouble(value[2]);
double yb=Double.parseDouble(value[3]);
double xc=Double.parseDouble(value[4]);
double yc=Double.parseDouble(value[5]);
double xd=Double.parseDouble(value[6]);
double yd=Double.parseDouble(value[7]);
double area1=area(xb-xa,yb-ya,xd-xa,yd-ya)+area(xb-xc,yb-yc,xd-xc,yd-yc);
double area2=area(xa-xb,ya-yb,xc-xb,yc-yb)+area(xa-xd,ya-yd,xc-xd,yc-yd);
if(area1==area2){
System.out.println("YES");
}
else{
System.out.println("NO");
}
}
}
static double area(double a,double b,double c,double d){
return Math.abs(a*d-b*c)/2;
}
}