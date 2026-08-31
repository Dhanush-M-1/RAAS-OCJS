import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long ans = 1;
		long MOD = (long) 1e9 + 7;
		for(long i = 2; i <= n; i++) {
			ans *= i;
			ans %= MOD;
		}
		long twopow = 1;
		for(long i = 1; i < n; i++) {
			twopow *= 2;
			twopow %= MOD;
		}
		System.out.println((ans - twopow +MOD)%MOD);
	}
}