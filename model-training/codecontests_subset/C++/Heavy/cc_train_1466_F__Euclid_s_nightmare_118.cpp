#include<bits/stdc++.h>
#define ll long long
#define FOR(i, s, e) for (int i = (s); i < (e); i++)
#define FOE(i, s, e) for (int i = (s); i <= (e); i++)
#define FOD(i, s, e) for (int i = (s); i >= (e); i--)
#define mp make_pair

using namespace std;

int n, m;
int p[500005], self[500005];
set<int> s;

int find(int x) { if (p[x] == x) return x; return p[x] = find(p[x]); }

int main () {
	scanf("%d %d", &n, &m);
	
	FOE(i, 1, m) p[i] = i, self[i] = 0;

	FOR(i, 0, n) {
		int k;
		scanf("%d", &k);
		if (k == 1) {
			int x;
			scanf("%d", &x);
			x = find(x);
			if (self[x] == 0) {
				self[x] = 1;
				s.emplace(i + 1);
			}
		} else {
			int x, y;
			scanf("%d%d", &x, &y);
			x = find(x);
			y = find(y);
			if (x != y && (self[x] != 1 || self[y] != 1)) {
				p[x] = y;
				self[y] = max(self[x], self[y]);
				s.emplace(i + 1);
			}
		}
	}

	long long res = 1;
	for (int i = 0; i < (int)s.size(); i++)
		res = (res * 2) % 1000000007ll;

	printf("%lld %d\n", res, (int)s.size());
	for (int i : s) printf("%d ", i);
	puts("");
	return 0;
}
