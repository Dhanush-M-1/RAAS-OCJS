/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author Reza
 */
public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(strt.nextToken());
        int m = Integer.parseInt(strt.nextToken());

        StringTokenizer wstt = new StringTokenizer(br.readLine());
        int wary[] = new int[n];
        for (int i = 0; i < n; i++) {
            int w = Integer.parseInt(wstt.nextToken());
            wary[i] = w;
        }

        TreeSet<Integer> ts = new TreeSet<Integer>();
        ArrayList<Integer> oral = new ArrayList<Integer>();
        StringTokenizer stt1 = new StringTokenizer(br.readLine());
        int mary[] = new int[m];
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(stt1.nextToken()) - 1;
            mary[i] = x;
            if (!ts.contains(x)) {
                ts.add(x);
                oral.add(x);
            }
        }
        Stack<Integer> mst = new Stack<Integer>();
        for (int i = oral.size() - 1; i >= 0; i--) {
            mst.add(oral.get(i));
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> hst = new Stack<Integer>();
            int book = mary[i];
            int sbook;
            while ((sbook = mst.pop()) != book) {
                sum += wary[sbook];
                hst.add(sbook);
            }
            while (!hst.isEmpty()) {
                mst.add(hst.pop());
            }
            mst.add(book);
        }
        System.out.println(sum);

    }
}
