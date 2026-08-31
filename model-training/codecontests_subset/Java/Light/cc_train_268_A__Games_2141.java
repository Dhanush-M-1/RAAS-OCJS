import java.util.Scanner;
 
public class Games {
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        
        int n=sc.nextInt();
        
        int x[]=new int[n];
        int y[]=new int[n];
        for (int i=0;i<n;i++){      
      
           x[i]=sc.nextInt(); 
           y[i]=sc.nextInt();}
       
       for (int i=0;i<x.length;i++){     
       for (int j=0;j<y.length;j++){ 
            if (x[i]==y[j]){ 
                count++;
                
            
       }else{
                continue;
            }} }System.out.println(count);
    
}
}