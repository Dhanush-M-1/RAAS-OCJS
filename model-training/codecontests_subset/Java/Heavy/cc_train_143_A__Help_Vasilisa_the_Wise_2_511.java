import java.util.*;
public class GemStone {
static int r1;
static int r2;
static int c1;
static int c2;
static int d1;
static int d2;
public static boolean solver(int i,int j,int k,int l){
//System.out.println(i+" "+j+" "+k+" "+l);
if(i+j==r1&&i+k==c1&&i+l==d1&&j+l==c2&&k+l==r2&&k+j==d2)
return true;
else
return false;
}
public static void main(String []args){
Scanner in=new Scanner(System.in);
r1=in.nextInt();
r2=in.nextInt();
c1=in.nextInt();
c2=in.nextInt();
d1=in.nextInt();
d2=in.nextInt();
boolean flag=false;
for(int i=1;i<=9;i++){
for(int j=1;j<=9;j++){
if(i==j)continue;
for(int k=1;k<=9;k++){
if(k==i||k==j)continue;
for(int l=1;l<=9;l++){
if(l==i||l==j||l==k)continue;
flag=solver(i,j,k,l);
if(flag){
r1=i;
r2=j;
c1=k;
c2=l;
break;
}
}
if(flag)break;
}
if(flag)break;
}
if(flag)break;
}
if(flag){
System.out.println(r1+" "+r2);
System.out.print(c1+" "+c2);
}
else
System.out.print("-1");
}
}