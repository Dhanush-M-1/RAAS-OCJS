import java.io.*;class Main{
public static void main(String[]_)throws Exception{
int i;
double l[]=new double[8];
BufferedReader B=new BufferedReader(new InputStreamReader(System.in));
for(String s;(s=B.readLine())!=null;
System.out.println(
((l[0]-l[2])*(l[5]-l[1])+(l[1]-l[3])*(l[0]-l[4]))*
((l[0]-l[2])*(l[7]-l[1])+(l[1]-l[3])*(l[0]-l[6]))<0||
((l[4]-l[6])*(l[1]-l[5])+(l[5]-l[7])*(l[4]-l[0]))*
((l[4]-l[6])*(l[3]-l[5])+(l[5]-l[7])*(l[4]-l[2]))<0
?"NO":"YES")){
_=s.split(",");
for(i=0;i<8;i++)l[i]=Double.valueOf(_[i]);
}
}
}