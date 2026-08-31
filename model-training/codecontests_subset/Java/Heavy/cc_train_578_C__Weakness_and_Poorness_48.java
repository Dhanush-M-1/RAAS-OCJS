import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static double maxSum(double arr[],double val)
    {
        double sum=0;
        double max=Double.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i]-val;
            if(max<sum)
                max=sum;
            if(sum<0)
                sum=0;
        }
        return max;
    }
    public static double minSum(double arr[],double val)
    {
        double sum=0;
        double min=Double.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i]-val;
            if(min>sum)
                min=sum;
            if(sum>0)
                sum=0;
        }
        return Math.abs(min);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double arr[]=new double[n];
        
        double low=Double.MAX_VALUE;
        double high=Double.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextDouble();
            if(arr[i]>high)
                high=arr[i];
            if(arr[i]<low)
                low=arr[i];
        }
        int count=0;
        while(low<high&& count<300)
        {
            Double mid1=low+(high-low)/3;
            Double mid2=high-(high-low)/3;
            Double cost1=Math.max(minSum(arr,mid1),maxSum(arr,mid1));
            Double cost2=Math.max(minSum(arr,mid2),maxSum(arr,mid2));
            if(cost1>cost2)
                low=mid1;
            else high=mid2;
            count++;
        }
        System.out.println(Math.max(minSum(arr,low),maxSum(arr,low)));
        
        
    }
}