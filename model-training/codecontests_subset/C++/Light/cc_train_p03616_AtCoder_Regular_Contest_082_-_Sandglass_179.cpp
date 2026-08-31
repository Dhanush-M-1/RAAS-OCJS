#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cmath>
#include <vector>
#include <set>
#include <map>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <ctime>
#include <cassert>
#include <complex>
#include <string>
#include <cstring>
using namespace std;

#ifdef LOCAL
	#define eprintf(...) fprintf(stderr, __VA_ARGS__)
#else
	#define eprintf(...) 42
#endif

typedef long long ll;
typedef pair<int, int> pii;
#define mp make_pair

const int N = 100100;
int n;
int X;
int a[N];

int main()
{
//	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);

	scanf("%d%d", &X, &n);
	n++;
	for (int i = 1; i < n; i++)
		scanf("%d", &a[i]);
	int q;
	scanf("%d", &q);
	int l = 0, r = X;
	int forL = 0;
	int it = 0;
	int z = 0;
	while(q--) {
		int t, w;
		scanf("%d%d", &t, &w);
		while(it + 1 < n && a[it + 1] <= t) {
			if (z == 0) {
				forL -= a[it + 1] - a[it];
			} else {
				forL += a[it + 1] - a[it];
			}
			if (forL < 0) {
				l -= forL;
				forL = 0;
			}
			if (forL + r - l > X) {
				r -= forL + r - l - X;
				forL = X - r + l;
			}
			if (l > r) {
				l = r = 0;
				if (forL > X)
					forL = X;
			}
			z ^= 1;
			it++;
		}
		t -= a[it];
		if (w < l) w = l;
		if (w > r) w = r;
		w = forL + w - l;
		if (z == 0)
			w -= t;
		else
			w += t;
		if (w < 0) w = 0;
		if (w > X) w = X;
		printf("%d\n", w);
	}

	return 0;
}
