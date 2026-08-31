
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B {
    static class chunck {
        int st, end;
        boolean free;

        public chunck(int s, int e, boolean f) {
            st = s;
            end = e;
            free = f;
        }
    }

    public static void compress(ArrayList<chunck> list) {
        for (int j = 1; j < list.size(); j++) {
            if (list.get(j).free == true && list.get(j - 1).free == true) {
                list.get(j - 1).end = list.get(j).end;
                list.remove(j);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int curID = 1;
        ArrayList<chunck> list = new ArrayList<chunck>();
        HashMap<Integer, chunck> map = new HashMap<Integer, chunck>();
        HashMap<chunck, Integer> reverse=new HashMap<chunck, Integer>();
        list.add(new chunck(1, m, true));
        for (int i = 0; i < t; i++) {
//          for(int j=0;j<list.size();j++) {
//              System.out.println(list.get(j).st+" "+list.get(j).end+" "+list.get(j).free);
//          }
//          System.out.println();
            
            String inst = sc.next();
            if (inst.equals("alloc")) {
                int size = sc.nextInt();
                boolean found = false;
                for (int j = 0; j < list.size(); j++) {
                    chunck tmp = list.get(j);
                    if (tmp.free == true && tmp.end - tmp.st + 1 > size) {
                        list.add(j,
                                new chunck(tmp.st, tmp.st + size - 1, false));
                        tmp.st = tmp.st + size;
                        map.put(curID, list.get(j));
                        reverse.put(list.get(j), curID);
                        out.println(curID++);
                        found = true;
                        break;
                    } else if (tmp.free == true && tmp.end - tmp.st + 1 == size) {
                        map.put(curID, list.get(j));
                        reverse.put(list.get(j), curID);
                        tmp.free = false;
                        out.println(curID++);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    out.println("NULL");
                }
            } else if (inst.equals("erase")) {
                int ID = sc.nextInt();
                if (map.get(ID) == null)
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                else {
                    chunck tmp = map.get(ID);
                    tmp.free = true;
                    map.remove(ID);
                    reverse.remove(tmp);
                    compress(list);
                }
            } else {
                for (int j = 1; j < list.size(); j++) {
                    if (list.get(j).free == false
                            && list.get(j - 1).free == true) {
                        int tmp=reverse.get(list.get(j));
                        reverse.remove(list.get(j));
                        reverse.put(list.get(j-1), tmp);
                        map.put(tmp, list.get(j-1));
                        int end = list.get(j - 1).st
                                + (list.get(j).end - list.get(j).st);
                        list.get(j - 1).end = end;
                        list.get(j - 1).free = false;
                        list.get(j).free = true;
                        list.get(j).st = end + 1;
                        
                    }
                }
                compress(list);
            }
        }
        out.flush();
    }
}
