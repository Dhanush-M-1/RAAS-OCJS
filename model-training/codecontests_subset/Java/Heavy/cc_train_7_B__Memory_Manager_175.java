
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author duc
 */
public class Main {

    static class MemoryManager {

        int _memory[];
        int _size;
        int _id;

        MemoryManager(int size) {
            _size = size;
            _memory = new int[_size];
            _id = 0;
        }

        boolean isFree(int i, int j) {
            for (int k = i; k <= j; ++k) {
                if (_memory[k] != 0) {
                    return false;
                }
            }
            return true;
        }

        void allocate(int i, int j, int t) {
            for (int k = i; k <= j; ++k) {
                _memory[k] = t;
            }
        }

        String alloc(int blockSize) {
            if (blockSize<1 || blockSize>_size) return "NULL";
            for (int i = 0; i <= _size - blockSize; ++i) {
                if (isFree(i, i + blockSize - 1)) {
                    ++_id;
                    allocate(i, i + blockSize - 1, _id);
                    return String.valueOf(_id);
                }
            }
            return "NULL";
        }

        void doErase(int i) {
            int t = _memory[i];
            while (i<_size && _memory[i] == t) {
                _memory[i] = 0;
                ++i;
            }
        }

        String erase(long id) {
            if (id<1 || id>_id)
                return "ILLEGAL_ERASE_ARGUMENT";
            for (int i = 0; i < _size; ++i) {
                if (_memory[i] == id) {
                    doErase(i);
                    return "";
                }
            }
            return "ILLEGAL_ERASE_ARGUMENT";
        }

        void defragment() {
            int mem[] = new int[_size];
            int j = 0;
            for (int i = 0; i < _size; ++i) {
                if (_memory[i] != 0) {
                    mem[j] = _memory[i];
                    ++j;
                }
            }
            _memory = mem;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("d:/in.txt"));

        Scanner in = new Scanner(System.in);

        String token[];

        token = in.nextLine().split(" ");
        int nOp = Integer.parseInt(token[0]);
        int s = Integer.parseInt(token[1]);
        MemoryManager m = new MemoryManager(s);
        while (nOp-- > 0) {
            token = in.nextLine().split(" ");
            String command = token[0];
            if (command.equals("alloc")) {
                System.out.println(m.alloc(Integer.parseInt(token[1])));
            } else if (command.equals("erase")) {
                String ret = m.erase(Long.parseLong(token[1]));
                if (!ret.equals("")) {
                    System.out.println(ret);
                }
            } else {
                m.defragment();
            }
        }
    }
}
