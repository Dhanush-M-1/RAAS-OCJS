#include <bits/stdc++.h>

const int maxn = 1e5 + 3;
int X, K, rev[maxn], Q, ti[maxn], ai[maxn], l, r, u, v;

void trans(int dt) {
	if(u + dt < 0) {
		l -= u + dt;
		u = 0;
	} else if(u + dt > X) {
		u = X;
		l = X;
	} else {
		u += dt;
	}
	if(v + dt < 0) {
		v = 0;
		r = 0;
	} else if(v + dt > X) {
		r -= v + dt - X;
		v = X;
	} else {
		v += dt;
	}
}

int calc(int x) {
	if(x <= l)
		return u;
	if(x >= r)
		return v;
	return u + x - l;
}

int main() {
	scanf("%d%d", &X, &K);
	l = u = 0;
	r = v = X;
	rev[0] = 0;
	for(int i = 1; i <= K; ++i)
		scanf("%d", rev + i);
	scanf("%d", &Q);
	for(int i = 0; i < Q; ++i)
		scanf("%d%d", ti + i, ai + i);
	ti[Q] = 0x7fffffff;
	for(int i = 1, j = 0, t = rev[0]; i <= K || j < Q;) {
		if(i <= K && rev[i] <= ti[j]) {
			trans((i & 1) ? t - rev[i] : rev[i] - t);
			t = rev[i++];
		} else {
			trans((i & 1) ? t - ti[j] : ti[j] - t);
			printf("%d\n", calc(ai[j]));
			t = ti[j++];
		}
	}
	return 0;
}
