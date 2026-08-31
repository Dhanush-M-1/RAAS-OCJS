import java.util.Scanner;
public class cvb{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
int a=in.nextInt();
int b=in.nextInt();
int f1=a,f2=0,r=0;
for(int i=1;i>0;i++){
f1=f1+(a/b);
f2=f2+(a%b);
a=a/b;
if(a==0){break;} }
for(int i=1;i>0;i++){
f1=f1+(f2/b);
r=r+(f2%b);
f2=f2/b;
if(f2==0){break;} }
System.out.print(f1+(r/b));
}}