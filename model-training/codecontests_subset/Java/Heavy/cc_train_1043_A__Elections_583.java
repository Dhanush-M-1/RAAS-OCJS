
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anhnth37
 */
public class A_1043 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int number = input.nextInt();
            a.add(number);
            sum += number;
        }

        int max = Collections.max(a);

        while (max * n <= sum * 2) {
            max++;
        }

        System.out.println(max);
    }
}
