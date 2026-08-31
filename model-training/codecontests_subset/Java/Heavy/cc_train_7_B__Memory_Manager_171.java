import java.io.*;


public class p7b {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] te = in.readLine().split(" ");
        int t = Integer.parseInt(te[0]);
        int n = Integer.parseInt(te[1]);
        
        int[] memory = new int[n];
        boolean[] deleted = new boolean[1000000];
        int block = 1;
        for (int i = 0; i < t ; i++) {
            te = in.readLine().split(" ");
            if(te.length == 1) {
                int[] nMem = new int[n];
                int count = 0;
                for (int j = 0; j < memory.length; j++) {
                    if(memory[j] != 0) { 
                        nMem[count++] = memory[j];
                    }
                }
                System.arraycopy(nMem, 0, memory, 0, n);
                continue;
            }
            
            if(te[0].charAt(0) == 'a') {
                int size = Integer.parseInt(te[1]);
                boolean found = false;
                for (int j = 0; j <= memory.length-size; j++) {
                    boolean yes = true;
                    for (int k = j; k < j+size; k++) {
                        if(memory[k] != 0) {
                            yes = false;
                        }
                    }
                    if(yes) {
                        for (int k = j; k < j+size; k++) {
                            memory[k] = block;
                        }
                        System.out.println(block);
                        block++;
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("NULL");
                }
                continue;
            }
            
            int which = Integer.parseInt(te[1]);
            if(which >= block || which < 1 ) {
                System.out.println("ILLEGAL_ERASE_ARGUMENT");
                continue;
            }
            if(deleted[which]) {
                System.out.println("ILLEGAL_ERASE_ARGUMENT");
                continue;
            }
            deleted[which] = true;
            for (int j = 0; j < memory.length; j++) {
                if(memory[j] == which) {
                    memory[j] = 0 ;
                }
            }
        }
        
    }
}
/*
6 1
defragment
alloc 10
alloc 1
erase -1
erase 1
erase 1
*/