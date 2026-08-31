import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      ArrayList<Integer> even=new ArrayList<Integer>();
       ArrayList<Integer> odd=new ArrayList<Integer>();
      int n=sc.nextInt();
      int[] arr=new int[n];
      for(int i=0;i<n;i++)
      {arr[i]=sc.nextInt();
      }
    Arrays.sort(arr);
    for(int i=0;i<n;i++)
    {
        if(arr[i]%2==0)
      even.add(arr[i]);
      else
      odd.add(arr[i]);
    }
    if(even.size()==odd.size())
    System.out.println(0);
    else if(even.size()==odd.size()+1||odd.size()==even.size()+1)
    System.out.println(0);
    else
    {   int s=0;
        if(odd.size()>even.size())
        {
            int k=odd.size()-even.size();
            for(int i=k-2;i>=0;i--)
            s=s+odd.get(i);
        }
        else
        {
            int k=even.size()-odd.size();
            for(int i=k-2;i>=0;i--)
            s=s+even.get(i);
        }
        System.out.println(s);
    }
    }
}