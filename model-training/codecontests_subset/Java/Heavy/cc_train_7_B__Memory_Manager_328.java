
import java.util.*;


public class B
{
   public static void main(String[] args)
   {
      new B(new Scanner(System.in));
   }

   ArrayList<Block> blocks;
   int id_count;
   int MS;

   int alloc(int n)
   {
      int last = 0;
      for (int i=0; i<blocks.size(); i++)
      {
         Block b = blocks.get(i);
         int size = b.i-last;
         if (size >= n)
         {
            blocks.add(i, new Block(last, n, id_count));
            id_count++;
            return id_count-1;
         }
         last = b.j;
      }

      int size = MS-last;
      if (size >= n)
      {
         blocks.add(new Block(last, n, id_count));
         id_count++;
         return id_count-1;
      }

      return -1;
   }

   boolean erase(int id)
   {
      for (int i=0; i<blocks.size(); i++)
      {
         Block b = blocks.get(i);
         if (b.id == id)
         {
            blocks.remove(i);
            return true;
         }
      }

      return false;
   }

   void defrag()
   {
      int last = 0;
      for (Block b : blocks)
      {
         b.move(last);
         last = b.j;
      }
   }

   public B(Scanner in)
   {
      id_count = 1;
      String[] ip = in.nextLine().split(" ");
      int N = Integer.parseInt(ip[0]);
      MS = Integer.parseInt(ip[1]);
      blocks = new ArrayList<Block>();
      for (int i=0; i<N; i++)
      {
         String s = in.nextLine();
         String[] ss = s.split(" ");
         String cmd = ss[0];
         if (cmd.compareTo("alloc") == 0)
         {
            int n = Integer.parseInt(ss[1]);
            int id = alloc(n);
            if (id == -1)
               System.out.println("NULL");
            else 
               System.out.println(id);
         }
         else if (cmd.compareTo("erase") == 0)
         {
            int id = Integer.parseInt(ss[1]);
            boolean res = erase(id);
            if (!res)
               System.out.println("ILLEGAL_ERASE_ARGUMENT");
         }
         else if (cmd.compareTo("defragment") == 0)
         {
            defrag();
         }
      
         //System.out.println(blocks);
      }
   }
}


class Block
{
   int i, j, len, id;

   public Block(int x, int ln, int idd)
   {
      i = x;
      j = x+ln;
      len = ln;
      id = idd;
   }

   void move(int ni)
   {
      i = ni;
      j = i+len;
   }

   public String toString()
   {
      return "["+i+", "+j+"] ";
   }
}

