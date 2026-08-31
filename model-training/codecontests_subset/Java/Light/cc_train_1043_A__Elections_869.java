//1043a
import java.io.*;
import java.util.*;
public class election{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
double arr[]=new double[n];
double sum=0,ans,g=arr[0];
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
sum+=arr[i];
if(arr[i]>g)
g=arr[i];
}
ans=Math.ceil((2*sum+1)/n);
if(ans<g) ans=g;
System.out.println((int)ans);
}
}