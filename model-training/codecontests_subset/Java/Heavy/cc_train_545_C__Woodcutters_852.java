import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gerasimov
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(inp.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> mas = new HashMap<>();
        st = new StringTokenizer(inp.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        mas.put(1, x);

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(inp.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            HashSet<Integer> hh = new HashSet<>();
            for (int j : mas.keySet()) {
                if (mas.get(j) >= x) {
                    hh.add(j);
                }
            }
            for (int j : hh) {
                mas.remove(j);
            }
            int mm = 0;
            HashMap<Integer, Integer> smas = new HashMap<>();
            for (int j : mas.keySet()) {
                int h = mas.get(j);
                if (h < x - y) {
                    if (mas.containsKey(j + 1)) {
                        if (mas.get(j + 1) > x) {
                            mas.replace(j + 1, x);
                        }
                    } else {
                        smas.put(j + 1, x);
                    }
                } else {
                    if (h < x) {
                        if (mas.containsKey(j + 1)) {
                            if (mas.get(j + 1) > x + y) {
                                mas.replace(j + 1, x + y);
                            }
                        } else {
                            smas.put(j + 1, x + y);
                        }
                    }
                }
                if (mas.get(j) < x) {
                    mas.replace(j, x);
                    if (mm < j) {
                        mm = j;
                    }
                }

            }
            
             mas.putAll(smas);
             
            hh = new HashSet<>();
            for (int j : mas.keySet()) {
                if (j < mm) {
                    hh.add(j);
                }
            }
            for (int j : hh) {
                mas.remove(j);
            }

        }
        int max = 0;
        for (int j : mas.keySet()) {
            if (max < j) {
                max = j;
            }
        }
        out.print(max);
        out.close();
    }

}