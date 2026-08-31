import java.io.*;
import java.util.*;

public class B {

  private BufferedReader myBr;
  private StringTokenizer mySt = new StringTokenizer("");
  private int myNextId = 1;

  private void solve() throws IOException {
//    InputStream is = new FileInputStream("b.in");
    InputStream is = System.in;
    myBr = new BufferedReader(new InputStreamReader(is));
    PrintStream out = new PrintStream(System.out);

    int t = nextInt();
    int m = nextInt();

    List<Block> freeBlocks = new LinkedList<>();
    freeBlocks.add(new Block(1, m));
    Map<Integer, Block> allocated = new HashMap<>();

    for (int i = 0; i < t; i++) {
      String type = nextToken();
      if ("alloc".equals(type)) {
        int size = nextInt();
        int id = allocate(size, freeBlocks, allocated);
        out.println(id == -1 ? "NULL" : id);
      }
      else if ("erase".equals(type)) {
        int id = nextInt();
        Block allocBlock = allocated.remove(id);
        if (allocBlock == null) {
          out.println("ILLEGAL_ERASE_ARGUMENT");
        }
        else {
          erase(allocBlock, freeBlocks);
        }
      }
      else {
        defragment(allocated, freeBlocks, m);
      }
    }
    out.close();
  }

  private int allocate(int size, List<Block> freeBlocks, Map<Integer, Block> allocated) {
    for (Iterator<Block> it = freeBlocks.iterator(); it.hasNext(); ) {
      Block freeBlock = it.next();
      if (freeBlock.myLength >= size) {
        Block allocatedBlock = new Block(freeBlock.myStartInd, size);
        int id = myNextId++;
        allocated.put(id, allocatedBlock);
        if (freeBlock.myLength == size) {
          it.remove();
        }
        else {
          freeBlock.myStartInd += size;
          freeBlock.myLength -= size;
        }
        return id;
      }
    }
    return -1;
  }

  private void erase(Block blockToErase, List<Block> freeBlocks) {
    boolean added = false;
    for (ListIterator<Block> it = freeBlocks.listIterator(); it.hasNext(); ) {
      Block freeBlock = it.next();
      if (freeBlock.myStartInd > blockToErase.myStartInd) {
        it.previous();
        it.add(blockToErase);
        added = true;
        break;
      }
    }
    if (!added) {
      freeBlocks.add(blockToErase);
    }
    for (ListIterator<Block> it = freeBlocks.listIterator(); it.hasNext(); ) {
      Block block = it.next();
      if (it.hasNext()) {
        Block nextBlock = it.next();
        if (areBlocksAdjacent(block, nextBlock)) {
          block.myLength += nextBlock.myLength;
          it.remove();
          it.previous();
        }
      }
    }
  }

  private boolean areBlocksAdjacent(Block a, Block b) {
    return a.myStartInd + a.myLength == b.myStartInd;
  }

  private void defragment(Map<Integer, Block> allocated, List<Block> freeBlocks, int m) {
    List<Block> blocks = new ArrayList<>(allocated.values());
    Collections.sort(blocks, new Comparator<Block>() {
      @Override
      public int compare(Block o1, Block o2) {
        return o1.myStartInd - o2.myStartInd;
      }
    });
    int freeInd = 1;
    for (Block block : blocks) {
      block.myStartInd = freeInd;
      freeInd += block.myLength;
    }
    freeBlocks.clear();
    freeBlocks.add(new Block(freeInd, m - freeInd + 1));
  }

  private String nextToken() throws IOException {
    while (!mySt.hasMoreTokens()) {
      mySt = new StringTokenizer(myBr.readLine());
    }
    return mySt.nextToken();
  }

  private int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  public static void main(String[] args) throws IOException {
    new B().solve();
  }

  private static class Block {
    private int myStartInd;
    private int myLength;

    private Block(int startInd, int length) {
      myStartInd = startInd;
      myLength = length;
    }
  }

}
