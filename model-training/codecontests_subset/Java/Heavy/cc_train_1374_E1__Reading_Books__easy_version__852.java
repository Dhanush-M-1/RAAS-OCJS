import java.util.*;
import java.io.*;

public class e2 {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int toRead = sc.nextInt();
        int mustLike = sc.nextInt();

        long ans = 987654321987654321l;
        int bothNum = 0;
        int aliceNum = 0;
        int bobNum = 0;
        int noneNum = 0;

        ArrayList<Book> alice = new ArrayList<Book>();
        ArrayList<Book> bob = new ArrayList<Book>();
        ArrayList<Book> both = new ArrayList<Book>();
        ArrayList<Book> none = new ArrayList<Book>();

        for (int i = 1; i <= n; i++) {
            int time = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a + b == 2)
                both.add(new Book(i, time));
            else if (a == 1)
                alice.add(new Book(i, time));
            else if (b == 1)
                bob.add(new Book(i, time));
            else
                none.add(new Book(i, time));
        }

        Collections.sort(alice);
        Collections.sort(bob);
        Collections.sort(none);
        Collections.sort(both);

        int bothCur, aliceCur, bobCur, noneCur;

        long curTime = 0;
        int i;
        for (bothCur = 0; bothCur < toRead && bothCur < both.size(); bothCur++)
            curTime += both.get(bothCur).time;
        for (aliceCur = 0; aliceCur + bothCur < mustLike && aliceCur < alice.size();
                aliceCur++)
            curTime += alice.get(aliceCur).time;
        for (bobCur = 0; bobCur + bothCur < mustLike && bobCur < bob.size();
                bobCur++)
            curTime += bob.get(bobCur).time;
        noneCur = 0;
        if (aliceCur + bothCur < mustLike || bobCur + bothCur < mustLike) {
            System.out.println(-1);
            return;
        }
        while (bothCur + aliceCur + bobCur + noneCur < toRead) {
            if (aliceCur < alice.size() && 
                    (bobCur == bob.size() || 
                     bob.get(bobCur).time >= alice.get(aliceCur).time) &&
                    (noneCur == none.size() ||
                     none.get(noneCur).time >= alice.get(aliceCur).time)) {
                curTime += alice.get(aliceCur++).time;
            } else if (bobCur < bob.size() &&
                    (noneCur == none.size() || 
                     none.get(noneCur).time >= bob.get(bobCur).time)) {
                curTime += bob.get(bobCur++).time;
            } else {
                curTime += none.get(noneCur++).time;
            }
        }
        if (curTime < ans) {
            ans = curTime;
            bothNum = bothCur;
            aliceNum = aliceCur;
            bobNum = bobCur;
            noneNum = noneCur;
        }
        while (bothCur > 0) {
            curTime -= both.get(--bothCur).time;
            while (aliceCur < alice.size() && bothCur + aliceCur < mustLike) {
                curTime += alice.get(aliceCur++).time;
            }
            while (bobCur < bob.size() && bothCur + bobCur < mustLike) {
                curTime += bob.get(bobCur++).time;
            }
            while (bothCur + bobCur + aliceCur + noneCur < toRead) {
                if (aliceCur < alice.size() && 
                        (bobCur == bob.size() || 
                         bob.get(bobCur).time >= alice.get(aliceCur).time) &&
                        (noneCur == none.size() ||
                         none.get(noneCur).time >= alice.get(aliceCur).time)) {
                    curTime += alice.get(aliceCur++).time;
                } else if (bobCur < bob.size() &&
                        (noneCur == none.size() || 
                         none.get(noneCur).time >= bob.get(bobCur).time)) {
                    curTime += bob.get(bobCur++).time;
                } else if (noneCur < none.size()){
                    curTime += none.get(noneCur++).time;
                } else {
                    break;
                }
            }
            while (bothCur + bobCur + aliceCur + noneCur > toRead) {
                if (aliceCur != 0 && aliceCur + bothCur > mustLike && 
                        (bobCur == 0 || 
                         bob.get(bobCur - 1).time <= alice.get(aliceCur - 1).time ||
                         bobCur + bothCur == mustLike) &&
                        (noneCur == 0 ||
                         none.get(noneCur - 1).time <= alice.get(aliceCur - 1).time)) {
                    curTime -= alice.get(--aliceCur).time;
                } else if (bobCur != 0 && bobCur + bothCur > mustLike &&
                        (noneCur == 0 || 
                         none.get(noneCur - 1).time >= bob.get(bobCur - 1).time)) {
                    curTime -= bob.get(--bobCur).time;
                } else if (noneCur != 0) {
                    curTime -= none.get(--noneCur).time;
                } else {
                    break;
                }
            }
            if (bothCur + bobCur + aliceCur + noneCur == toRead &&
                    curTime < ans &&
                    bobCur + bothCur >= mustLike &&
                    aliceCur + bothCur >= mustLike) {
                ans = curTime;
                bothNum = bothCur;
                aliceNum = aliceCur;
                bobNum = bobCur;
                noneNum = noneCur;
            }
        }


        


        
        PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(System.out)));

        if (bothNum + aliceNum + bobNum + noneNum != toRead) {
            out.println(-1);
        } else {
            out.println(ans);
            for (i = 0; i < bothNum; i++)
                out.print(both.get(i).index + " ");
            for (i = 0; i < aliceNum; i++)
                out.print(alice.get(i).index + " ");
            for (i = 0; i < bobNum; i++)
                out.print(bob.get(i).index + " ");
            for (i = 0; i < noneNum; i++)
                out.print(none.get(i).index + " ");
            out.println();
        }
        
        out.close();
    }

    public static class Book implements Comparable<Book> {
        int index, time;
        Book(int i, int t) {
            index = i;
            time = t;
        }

        public int compareTo(Book o) {
            return time - o.time;
        }   
    }
}
