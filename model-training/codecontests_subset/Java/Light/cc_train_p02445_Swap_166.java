import java.util.*;
// import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();

        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int tmp = sc.nextInt();
            array.add(tmp);
        }

        int num_query = sc.nextInt();

        for (int i = 0; i < num_query; i++) {
            int b = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();

            List<Integer> left = new ArrayList<>(array.subList(b, e));

            for (int j = 0; j < left.size(); j++) {
                array.set(j + b, array.get(j + t));
                array.set(j + t, left.get(j));
            }
        }

        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1) sb.append(' ');
        }

        System.out.println(sb);
        
        sc.close();
    }
}

