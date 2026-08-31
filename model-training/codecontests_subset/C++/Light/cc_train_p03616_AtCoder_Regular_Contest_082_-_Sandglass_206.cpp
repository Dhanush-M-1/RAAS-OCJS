#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define up(i,j,n)		for (int i = j; i <= n; i++)
#define down(i,j,n)	for (int i = j; i >= n; i--)
#define cmax(a,b)		a = max (a, b)
#define cmin(a,b)		a = min (a, b)

const int MAXN = 1e5 + 5;
const int oo = 0x3f3f3f3f;

int N, r[MAXN], X, Q;

int main(){
	scanf("%d%d", &X, &N);
	up (i, 1, N) scanf("%d", &r[i]);
	scanf("%d", &Q);
	int cur = 1, c = 0, lower = 0, upper = X, tt = -1;
	while (Q--) {
		int t, a;
		scanf("%d%d", &t, &a);
		while (r[cur] <= t && cur <= N) {
			int d = r[cur] - r[cur - 1];
			c += tt * d;
			if (lower + c < 0) {
				if (c >= -X) lower = -c;
				else {
					lower = X;
					c = -X;
				}
			}else if (lower + c > X) {
				if (c <= X) lower = X - c;
				else {
					lower = 0;
					c = X;
				}
			}
			if (upper + c < 0) {
				if (c >= -X) upper = -c;
				else {
					upper = X;
					c = -X;
				}
			}else if (upper + c > X) {
				if (c <= X) upper = X - c;
				else {
					upper = 0;
					c = X;
				}
			}
			tt *= -1;
			cur++;
		}
		int d = t - r[cur - 1];
		cmax (a, lower);
		cmin (a, upper);
		a += c + tt * d;
		if (a < 0) a = 0;
		if (a > X) a = X;
		printf("%d\n", a);
	}
	return 0;
}
