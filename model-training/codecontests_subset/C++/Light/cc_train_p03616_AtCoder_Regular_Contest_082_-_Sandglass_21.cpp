#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<cmath>
#include<queue>
#include<functional>
#include<tuple>
using namespace std;
int X, K, Q, p[100009], ans[100009], L = 0, R, s = 0, t; bool unity = false;
int l[100009], r[100009], v[100009]; bool u[100009];
int main() {
	cin >> X >> K; R = X; t = X;
	for (int i = 1; i < 100009; i++)p[i] = 1000000009;
	for (int i = 1; i <= K; i++)cin >> p[i]; p[K + 1] = 1000000007; K += 2;
	l[0] = 0; r[0] = R; v[0] = 0;
	for (int i = 1; i < K; i++) {
		if (i % 2 == 1) { s -= (p[i] - p[i - 1]); t -= (p[i] - p[i - 1]); if (s < 0) { L += (-s); s = 0; }if (t < 0) { unity = true; } }
		if (i % 2 == 0) { s += (p[i] - p[i - 1]); t += (p[i] - p[i - 1]); if (s > X) { s = X; unity = true; }if (t > X) { R -= (t - X); t = X; } }
		if (L >= R)unity = true;
		u[i] = unity; l[i] = L; r[i] = R; v[i] = s;
	}
	cin >> Q;
	for (int i = 0; i < Q; i++) {
		int p1, p2; cin >> p1 >> p2;
		int pos1 = upper_bound(p, p + K, p1) - p; pos1--;
		int GG = max(l[pos1], min(r[pos1], p2)) - l[pos1]; GG += v[pos1];
		if (pos1 % 2 == 0)GG -= (p1 - p[pos1]); else GG += (p1 - p[pos1]);
		GG = max(0, min(X, GG));
		cout << GG << endl;
	}
	return 0;
}