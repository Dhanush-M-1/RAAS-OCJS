import java.util.*;

public class Main {

    public static class par implements Comparable<par>{
        int x,altura;
        public par(int x, int a) {
            this.x = x;
            this.altura = a;
        }
        @Override
        public int compareTo(par a){
            return x > a.x ? 1 : -1;
        }

    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<par> arboles = new ArrayList<par>();
        while ( t-- > 0) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            arboles.add(new par(x, a));
        }
        Collections.sort(arboles);
        int ocupado = Integer.MIN_VALUE;
        int resp = 0;
        for (int i = 0; i < arboles.size(); i++) {
            par arbol = arboles.get(i);
            int x = arbol.x;
            int alt = arbol.altura;
            //intento talar a la izq
            if ( x - alt > ocupado ) {
                //puedo talar izq
                ocupado = x;
                resp++;
            } else {
                //intento talar a la der
                int der = (i == arboles.size() - 1) ? Integer.MAX_VALUE : arboles.get(i + 1).x;//la siguiente pos ocupada a la der
                if (x + alt < der) {
                    //puedo talar
                    ocupado = x + alt;
                    resp++;
                } else {
                    //no puedo talar ni derecha ni izq
                    ocupado = x;
                }
            }
        }
        System.out.println(resp);
    }
}