import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solucion{
    public static void main(String[] args){
        Scanner escaner = new Scanner( System.in );
        int largo = Integer.parseInt(escaner.nextLine());
        int veces = 0, aux = 0;
        String letras = escaner.nextLine();
        String respuesta =letras.substring(0,2);
        Set<String> pares = new HashSet< String >();
        for( int i = 0 ; i < largo - 1 ; i++ ){
            String subString = letras.substring(i,i+2);
            veces = 0;
            for( int j = i  ; j < largo-1 ; j++ ){
                if(!pares.contains( subString ) && subString.equals(letras.substring( j , j + 2 ))){
                    veces++;
                }
            }
            System.out.println();
            if(veces > aux ){
                respuesta = subString;
                aux = veces;
            }else if(veces == aux ){
                if(subString.charAt(0)<respuesta.charAt(0)){
                    respuesta = subString;
                }else if(subString.charAt(0) == respuesta.charAt(0) && respuesta.charAt(1) > subString.charAt(1)){
                    respuesta = subString;
                }
            }
            pares.add( subString );
        }
        System.out.println(respuesta);
    }
}
