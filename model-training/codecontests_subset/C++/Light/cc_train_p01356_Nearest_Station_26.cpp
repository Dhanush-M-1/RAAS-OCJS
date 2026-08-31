#include <cmath>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	long long N, M, A, B, P, Q;
	cin >> N >> M >> A >> B >> P >> Q;
	if (A == 1 && B == 1) {
		long long d = M / (P + Q);
		long long ret = (M > N * (P + Q) ? M - N * (P + Q) : N * (P + Q) - M);
		if (d <= N) ret = min(ret, M - d * (P + Q));
		if (d <= N - 1) ret = min(ret, (d + 1) * (P + Q) - M);
		cout << ret << endl;
	}
	else {
		double lim = log(2 * M) / max(log(A), log(B));
		int rep = int(lim + 0.01);
		long long mulA = 1, mulB = 1;
		vector<long long> v;
		for (int i = 0; i <= rep && i < N; ++i) {
			v.push_back(P * mulA + Q * mulB);
			mulA *= A;
			mulB *= B;
		}
		int S = v.size();
		int SL = S / 2, SR = S - S / 2;
		vector<long long> vl(1 << SL), vr(1 << SR);
		for (int i = 0; i < SL; ++i) {
			for (int j = 1 << i; j < 2 << i; ++j) {
				vl[j] = vl[j - (1 << i)] + v[i];
			}
			vector<long long> mem(2 << i);
			merge(vl.begin(), vl.begin() + (1 << i), vl.begin() + (1 << i), vl.begin() + (2 << i), mem.begin());
			copy(mem.begin(), mem.end(), vl.begin());
		}
		for (int i = 0; i < SR; ++i) {
			for (int j = 1 << i; j < 2 << i; ++j) {
				vr[j] = vr[j - (1 << i)] + v[i + SL];
			}
			vector<long long> mem(2 << i);
			merge(vr.begin(), vr.begin() + (1 << i), vr.begin() + (1 << i), vr.begin() + (2 << i), mem.begin());
			copy(mem.begin(), mem.end(), vr.begin());
		}
		int ptr = 1 << SR;
		long long ans = M;
		for (int i = 0; i < 1 << SL; ++i) {
			while (ptr != 0 && vl[i] + vr[ptr - 1] > M) --ptr;
			if (ptr != 0) ans = min(ans, M - vl[i] - vr[ptr - 1]);
			if (ptr != (1 << SR)) ans = min(ans, vl[i] + vr[ptr] - M);
		}
		cout << ans << endl;
	}
	return 0;
}
