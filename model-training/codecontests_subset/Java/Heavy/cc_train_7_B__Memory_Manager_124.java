import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MemoryManager {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int ms = in.nextInt();
        Mem mem = new Mem(ms);
        for (; c > 0; c--) {
            String com = in.next();
            if ("alloc".equals(com)) {
                mem.alloc(in.nextInt());
            } else if ("erase".equals(com)) {
                mem.erase(in.nextInt());
            } else {
                mem.defrag();
            }
            in.nextLine();
        }
    }

    static class Mem {
        boolean[] data;
        int id = 1;
        List<int[]> blocs = new ArrayList<int[]>();

        Mem(int size) {
            data = new boolean[size];
        }

        void defrag() {
            if (blocs.size() > 0) {
                blocs.get(0)[1] = 0;
                int sum = blocs.get(0)[2];
                for (int i = 1; i < blocs.size(); i++) {
                    blocs.get(i)[1] = blocs.get(i - 1)[1] + blocs.get(i - 1)[2];
                    sum = blocs.get(i)[1] + blocs.get(i)[2];
                }
                Arrays.fill(data, false);
                Arrays.fill(data, 0, sum, true);
            }
        }

        void alloc(int bl) {
            int fe = firstEmpty(0);
            while (fe != -1) {
                int length = getLength(fe, false);
                if (length >= bl) {
                    Arrays.fill(data, fe, fe + bl, true);
                    blocs.add(new int[] { id, fe, bl });
                    Collections.sort(blocs,new Cmp());
                    System.out.println(id++);
                    return;
                }
                fe = firstEmpty(fe+length);
            }
            System.out.println("NULL");
            return;

        }

        void erase(int id) {
            for (int[] bloc : blocs) {
                if (bloc[0] == id) {
                    Arrays.fill(data, bloc[1], bloc[1] + bloc[2], false);
                    blocs.remove(bloc);
                    return;
                }
            }
            System.out.println("ILLEGAL_ERASE_ARGUMENT");
        }

        int firstEmpty(int start) {
            for (int i = start; i < data.length; i++) {
                if (!data[i]) {
                    return i;
                }
            }
            return -1;
        }

        int getLength(int start, boolean kind) {
            int i = start;
            while (i < data.length && data[i] == kind) {
                i++;
            }
            return i - start;
        }
    }
    
    static class Cmp implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1]-o2[1];
        }
    }
}
