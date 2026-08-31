import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lectura = new Scanner (System.in);
        int total = lectura.nextInt(), primer = lectura.nextInt(), max = lectura.nextInt(), a = lectura.nextInt(), l = lectura.nextInt(), cont = 0;
        
        while(total > 0){
            total -= primer;
            
            if(primer + a <= max)
                primer += a;
            else 
                primer = max;
            
            if(cont != 0)
                total += l;
            
            cont++;
        }
        
        System.out.println(cont);
        
    }
    
}
