import java.io.*;
import java.util.*;

public class CodeforcesRound351VKCup2016Round3Div2EditionProblemD {


        static class Problem {


                Scanner reader;
                PrintWriter writer;

                Problem() {


                        reader = new Scanner(System.in);
                        writer = new PrintWriter(System.out);


                }

                void Run() {


                        Solution();


                        writer.close();


                }

                void Solution() {


                        int n = reader.nextInt(), Equal = 0, k = reader.nextInt(), a = reader.nextInt(), b = reader.nextInt(), c = reader.nextInt(), d = reader.nextInt();
                        ArrayList<Integer> roadAB = new ArrayList(), roadCD = new ArrayList();


                        if (n == 4) {
                                writer.print(-1);
                                return;
                        }


                        roadAB.add(a);
                        roadAB.add(c);
                        roadCD.add(c);
                        roadCD.add(a);


                        for (int i = 1; i <= n; i++)
                                if (i != a && i != b && i != c && i != d) {
                                        roadAB.add(i);
                                        roadCD.add(i);
                                }


                        roadAB.add(d);
                        roadAB.add(b);
                        roadCD.add(b);
                        roadCD.add(d);


                        for (int i = 0; i < roadCD.size() - 1; i++)
                                if (((roadAB.get(i) == roadCD.get(i) && roadAB.get(i + 1) == roadCD.get(i + 1))) ||(roadAB.get(i) == roadCD.get(i + 1) && roadAB.get(i + 1) == roadCD.get(i)))
                                        Equal++;


                        if (n == 4 || (n - 1) + 2 > k) {
                                writer.print(-1);
                                return;
                        }


                        for (int i = 0; i < n; i++)
                                writer.print(roadAB.get(i) + " ");


                        writer.println();


                        for (int i = 0; i < n; i++)
                                writer.print(roadCD.get(i) + " ");


                }


        }

        public static void main(String args[]) {


                Problem D = new Problem();


                D.Run();


        }


}
