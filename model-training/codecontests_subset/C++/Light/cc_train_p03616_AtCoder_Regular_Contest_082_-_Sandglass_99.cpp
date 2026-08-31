#include<cstdio>
#include<algorithm>
using namespace std;
int X, n;
int Mn[101000], Mx[101000], Q, Cur[101000];
int MnL[101000], MxL[101000];
int S[101000], T[101000], ck;
int main() {
	int i;
	scanf("%d%d", &X, &n);
	int t = 1, a;
	for (i = 1; i <= n + 1; i++) {
		if(i<=n)scanf("%d", &T[i]);
		else T[i] = 1e9;
		t *= -1;
		S[i] = S[i - 1] + t*(T[i] - T[i - 1]);
		Mn[i] = Mn[i - 1], Mx[i] = Mx[i - 1], MnL[i] = MnL[i - 1], MxL[i] = MxL[i - 1];
		if (Mn[i] > S[i]) Mn[i] = S[i], MnL[i] = i;
		if (Mx[i] < S[i]) Mx[i] = S[i], MxL[i] = i;
		if (Mx[i] - Mn[i] >= X) {
			if (!ck) {
				if (t == 1) Cur[i] = X;
				else Cur[i] = 0;
				ck = 1;
			}
			else {
				Cur[i] = min(X, max(0, Cur[i - 1] + t*(T[i] - T[i - 1])));
			}
		}
	}
	n++;
	scanf("%d", &Q);
	while (Q--) {
		scanf("%d%d", &t, &a);
		int pv = lower_bound(T + 1, T + n + 1, t + 1) - T - 1;
		int x;
		if (Mx[pv] - Mn[pv] >= X) {
			x = Cur[pv];
		}
		else {
			if (a + Mn[pv] <= 0) {
				x = S[pv] - S[MnL[pv]];
			}
			else if (a + Mx[pv] >= X) {
				x = S[pv] - S[MxL[pv]] + X;
			}
			else {
				x = a + S[pv];
			}
		}
		int tp = -1;
		if (pv % 2)tp = 1;
		printf("%d\n", max(min(x + tp * (t - T[pv]), X), 0));
	}
}