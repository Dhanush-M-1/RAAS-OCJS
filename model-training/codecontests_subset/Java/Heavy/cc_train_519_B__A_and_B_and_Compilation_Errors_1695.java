import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class ABCompilation{
  public static void main(String[] args){
    BufferedReader bF = new BufferedReader(new InputStreamReader(System.in));
    try{
      StringTokenizer tS = new StringTokenizer(bF.readLine());
      int n = Integer.parseInt(tS.nextToken());
      tS = new StringTokenizer(bF.readLine());
      StringTokenizer tS2 = new StringTokenizer(bF.readLine());
      StringTokenizer tS3 = new StringTokenizer(bF.readLine());
      ArrayList<Integer> lista1 = new ArrayList<Integer>();
      ArrayList<Integer> lista2 = new ArrayList<Integer>();
      ArrayList<Integer> lista3 = new ArrayList<Integer>();
      for (int i=0; i<n; i++){
        lista1.add(Integer.parseInt(tS.nextToken()));
        if (i < n-1){
          lista2.add(Integer.parseInt(tS2.nextToken()));
        }
        if (i < n-2){
          lista3.add(Integer.parseInt(tS3.nextToken()));
        }
      }
      Collections.sort(lista1);
      Collections.sort(lista2);
      Collections.sort(lista3);
      int cambio = -1, cambio2 = -1;
      boolean aux = false, aux2 = false;
      for (int i=0; i<n-1 && !(aux && aux2); i++){
        if (lista1.get(i).intValue() != lista2.get(i).intValue() && !aux){
          cambio = lista1.get(i);
          aux = true;
        }
        if (i < n-2){
          if (lista2.get(i).intValue() != lista3.get(i).intValue() && !aux2){
            cambio2 = lista2.get(i);
            aux2 = true;
          }
        }
      }
      if (cambio == -1){
        cambio = lista1.get(lista1.size()-1);
      }
      if (cambio2 == -1){
        cambio2 = lista2.get(lista2.size()-1);
      }
      System.out.println(cambio);
      System.out.println(cambio2);
    }catch(IOException ioE){
    
    }
  }
}