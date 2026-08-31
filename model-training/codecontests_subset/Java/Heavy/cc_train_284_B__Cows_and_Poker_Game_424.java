import java.util.*;
public class Main{
    
    static int calcular (String game, int n){
        int cont=0;
        boolean in=false;
       for(int i=0; i<n; i++){
               if(game.charAt(i)=='A'&&!in){
                   cont++;
                }
                if(game.charAt(i)=='I'&&in){
                   cont=0;
                   break;
                }
                if(game.charAt(i)=='I'&&!in){
                   cont=1;
                   in=true;
                }
               
        }
        return cont;
    }
   public static void main(String []  args){
       Scanner sc = new Scanner (System.in);
       int n=sc.nextInt();
       String game =sc.next();
        System.out.println(calcular (game,n));
    }
    
}
