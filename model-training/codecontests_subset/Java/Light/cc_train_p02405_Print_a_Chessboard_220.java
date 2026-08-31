import java.util.Scanner;
 public class Main{

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       while(true){
           int H = sc.nextInt();
           int W= sc.nextInt();
        for( int i = 0; i<H; i++ ){
            for( int n = 0; n<W; n++ ){
                if((n+i)%2==1){
                 System.out.print(".");
                }else{
                 System.out.print("#");
                }
            }
        System.out.println();
       }
        if(H==0&&W==0)break;   
         System.out.println();

       }
	}
 }
