import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeforcesRound338A {
public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int sum = 0;
    int a [][] = new int [n][];
    for (int i = 0; i < a.length; i++) {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        a [i] = new int [size];
        for (int j = 0; j < size; j++) {
            a[i][j] = Integer.parseInt(st.nextToken()); 
        }
    }

    boolean found = false;
    for (int i = 1; i <= m; i++) {
            found = false;
        for (int j = 0; j < a.length; j++) {
            for (int k = 0; k < a[j].length; k++) {
                if(a[j][k] == i){
                    found = true;
                    break;
                    }
            }
            if(found)
                break;
        }
        if(!found)
            break;
    }
    if(!found)
        System.out.println("NO");
    else
        System.out.println("YES");
    
}
}
