import java.util.*;

public class Mem {
  public static void main(String[] args) {
    Mem m = new Mem();
    m.solve();
  }
  
  public void solve() {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int m = in.nextInt();
    boolean[] allocated = new boolean[m];
    HashMap<Integer, Integer> tokenLoc = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> locToToken = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> allocSize = new HashMap<Integer, Integer>();
    int curToken = 1;
    StringBuilder output = new StringBuilder();
    while (t-->0) {
      char cmd = (in.next()).charAt(0);
      if (cmd == 'a') { // allocate
        int size = in.nextInt();
        // check to see if there is anywhere to allocate.
        int idx = 0;
        boolean cando = false;
        while (idx+size <= m) {
          cando = true;
          for (int j = idx; j < idx+size; ++j) {
            cando &= !allocated[j];
            if (!cando) {
              idx = j+1;
              break;
            }
          }
          if (cando) {
            for (int j = idx; j < idx+size; ++j) { allocated[j] = true; }
            tokenLoc.put(curToken, idx);
            locToToken.put(idx, curToken);
            allocSize.put(curToken, size);
            output.append(curToken + "\n");
            ++curToken;
            break;
          }
        }
        if (!cando) { // couldn't do it
          output.append("NULL\n");
        }
      } else if (cmd == 'e') {
        int x = in.nextInt();
        Integer idx = tokenLoc.get(x);
        if (idx == null) {
          output.append("ILLEGAL_ERASE_ARGUMENT\n");
          continue;
        }
        for (int j = idx; j < idx+allocSize.get(x); ++j) {
          allocated[j] = false;
        }
        tokenLoc.put(x, null);
        allocSize.put(x, null);
      } else { // defragment
        int idx = 0;
        int reIdx = 0;
        while (idx < m) {
          if (!allocated[idx]) {
            ++idx;
            continue;
          }
          int token = locToToken.get(idx);
          int size = allocSize.get(token);
          if (idx == reIdx) {
            idx += size;
            reIdx += size;
            continue;
          }
          for (int j = idx; j < idx+size; ++j) allocated[j] = false;
          for (int j = reIdx; j < reIdx+size; ++j) allocated[j] = true;
          locToToken.put(idx, null);
          tokenLoc.put(token, reIdx);
          locToToken.put(reIdx, token);
          idx += size;
          reIdx += size;
        }
      }
    }
    System.out.println(output);
  }
}