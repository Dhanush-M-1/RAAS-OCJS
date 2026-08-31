import java.util.Scanner;
/**
 *
 * @author Artem
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int v0 = in.nextInt();
        int v1 = in.nextInt();
        int a = in.nextInt();
        int l = in.nextInt();
        int day = v0;
        for(int i = 0;i < 1000;i++){
            c = c - day;
            c = c + l;
            day = day + a;
            if(day > v1){
                day = v1;
            }
            if(c - l <= 0){
                c = i + 1;
                break;
                
            }
        }
        System.out.print(c);
    }
    
}
