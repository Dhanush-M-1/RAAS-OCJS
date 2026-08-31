import java.util.Scanner;

public class Main{
	public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        long a,b,i,j;
		while(true){
        a = sc.nextInt();
        b = sc.nextInt();
            if(a==0&&b==0)break;
            
		for(i=0;i<a;i++){
            for(j=0;j<b;j++){
                if(i%2==0&&j%2==0)System.out.print("#");
                else if(i%2!=0&&(j-1)%2==0)System.out.print("#");
                else System.out.print(".");
        } 
         System.out.println();
      }
            System.out.println();
    }
  }
}
