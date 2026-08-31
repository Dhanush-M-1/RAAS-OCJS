import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WizardsandDemonstration {
    static public void main(String args[]) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = cin.readLine()) != null) {
            String sa[] = line.split("\\s+");
            int n = Integer.valueOf(sa[0]);
            int x = Integer.valueOf(sa[1]);
            int y = Integer.valueOf(sa[2]);
            int tmp = (int) (Math.ceil(n * y / 100.) - x);
            if (tmp > 0)
                System.out.println(tmp);
            else
                System.out.println(0);
        }
    }
}