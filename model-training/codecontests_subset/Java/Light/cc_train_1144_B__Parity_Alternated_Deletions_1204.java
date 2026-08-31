
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author quan.vuhong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                even.add(a[i]);
            } else {
                odd.add(a[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);

        int sum = 0;
        if (even.size() > odd.size() + 1) {
            for (int i = 0; i < even.size() - odd.size() - 1; i++) {
                sum += even.get(i);
            }
        } else if (odd.size() > even.size() + 1) {
            for (int i = 0; i < odd.size() - even.size() - 1; i++) {
                sum += odd.get(i);
            }
        }
        System.out.println(sum);
    }

}
