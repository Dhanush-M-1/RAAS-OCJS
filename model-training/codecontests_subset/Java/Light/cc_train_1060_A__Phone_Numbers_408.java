//1060A
import java.io.*;
import java.util.*;
public class phone{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
String s=sc.next();
int c=0;
for(int i=0;i<n;i++){
if(s.charAt(i)=='8') c++;}
if(c>n/11) System.out.println(n/11);
if(c<=n/11) System.out.println(c);
}}