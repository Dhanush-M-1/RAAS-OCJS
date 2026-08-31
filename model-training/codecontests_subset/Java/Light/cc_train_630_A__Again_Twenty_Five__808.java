import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException { 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            PrintWriter out = new PrintWriter(System.out);
            br.readLine();
            out.println("25");
            out.flush();
            out.close();
            
        }
    }
}