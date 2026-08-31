import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Compiler {
    public static void main(String[] args) {
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new InputStreamReader(System.in));
            String linea = null;
            int numErrores = Integer.parseInt(lector.readLine().trim());
            String[] errores = lector.readLine().split(" ");
            String[] sinErrores = null;
            Integer tmp = null;
            HashMap<String, Integer> mapa = null;
            while((linea = lector.readLine()) != null) {
                mapa = new HashMap<String, Integer>();
                sinErrores = linea.split(" ");
                for(String elem : sinErrores) {
                    tmp = mapa.get(elem);
                    mapa.put(elem, tmp == null? 1 : tmp + 1);
                }
                for(String elem : errores) {
                    tmp = mapa.get(elem);
                    if (tmp == null || tmp == 0) {
                        System.out.println(elem);
                        break;
                    }
                    else {
                        mapa.put(elem, tmp - 1);
                    }
                }
                errores = sinErrores;
            }
        }
        catch(Exception e) {e.printStackTrace();}
    }
}
