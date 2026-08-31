import java.util.Scanner;

public class NewYearCandles{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int numCandles = scan.nextInt();
        int reconstituteNum = scan.nextInt();
        
        int sum = numCandles;
        
        int spareCandleParts = numCandles;
        
        while(spareCandleParts >= reconstituteNum){
            sum += spareCandleParts / reconstituteNum;
            
            spareCandleParts = spareCandleParts % reconstituteNum + spareCandleParts / reconstituteNum;
        }
        
        
        System.out.println(sum);
    }
}