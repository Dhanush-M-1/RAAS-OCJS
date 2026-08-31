//package com.company;

import javax.management.MBeanAttributeInfo;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MemoryManager {

    public static void print(List<MemoryBlock> list) {
        for (MemoryBlock block : list) {
            System.out.print(block.allocated + " " + block.size+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        Memory memory = new Memory(m);
        String command = null;
        int argument = 0;
        for (int i = 0; i < t; i++) {
            command = scanner.next();
            if (command.equals("alloc")) {
                argument = scanner.nextInt();
                int identifier = memory.alloc(argument);
                if (identifier == 0) {
                    System.out.println("NULL");
                } else {
                    System.out.println(identifier);
                }
            } else if (command.equals("erase")) {
                argument = scanner.nextInt();
                if (!memory.erase(argument)) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else {
                memory.defragment();
            }

        }
    }

    public static class MemoryBlock{
        public boolean allocated;
        public int size;
    }

    public static class Memory {
        private Map<Integer, MemoryBlock> allocation;
        private List<MemoryBlock> memory;
        private int identifier = 0;

        public Memory(int capacity) {
            allocation = new HashMap<>();
            memory = new LinkedList<>();
            MemoryBlock block = new MemoryBlock();
            block.allocated =false;
            block.size = capacity;
            memory.add(block);
        }

        public int alloc(int size) {
            Iterator<MemoryBlock> iterator = memory.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                MemoryBlock block = iterator.next();
                if (!block.allocated && block.size >= size) {
                    MemoryBlock remainder = new MemoryBlock();
                    remainder.size = block.size - size;
                    remainder.allocated = false;
                    block.size = size;
                    block.allocated = true;
                    memory.add(++index, remainder);
                    allocation.put(++identifier,block);
//                    print(memory);
                    return identifier;
                }
                index++;
            }
            return 0;
        }

        public boolean erase(int identifier) {
            if (allocation.get(identifier) == null) {
                return false;
            }
            MemoryBlock allocated = allocation.get(identifier);
            MemoryBlock previous = null;
            Iterator<MemoryBlock> iterator = memory.iterator();
            while (iterator.hasNext()) {
                MemoryBlock block = iterator.next();
                if (block == allocated) {
                    if (previous != null && !previous.allocated) {
                        block.size += previous.size;
                        memory.remove(previous);
                    }
                    if (iterator.hasNext()) {
                        MemoryBlock next = iterator.next();
                        if (!next.allocated) {
                            block.size += next.size;
                            memory.remove(next);
                        }
                    }
                    block.allocated = false;
                }
            }
            allocation.remove(identifier);
//            print(memory);
            return true;
        }

        public void defragment() {
            Iterator<MemoryBlock> iterator = memory.iterator();
            int availableCapacity = 0;
            while (iterator.hasNext()) {
                MemoryBlock block = iterator.next();
                if (!block.allocated) {
                    availableCapacity += block.size;
                    iterator.remove();
                }
            }
            MemoryBlock remain = new MemoryBlock();
            remain.allocated = false;
            remain.size = availableCapacity;
            memory.add(remain);
        }
    }


    public static class FastScanner {
        private StringTokenizer st;
        private BufferedReader br;
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
