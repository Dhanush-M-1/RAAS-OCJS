import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Multiplication_Table_G {
	public static void main(String[] args)throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		PrintWriter pw = new PrintWriter(System.out, true);
		int num=Integer.parseInt(bf.readLine());
		if(num==2)
		{
			pw.print("1");
		}
		else if(num==3)
		{
			pw.println("1 2");
			pw.println("2 11");
		}
		else if(num==4)
		{
			pw.println("1 2 3");
			pw.println("2 10 12");
			pw.println("3 12 21");
		}
		else if(num==5)
		{
			pw.println("1 2 3 4");
			pw.println("2 4 11 13");
			pw.println("3 11 14 22");
			pw.println("4 13 22 31");
		}
		else if(num==6)
		{
			pw.println("1 2 3 4 5");
			pw.println("2 4 10 12 14");
			pw.println("3 10 13 20 23");
			pw.println("4 12 20 24 32");
			pw.println("5 14 23 32 41");
		}
		else if(num==7)
		{
			pw.println("1 2 3 4 5 6");
			pw.println("2 4 6 11 13 15");
			pw.println("3 6 12 15 21 24");
			pw.println("4 11 15 22 26 33");
			pw.println("5 13 21 26 34 42");
			pw.println("6 15 24 33 42 51");
		}
		else if(num==8)
		{
			pw.println("1 2 3 4 5 6 7");
			pw.println("2 4 6 10 12 14 16");
			pw.println("3 6 11 14 17 22 25");
			pw.println("4 10 14 20 24 30 34");
			pw.println("5 12 17 24 31 36 43");
			pw.println("6 14 22 30 36 44 52");
			pw.println("7 16 25 34 43 52 61");
		}
		else if(num==9)
		{
			pw.println("1 2 3 4 5 6 7 8");
			pw.println("2 4 6 8 11 13 15 17");
			pw.println("3 6	10 13 16 20	23 26");
			pw.println("4 8	13 17 22 26	31 35");
			pw.println("5 11 16	22 27 33 38	44");
			pw.println("6 13 20	26 33 40 46	53");
			pw.println("7 15 23 31 38 46 54 62");
			pw.println("8 17 26 35 44 53 62 71");
		}
		else if(num==10)
		{
			pw.println("1 2 3 4 5 6 7 8 9");
			pw.println("2 4 6 8 10 12 14 16 18");
			pw.println("3 6 9 12 15 18 21 24 27");
			pw.println("4 8 12 16 20 24 28 32 36");
			pw.println("5 10 15 20 25 30 35 40 45");
			pw.println("6 12 18 24 30 36 42 48 54");
			pw.println("7 14 21 28 35 42 49 56 63");
			pw.println("8 16 24 32 40 48 56 64 72");
			pw.println("9 18 27 36 45 54 63 72 81");
		}
		pw.close();
	}
}
