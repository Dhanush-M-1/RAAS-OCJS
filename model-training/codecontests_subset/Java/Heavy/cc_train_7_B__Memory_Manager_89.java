import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MemoryManager {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Block> al = new ArrayList<Block>();
        int count = 1;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(f.readLine());
            String s = st.nextToken();
            
            if (s.equals("alloc")) {
                int n = Integer.parseInt(st.nextToken());
                if (al.size() > 0) {
                    if (al.get(0).start-1 >= n) {
                        al.add(0, new Block(1,n,count));
                        System.out.println(count++);
                        continue;
                    }
                    boolean b = false;
                    for (int j = 0; j < al.size()-1 && !b; j++)
                        if (al.get(j+1).start-(al.get(j).start+al.get(j).length) >= n) {
                            al.add(j+1, new Block(al.get(j).start+al.get(j).length,n,count));
                            System.out.println(count++);
                            b = true;
                        }
                    if (!b) 
                        if (m+1-(al.get(al.size()-1).start+al.get(al.size()-1).length) >= n) {
                            al.add(new Block(al.get(al.size()-1).start+al.get(al.size()-1).length,n,count));
                            System.out.println(count++);
                        }
                        else
                            System.out.println("NULL");
                }
                else 
                    if (n <= m) {
                        al.add(new Block(1,n,count));
                        System.out.println(count++);
                    }
                    else
                        System.out.println("NULL"); 
            }
            else if (s.equals("erase")) {
                long x = Long.parseLong(st.nextToken());
                int index = -1;
                for (int j = 0; j < al.size(); j++)
                    if (al.get(j).id == x)
                        index = j;
                if (index == -1)
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                else 
                    al.remove(index);
            }
            else {
                if (al.size() > 0)
                    al.get(0).start = 1;
                for (int j = 1; j < al.size(); j++) 
                    al.get(j).start = al.get(j-1).start+al.get(j-1).length;
            }
        }
        
    }   
}

class Block {
    int start;
    int length;
    int id;
    public Block(int start, int length, int id) {
        this.start = start;
        this.length = length;
        this.id = id;
    }
}