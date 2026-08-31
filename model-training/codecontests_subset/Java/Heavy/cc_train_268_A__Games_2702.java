import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    ArrayList<Integer> lista_casa=new ArrayList<Integer>();
    ArrayList<Integer> lista_visita=new ArrayList<Integer>();
    
    int aux=0;
    int aux_2=0;
    int numero_de_equipos;
    int casa;
    int visita;
    int objetivo = 0;
    
    numero_de_equipos=scan.nextInt();
    
    while(aux!=numero_de_equipos){
    casa=scan.nextInt();
    lista_casa.add(casa);
    visita=scan.nextInt();
    lista_visita.add(visita);
    aux++;
    }
    
    int tamano1 = lista_visita.size();
    int tamano2 = lista_casa.size();
    
    aux=1;
    aux_2=1;
    
    while(true){
    if(tamano2-aux_2==-1){
    break;
    }
        
    if(lista_casa.get(tamano2-aux_2).equals(lista_visita.get(tamano1-aux))){
    objetivo++;
    }
    
    
    if(tamano1-aux==0){
    aux_2++;
    aux=0;}

    aux++;
    }
    
    
    System.out.println(objetivo);
    
    
    
}
}