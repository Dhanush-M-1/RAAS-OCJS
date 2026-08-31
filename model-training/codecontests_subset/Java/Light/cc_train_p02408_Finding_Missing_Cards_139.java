import java.util.Scanner;
class Main{
public static void main(String[] args){
Scanner scan=new Scanner(System.in);
int a=scan.nextInt();
int[][] c=new int[4][14];
for(int x=0;x<4;x++){
for(int y=1;y<14;y++){
c[x][y]=0;
}
}
for(int b=0;b<a;b++){
String d=scan.next();
int e=scan.nextInt();
if("S".equals(d))
c[0][e]=1;
if("H".equals(d))
c[1][e]=1;
if("C".equals(d))
c[2][e]=1;
if("D".equals(d))
c[3][e]=1;
}
for(int x=0;x<4;x++){
for(int y=1;y<14;y++){
if(c[x][y]==0){
if(x==0)
System.out.print("S ");
if(x==1)
System.out.print("H ");
if(x==2)
System.out.print("C ");
if(x==3)
System.out.print("D ");
System.out.println(y);

}
}
}
}
}