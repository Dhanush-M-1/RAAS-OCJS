#include <bits/stdc++.h>

const int N = 100054;

int V, n, q, t;
int k1, k2, k3;
int rev[N];
bool Up = false;

inline void up(int &x, const int y) {x < y ? x = y : 0;}
inline void down(int &x, const int y) {x > y ? x = y : 0;}
inline int min(const int x, const int y) {return x < y ? x : y;}
inline int max(const int x, const int y) {return x < y ? y : x;}
inline int f(int x) {return min(max(x, k1), k2) + k3;} // clip
inline void handle(int I) {Up ? (k3 += I, down(k1, V - k3), down(k2, V - k3)) : (k3 -= I, up(k1, -k3), up(k2, -k3)), t += I;}

int main() {
	int i, tg, x;
	scanf("%d%d", &V, &n);
	for (i = 0; i < n; ++i) scanf("%d", rev + i);
	rev[n] = INT_MAX;
	i = 0, k2 = V;
	for (scanf("%d", &q); q; --q) {
		scanf("%d%d", &tg, &x);
		for (; rev[i] <= tg; ++i) handle(rev[i] - t), Up = !Up;
		handle(tg - t), printf("%d\n", f(x));
	}
	return 0;
}