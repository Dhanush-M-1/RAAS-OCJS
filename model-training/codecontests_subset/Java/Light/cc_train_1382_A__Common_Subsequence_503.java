import java.util.*;
public class cf658div2A {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
for(int j=1;j<=t;j++)
{int n=sc.nextInt();
int m=sc.nextInt();
int arr1[]=new int[n];
int arr2[]=new int[m];
int pos[]=new int[1001];int f=0;int k=0;
for(int i=0;i<n;i++)
{arr1[i]=sc.nextInt();pos[arr1[i]]++;}
for(int i=0;i<m;i++)
{arr2[i]=sc.nextInt();
if(pos[arr2[i]]>0)
{f=1;k=arr2[i];}}
if(f==1)
{System.out.println("YES");
System.out.println(1+" "+k); }
else
System.out.println("NO");}
sc.close();   
}    
}