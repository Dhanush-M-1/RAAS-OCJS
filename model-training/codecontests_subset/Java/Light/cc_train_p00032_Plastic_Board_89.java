import java.math.BigDecimal;
import java.util.Scanner;
 
public class Main {
    static int cntRectangle=0;
    static int cntDia=0;
    public static void main(String[] args) {
        try{
        Scanner scanline = new Scanner (System.in);
        while(scanline.hasNext()){
            String lines = scanline.nextLine();
            Scanner scan = new Scanner(lines);
            scan.useDelimiter(",");
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            if(a*a+b*b==c*c){
                cntRectangle+=1;
            }if(a==b){
                cntDia+=1;
            }
        }
        System.out.printf("%d\n",cntRectangle);
        System.out.printf("%d\n",cntDia);
    }
    catch(java.util.NoSuchElementException f){
        System.out.println("Input Valid Values");
    }
    }
 
}