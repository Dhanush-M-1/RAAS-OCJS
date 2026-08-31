
import java.util.*;
import java.lang.*;


public class Sam{  

        public static void main(String[] args){
          
          Scanner in = new Scanner(System.in);

          int t = in.nextInt();

          for(int tc=0 ;tc<t;tc++){

             int n = in.nextInt();
             in.nextLine();

             String[] ar = new String[n];

             for(int i=0 ;i<n;i++){
             	ar[i] = in.nextLine();
             }

            String input = ar[0].charAt(1)+"" + ar[1].charAt(0) +""+ ar[n-1].charAt(n-2) +""+ ar[n-2].charAt(n-1) ;

            String res1 = "0011";
            String res2 = "1100" ;
            String res = "";
            
           

            int count1=0 ;
            int count2=0 ;
            for(int i=0 ;i<4;i++){
            	if(input.charAt(i)!=res1.charAt(i))count1++ ;
            	if(input.charAt(i)!=res2.charAt(i))count2++;            	
            }
            int count = count1<=count2?count1 : count2 ;
            if(count1<=count2)res = res1 ;
            else res = res2 ;


            if(count==0)System.out.println(0);
            else{
            	System.out.println(count);

            	if(res.charAt(0)!=input.charAt(0))System.out.println("1 2");
            	 if(res.charAt(1)!=input.charAt(1))System.out.println("2 1");
            	if(res.charAt(2)!=input.charAt(2))System.out.println((n)+" "+(n-1));
            	if(res.charAt(3)!=input.charAt(3))System.out.println((n-1)+" "+(n)); 

            }
           


        }
                                 
     }
  }    


  



