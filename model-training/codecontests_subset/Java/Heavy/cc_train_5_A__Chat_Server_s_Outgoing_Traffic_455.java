import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;

import java.math.BigInteger;
import java.util.*;

public class Main
{

	static PrintWriter writer;
	static StringTokenizer sz;
	static BufferedReader reader;

	public static void main(String[] args)
	throws Exception
	{
		declare();

		Scanner scanner = new Scanner(System.in);
		String line;
		int count,ans,lenMsg;
		count = ans = 0;

		while (scanner.hasNextLine())
		{
			line = scanner.nextLine();

			if (line.charAt(0) == '+')
				++count;
			else
			if (line.charAt(0) == '-')
				--count;
			else
			{
				lenMsg = line.substring(line.indexOf(":")).length() - 1;
				ans += lenMsg * count;
			}

		}

		writer.print(ans);
		close();
	}

	private static class Pair implements Comparable<Pair>
	{
		int first,second;

		public Pair(int f, int s)
		{
			first = f;
			second = s;
		}

		public Pair(Pair p)
		{
			first = p.first;
			second = p.second;
		}

		@Override
		public int compareTo(Main.Pair p1)
		{

			if (first == p1.first)
				return  second - p1.second;
			return first - p1.first;

		}

		@Override
		public String toString()
		{
			return first + " " + second + "\n";
		}
	}

	private static String readString()
	throws IOException
	{
		if (sz.hasMoreTokens())
			return sz.nextToken();
		return reader.readLine();
	}

	private static void readLine()
	throws IOException
	{
		sz = new StringTokenizer(reader.readLine());
	}

	private static int readInt()
	throws IOException
	{
		if (sz.hasMoreTokens())
			return Integer.parseInt(sz.nextToken());
		return Integer.parseInt(reader.readLine());
	}

	private static long readLong()
	throws IOException
	{
		if (sz.hasMoreTokens())
			return Long.parseLong(sz.nextToken());
		return Long.parseLong(reader.readLine());
	}

	private static void declare()
	{
		writer = new PrintWriter(System.out);
		reader = new BufferedReader(
			new InputStreamReader(System.in));
		sz = new StringTokenizer("");
	}

	private static void declareFile()
	throws IOException
	{
		writer = new PrintWriter("output.txt");
		reader = new BufferedReader(
			new FileReader("input.txt"));
		sz = new StringTokenizer("");
	}

	private static void close()
	throws IOException
	{
		reader.close();
		writer.flush();
		writer.close();
	}
}