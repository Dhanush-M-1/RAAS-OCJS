import java.util.*;
public class Cola {
static int ans=0;
static int n;
static void testCheck(int a,int b,int c){
int temp=n-a-2*b;
if(temp%4==0 && temp>=0 && temp/4<=c)
ans++;
}
public static void main(String [] args){
Scanner in=new Scanner(System.in);
n=in.nextInt();
n=2*n;
int a=in.nextInt();
int b=in.nextInt();
int c=in.nextInt();
for(int i=0;i<=a;i++){
for(int j=0;j<=b;j++){
testCheck(i,j,c);
}
}
System.out.println(ans);
}
}