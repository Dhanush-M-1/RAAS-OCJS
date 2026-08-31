    import java.util.*;
    public class Solution{
        
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int sum=0,sum1=0,i=0,j=1,k=0;
        int a=s.nextInt();
        int b=s.nextInt();
        if(a>b)
        {
            int temp=a;
            a=b;
            b=temp;
        }
        int diff=b-a;
        if(diff%2!=0){
            
            int d=(0+diff)/2;
            for( i=a;i<a+d;i++){
                sum=sum+(j);
                j++;
            }
            sum=sum*2;
            System.out.println(sum+(j));
        }
        else{
            sum=0;
            int d=(0+diff)/2;
            for(k=a;k<a+d;k++){
                sum=sum+(j);
                
                j++;
            }
            sum=sum*2;
            System.out.println(sum);
            
        }
        
        
    }
  
    
}
    