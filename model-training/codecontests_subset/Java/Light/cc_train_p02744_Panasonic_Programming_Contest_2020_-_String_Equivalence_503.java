//AtCoder
//パナソニックプログラミングコンテスト2020
//D問題
//https://atcoder.jp/contests/panasonic2020/tasks/panasonic2020_d

//input
//2
//output
//aa
//ab


//input
//4
//output
//aaaa
//aaab
//aaba
//aabb
//aabc
//abaa
//abab
//abac
//abba
//abbb
//abbc
//abca
//abcb
//abcc
//abcd


import java.util.*;

public class Main {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    public static void main (String[] args) {
        new Main().run();
    }

    void run() {
        dfs("", 'a');
    }

    void dfs(String s, char c) {
        if (s.length()==n) {
            System.out.println(s);
        } else {
            for (char ch='a'; ch<=c; ch++) {
                dfs(s+ch, (ch==c) ? (char)(c+1) : c);
            }
        }
    }

}