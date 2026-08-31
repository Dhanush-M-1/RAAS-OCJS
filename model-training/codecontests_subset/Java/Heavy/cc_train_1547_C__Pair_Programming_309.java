import java.util.*;

// https://codeforces.com/contest/1547/problem/C
public class problem_c {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
		    // Leo variables de entrada.
		    int k = sc.nextInt();
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    int[] array_n = new int[n];
		    int[] array_m = new int[m];
		    
		    for (int j = 0; j < n; j++) {
		        array_n[j] = sc.nextInt();
		    }
		    
		    for (int j = 0; j < m; j++) {
		        array_m[j] = sc.nextInt();
		    }
		    
		    // Creo array para guardar la secuencia válida.
		    int[] sequence = new int[200];
		    
		    // Itero hasta ver todos los elementos de los arrays (n y m).
		    int index_n = 0;
		    int index_m = 0;
		    int lines_total = k;
		    while (index_n < n || index_m < m) {
		        // Declaro variable para determinar si hubo un cambio en el archivo.
    		    boolean changed = false;

		        // Realizo cambios en el array_n.
		        while (index_n < n) {
		            int ni = array_n[index_n];
		            if (ni == 0) {
		                // Se agrega línea la archivo.
		                lines_total++;
		                changed = true;
		                sequence[index_n + index_m] = 0;
		            } else if (ni > lines_total) {
		                // No se puede ni modificar ni agregar líneas al archivo.
		                break;
		            } else {
		                // Sí se pudo modificar, se continúa con la siguiente acción.
		                changed = true;
		                sequence[index_n + index_m] = ni;
		            }
		            index_n++;
		        }
		        
		        // Realizo cambios en el array_m.
		        while (index_m < m) {
		            int mi = array_m[index_m];
		            if (mi == 0) {
		                // Se agrega línea la archivo.
		                lines_total++;
		                changed = true;
		                sequence[index_n + index_m] = 0;
		            } else if (mi > lines_total) {
		                // No se puede ni modificar ni agregar líneas al archivo.
		                break;
		            } else {
		                // Sí se pudo modificar, se continúa con la siguiente acción.
		                changed = true;
		                sequence[index_n + index_m] = mi;
		            }
		            index_m++;
		        }
		        
		        // Se verifica el flag changed para determina si se realizó algún cambio en el archivo.
		        if (!changed) {
		            lines_total = -1;
		            break;
		        }
		    }

		    // Imprimo resultado de secuencia.
		    if (lines_total != -1) {
		        for (int j = 0; j < index_n + index_m; j++) {
		            System.out.print(sequence[j] + " ");
		        }
		    } else {
		        System.out.print("-1");
		    }
		    System.out.print("\n");
		}
	}
}
