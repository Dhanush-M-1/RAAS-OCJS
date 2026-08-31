import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a1 = scan.nextInt();
    int b1 = scan.nextInt();
    int[] factoresa = {0,0,0};
    int[] factoresb = {0,0,0};
    int a = a1;
    int b = b1;
//5!!!!
    int contador = 0;
    while(a%5 == 0 && a!= 0){
      contador++;
      a = a/5;
    }
    factoresa[0] = contador;

    contador = 0;
    while(b%5 == 0 && b!= 0){
      contador++;
      b = b/5;
    }
    factoresb[0] = contador;
 //3!!!   
    contador = 0;
    while(a%3 == 0 && a!= 0){
      contador++;
      a = a/3;
    }
    factoresa[1] = contador;
   
    contador = 0;
    while(b%3 == 0 && b!= 0){
      contador++;
      b = b/3;
    }
    factoresb[1] = contador;
 //2!!!
     contador = 0;
    while(a%2 == 0 && a!= 0){
      contador++;
      a = a/2;
    }
    factoresa[2] = contador;

    contador = 0;
    while(b%2 == 0 && b!= 0){
      contador++;
      b = b/2;
    }
    factoresb[2] = contador;

    if(a == b){
      int print = Math.abs(factoresa[0] - factoresb[0]) + Math.abs(factoresa[1] - factoresb[1]) +
      Math.abs(factoresa[2] - factoresb[2]);
      System.out.println(print);

    }else{
      System.out.println(-1);

    }

  }
}