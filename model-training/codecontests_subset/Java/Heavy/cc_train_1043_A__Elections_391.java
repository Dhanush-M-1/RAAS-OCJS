import java.util.*;
public class Main{

     public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] teamB=new int[n];
        int sumB=0;
        for(int i=0;i<n;i++){
            teamB[i]=in.nextInt();
            sumB=sumB+teamB[i];
            
        }
        int max= teamB[0];
        for(int i=1;i<n;i++){
            if(max<teamB[i]){
                max=teamB[i];
            }
        }
        int k=max;
        int sumA=(n*k)-sumB;
        while(sumA<=sumB){
            k++;
            sumA=(n*k)-sumB;
        }
        System.out.println(k);
        
     }
}

				 	 		     		   	      				