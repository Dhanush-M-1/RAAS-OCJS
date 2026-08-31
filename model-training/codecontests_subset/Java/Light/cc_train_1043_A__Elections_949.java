import java.util.*;
public class MyClass {
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    int i,max=0,sum=0;
    for(i=0;i<n;i++)
    {
    arr[i]=sc.nextInt();
    if(arr[i]>max)
    max=arr[i];
    sum=sum+arr[i];
    }
    sum=sum*2;
    sum=sum+ n;
    sum=sum/n;
    System.out.print(Math.max(sum,max));
    }}
  
    
    