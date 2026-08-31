import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String cadena = leer.next(),aux = "";
        int contador= 0;
        int n [] = new int[cadena.length()/2+1];
        for (int i = 0; i < cadena.length(); i++) {
            if(cadena.charAt(i) != '+'){
                n[contador] = Integer.parseInt("" +cadena.charAt(i));
                contador++;
            }
        }        
        Arrays.sort(n);
        for (int i = 0; i < cadena.length()/2+1; i++) {
            if(i != cadena.length()/2){
                aux = aux + n[i] + "+";
            }else{
                aux = aux + n[i];
            }
        }
        System.out.println(aux);
     }
   }
   
