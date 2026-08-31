import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Memory {
    private int currentAlloc = 0;

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] memory = new Integer[scanner.nextInt()];

        for (int i = 0; i < count; ++i) {
            String line = scanner.next();
            if (line.startsWith("a")) {
                executeAlloc(memory, scanner.nextInt());
            } else if (line.startsWith("e")) {
                executeErase(memory, scanner.nextInt());
            } else {
                executeDefrag(memory);
            }
        }
    }

    private void executeDefrag(Integer[] memory) {
        List<Integer> integers = new ArrayList<Integer>(Arrays.asList(memory));
        int removed = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) == null) {
                integers.remove(i--);
                ++removed;
            }
        }

        for (int i = 0; i < removed; i++) {
            integers.add(null);
        }

        for (int i = 0; i < integers.size(); i++) {
            memory[i] = integers.get(i);
        }
    }

    private void executeErase(Integer[] memory, int number) {
        boolean exist = false;
        for (int i = 0; i < memory.length; i++) {
            Integer integer = memory[i];
            if (integer != null && integer == number) {
                memory[i] = null;
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("ILLEGAL_ERASE_ARGUMENT");
        }
    }

    private void executeAlloc(Integer[] memory, int size) {
        int position = getPosition(memory, size);
        if (position == -1) {
            System.out.println("NULL");
            return;
        }
        System.out.println(++currentAlloc);
        for (int i = position; i < position + size; i++) {
            memory[i] = currentAlloc;
        }
    }

    private int getPosition(Integer[] memory, int size) {
        int free = 0;
        for (int i = 0; i < memory.length; i++) {
            Integer integer = memory[i];
            if (integer == null) {
                ++free;
                if (free >= size) {
                    return i - size + 1;
                }
            } else {
                free = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Memory().run();
    }
}