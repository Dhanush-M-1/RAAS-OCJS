import java.util.HashSet;
import java.util.Scanner;

public class problemA {    
    public static void main (String[] args)  
    { 
        Scanner scan=new Scanner(System.in);
        
         long t=scan.nextLong();
                            
                        while(t>0){
			 
                         int n=scan.nextInt();
                         
                         int m=scan.nextInt();
                         
                         int[] array1=new int[n];
                         HashSet<Integer> set=new HashSet<Integer>();
                         int [] array2=new int[m];
                         int out=0;
                         for(int i=0;i<array1.length;i++){
                             int number=scan.nextInt();
                             array1[i]=number;
                             set.add(number);
                         }
                         for(int i=0;i<array2.length;i++){
                             int number=scan.nextInt();
                             if(set.contains(number)==true)
                             {
                                 out=number;
                             }
                         }
                         
                         if(out!=0){
                             System.out.println("YES");
                             System.out.println(1+" "+out);
                         }
                         else{
                             System.out.println("NO");
                         }

                         
                         
                        t--;
		}
          
    } 
                
         }      
