import java.util.*;
public class Vectors {
	

	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		long [] A = new long [2];
		long [] B = new long [2];
		long [] C = new long [2];
		A[0] = sc.nextInt(); A[1] = sc.nextInt();
		B[0] = sc.nextInt(); B[1] = sc.nextInt();
		C[0] = sc.nextInt(); C[1] = sc.nextInt();
		long [] D = new long [2];
		long [][] R90 = { {0 , -1}, {1 , 0}};
		
		boolean works = (A[0] == B[0] && A[1] == B[1]);
		D[0] = B[0] - A[0];
		D[1] = B[1] - A[1];
		long [][] CMTX = { {-C[1] , C[0]} , {C[0] , C[1]}};
		long [] ans = mtxInv( CMTX, D);
		works |= (ans != null);
		
		D[0] = B[0] + A[1];
		D[1] = B[1] - A[0];
		
	//	CMTX = mult(R90, CMTX);
		ans = mtxInv( CMTX, D);
		works |= (ans != null || (D[0] == 0 && D[1] == 0));
		
		D[0] = B[0] + A[0];
		D[1] = B[1] + A[1];
	//	CMTX = mult(R90, CMTX);
		ans = mtxInv( CMTX, D);
		works |= (ans != null|| (D[0] == 0 && D[1] == 0));
		
		D[0] = B[0] - A[1];
		D[1] = B[1] + A[0];
	//	CMTX = mult(R90, CMTX);
		ans = mtxInv( CMTX, D);
		works |= (ans != null|| (D[0] == 0 && D[1] == 0));
		
		
		System.out.println(works ? "YES" : "NO");
		
		
		
	}
	public static long [][] mult (long [][] A, long [][] B) {
		long [][] C = new long [A.length][B[0].length];
		for (int i = 0; i<C.length; ++i) {
			for (int j = 0; j<C[0].length; ++j) {
				long ans = 0;
				for (int k = 0; k<B.length; ++k) ans += B[k][j] * A[i][k];
				C[i][j] = ans;
			}
		}
		return C;
	}
	public static long[] mtxInv (long [][] mtx, long [] G) {
		long det = mtx[1][1] * mtx[0][0] - mtx[0][1] * mtx[1][0];
		if (det == 0) return null;
		long DET = det;
		long [] ans = new long [2];
		ans[0] = mtx[1][1] * G[0] - mtx[0][1] * G[1];
		ans[1] = -mtx[1][0] * G[0] + mtx[0][0] * G[1];
		if (ans[0] % DET != 0) return null;
		if (ans[1] % DET != 0) return null;
		ans[0] /= DET;
		ans[1] /= DET;
		//System.err.println(ans[0] + " : " + ans[1]);
		return ans;
	}

}