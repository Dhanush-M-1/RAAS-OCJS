import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        String line = scanner.nextLine();
        String[] people= line.split(" ");
        hashSet.add(people[0]);
        hashSet.add(people[1]);
        line = scanner.nextLine();
        int n = Integer.valueOf(line);
        System.out.println(people[0]+" "+people[1]);
        for(int i=0;i<n;i++){
            line = scanner.nextLine();
            people= line.split(" ");
            hashSet.remove(people[0]);
            System.out.print(hashSet.iterator().next()+" ");
            hashSet.add(people[1]);
            System.out.println(people[1]);
        }
    }
}