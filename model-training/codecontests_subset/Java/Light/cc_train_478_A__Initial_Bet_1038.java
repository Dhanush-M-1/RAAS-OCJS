import java.util.Scanner;

public  class Solution {
    Scanner input;

    public Solution(Scanner input) {
        this.input = input;
    }

    int findB() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += input.nextInt();
        }
        int b = sum / 5;
        if (b * 5 == sum && b > 0) {
            return b;
        }
        return -1;
    }

    void solve() {
        System.out.println(findB());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sl = new Solution(sc);
        sl.solve();
    }
}
