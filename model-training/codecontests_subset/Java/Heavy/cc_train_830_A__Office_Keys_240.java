import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CF830A {
    static int minTime = Integer.MAX_VALUE;
    static int [] people;
    static int n;
    static int p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        int k = Integer.parseInt(s.nextToken());
        p = Integer.parseInt(s.nextToken());
        people = new int[n];
        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(s.nextToken());
        }
        s = new StringTokenizer(br.readLine());
        int [] keys = new int[k];
        for (int i = 0; i < k; i++) {
            keys[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(keys);
        Arrays.sort(people);
        for (int i = 0; i < k && i + n - 1 < k; i++) {
            int maxTime = 0;
            for (int j = 0; j < n; j++) {
                maxTime = Math.max(maxTime,calcDist(people[j],keys[i+j]));
            }
            minTime = Math.min(minTime,maxTime);
        }
        //findMinTime(keys,0,0);
        System.out.println(minTime);
    }
    public static void findMinTime (TreeSet<Integer> keys, int pos, int maxTime) {
        if (pos == n) {
            minTime = Math.min(maxTime,minTime);
            return;
        }
        int [] keysArr = new int[keys.size() - ((n-1)-pos)];
        int index = 0;
        for (int num: keys) {
            if (index >= keysArr.length) break;
            keysArr[index] = num;
            index++;
        }
        for (int key: keysArr) {
            keys.remove(key);
            if ((key >= people[pos] && key <= p) || (key <= people[pos] && key >= p)) {
                findMinTime(keys,pos+1,Math.max(maxTime,Math.abs(people[pos]-p)));
            }
            else {
                findMinTime(keys, pos + 1, Math.max(Math.min(Math.abs(people[pos] - key), Math.abs(p - key)) * 2 + Math.abs(people[pos] - p), maxTime));
            }
            keys.add(key);
        }
    }
    public static int calcDist(int personLocation, int keyLocation) {
        if ((keyLocation >= personLocation && keyLocation <= p) || (keyLocation <= personLocation && keyLocation >= p)) {
            return Math.abs(personLocation-p);
        }
        else {
            return Math.min(Math.abs(personLocation - keyLocation), Math.abs(p - keyLocation)) * 2 + Math.abs(personLocation - p);
        }
    }
}