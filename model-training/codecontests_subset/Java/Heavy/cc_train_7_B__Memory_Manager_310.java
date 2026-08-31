import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    static int ID_COUNT = 1;
    static Queue<Block> MEMORY = new LinkedList<>();
    static int FREESPACE;
    static int MAX_SIZE;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        String[] split = line.split(" ");
        int queries = Integer.parseInt(split[0]);
        MAX_SIZE = Integer.parseInt(split[1]);
        FREESPACE = MAX_SIZE;
        fill(MAX_SIZE);

        for(int query=0; query<queries; query++){
            line = reader.readLine();
            split = line.split(" ");
            if(split[0].equals("defragment"))
                defrag();
            else if(split[0].equals("alloc"))
                alloc(Integer.parseInt(split[1]));
            else
                erase(Integer.parseInt(split[1]));
        }
        out.flush();
        out.close();
        reader.close();
    }

    //Defragmenting
    public static void defrag(){
        int iteration = MAX_SIZE;
        for(int i=0; i<iteration; i++){
            if(MEMORY.peek().ID == 0)
                MEMORY.poll();
            else
                MEMORY.add(MEMORY.poll());
        }
        fill(FREESPACE);
    }


    //Allocating
    public static void alloc(int size){
        if(size > FREESPACE){
            out.println("NULL");
            return;
        }

        int freeSpaceCounter = 0;
        int iteration = MAX_SIZE;
        boolean flag = false;
        boolean searching = true;
        for(int i=0; i<iteration; i++){
            if(searching) {
                if(freeSpaceCounter == size){
                    out.println(ID_COUNT);
                    fill(size, ID_COUNT++);
                    searching = false;
                    MEMORY.add(MEMORY.poll());
                }
                else if (MEMORY.peek().ID != 0 && !flag)
                    MEMORY.add(MEMORY.poll());
                else if (MEMORY.peek().ID != 0) {
                    fill(freeSpaceCounter);
                    freeSpaceCounter = 0;
                    flag = false;
                    MEMORY.add(MEMORY.poll());
                } else if (!flag) {
                    flag = true;
                    MEMORY.poll();
                    freeSpaceCounter++;
                } else {
                    MEMORY.poll();
                    freeSpaceCounter++;
                }
            }
            else
                MEMORY.add(MEMORY.poll());
        }
        if(freeSpaceCounter == size && searching){
            out.println(ID_COUNT);
            fill(size, ID_COUNT++);
        }
        else if(searching) {
            fill(freeSpaceCounter);
            out.println("NULL");
        }
    }


    //Removing
    public static void erase(int id){
        if(id < 1 || id > 100){
            out.println("ILLEGAL_ERASE_ARGUMENT");
            return;
        }

        int iteration = MAX_SIZE;

        boolean flag = false;

        int size = 0;

        for(int i=0; i<iteration; i++){
            if(MEMORY.peek().ID == id) {
                size++;
                MEMORY.poll();
                flag = true;
                fill(1);
                FREESPACE++;
            }
            else
                MEMORY.add(MEMORY.poll());
        }
        if(!flag)
            out.println("ILLEGAL_ERASE_ARGUMENT");
    }

    //Filling free blocks
    public static void fill(int number){
        for(int i=0; i<number; i++){
            MEMORY.add(new Block(0));
        }
    }


    //Filling blocks
    public static void fill(int number, int id){
        for(int i=0; i<number; i++){
            MEMORY.add(new Block(id));
        }
        FREESPACE -= number;
    }

    //Blocks
    static class Block{
        int ID;
        Block(int id){
            ID = id;
        }
    }

}
