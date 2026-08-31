import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] coordenadas = new int[n];
        int[] alturas = new int[n];
        for (int i = 0; i < n; i++) {
            coordenadas[i] = sc.nextInt();
            alturas[i] = sc.nextInt();
        }
        if(n==1 || n==2){
            System.out.println(n);
        }else {
            //Iniciamos cont en 2 ya que los arboles de los extremos se botan si o si
            int cont = 2;
            for (int i = 1; i + 1 < n; i++) {
                //Verifica si se puede botar a la izquierda
                if(coordenadas[i]-alturas[i]>coordenadas[i-1]){
                    cont++;
                }
                //Verifica si se puede botar a la derecha y de ser asi, se actualiza el punto de coordenada del arbol i
                else if(coordenadas[i]+alturas[i]<coordenadas[i+1]){
                    cont++;
                    coordenadas[i]+=alturas[i];
                }
            }
            System.out.println(cont);
        }
    }
}