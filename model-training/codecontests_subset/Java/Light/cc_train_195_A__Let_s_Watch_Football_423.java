import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author DOAN Minh Quy
 * @e-mail mquy.doan@gmail.com
 */
public class A195 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//File fileInput = new File("C:\\Users\\DOAN\\Dropbox\\eclipseWorkspace\\Codeforces\\bin\\test.inp");
		//Scanner scanner = new Scanner(new FileInputStream(fileInput));
		A195Solver solver = new A195Solver();
		while(scanner.hasNextInt()){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			System.out.println(solver.solve(a, b, c));
		}
		scanner.close();
	}
}
class A195Solver{
	public int solve(int sizeOfData,int sizePerSecond,int length){
		int waitTime = 0;
		while(sizePerSecond * (waitTime + length) < length * sizeOfData) ++waitTime;
		return waitTime;
	}
}