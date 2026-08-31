

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Scanner x= new Scanner(System.in);

        
       int s=x.nextInt();
       int l=x.nextInt();

       int sum=0;
       int y=0;
      int [] a=new int [l];
       for (int i=0;i<s;i++){
           sum=0;
           
            y=x.nextInt();
            
            a[y-1]++;
       
       }
       
       for (int j=0;j<l;j++){
      for (int h=j+1;h<l;h++)  
      {
          sum +=a[j]*a[h];
      }   
    }
        System.out.println(sum);
    }
}