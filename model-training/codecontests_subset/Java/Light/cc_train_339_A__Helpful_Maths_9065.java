import java.util.*;
 
 
public class main {
 
   public void sort(char arr[])
   {
    for(int i = 0 ; i<arr.length-1;i+=2)
    {
     int min_ind=i;
     for(int j=i+2;j<arr.length;j+=2)
     {
      if(arr[min_ind]>arr[j])
          min_ind=j;
     }
     char temp = arr[min_ind];
     arr[min_ind]=arr[i];
     arr[i]=temp;
    }
   }
   
    public static void main(String[] args) {
       
       Scanner s= new Scanner(System.in);
       String x= s.next();
       char arr[] = x.toCharArray();
       main a = new main();
       a.sort(arr);
         int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]);
       
    }
    
}