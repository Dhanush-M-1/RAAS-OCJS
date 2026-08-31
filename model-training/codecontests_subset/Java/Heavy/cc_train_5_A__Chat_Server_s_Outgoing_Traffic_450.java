/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author reza
 */
public class ChatServerOutgoingTraffic implements Runnable {

    private final Scanner in = new Scanner(System.in);
    private final PrintWriter out = new PrintWriter(System.out);
    HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        new Thread(new ChatServerOutgoingTraffic()).start();
    }

    @Override
    public void run() {
        int traffic = 0;
        do {
            String str = in.nextLine();

            if (str.startsWith("+")) {
                set.add(str.substring(1, str.length()));
            } else if (str.startsWith("-")) {
                set.remove(str.substring(1, str.length()));
            } else {
                String newStr = str.substring(str.indexOf(":") + 1, str.length());
                traffic += newStr.length() * set.size();
            }
        } while (in.hasNext());
        System.out.print(traffic);
    }
}
