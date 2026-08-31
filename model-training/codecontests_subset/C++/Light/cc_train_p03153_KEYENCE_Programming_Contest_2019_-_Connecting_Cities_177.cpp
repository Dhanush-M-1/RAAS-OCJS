#include <bits/stdc++.h>
using namespace std;

#define LL long long

const int maxN = 2e5 + 10;

struct Node
{
	int from, to;
	LL value;
	Node(int X = 0, int Y = 0, LL Z = 0) { from = X; to = Y; value = Z; }
}edge[maxN * 25 + 1];

int n, D, cnt;
int a[maxN + 1], pa[maxN + 1];

inline int read()
{
	int num = 0, f = 1;
	char ch = getchar();
	while( !isdigit( ch ) ) { if(ch == '-') f = -1; ch = getchar(); }
	while( isdigit( ch ) ) num = (num << 3) + (num << 1) + (ch ^ 48), ch = getchar();
	return num * f;
}

inline void solve(int l, int r)
{
	if(l == r) return;
	
	int mid = (l + r) >> 1;
	solve(l, mid); solve(mid + 1, r);
	
	int ml = 0, mr = 0;
	LL fl = 1e18, fr = 1e18;
	for(int i = l; i <= mid; i++)
		if(a[i] - 1ll * D * i < fl) fl = a[i] - 1ll * D * i, ml = i;
	for(int i = mid + 1; i <= r; i++)
		if(a[i] + 1ll * D * i < fr) fr = a[i] + 1ll * D * i, mr = i;
	
	for(int i = l; i <= mid; i++) edge[++ cnt] = Node(i, mr, 1ll * (mr - i) * D + a[i] + a[mr]);
	for(int i = mid + 1; i <= r; i++) edge[++ cnt] = Node(ml, i, 1ll * (i - ml) * D + a[ml] + a[i]);
}

inline bool comp(Node a, Node b) { return a.value < b.value; }

inline int find(int x) { return pa[x] == x ? x : pa[x] = find(pa[x]); }

int main()
{
	n = read(), D = read();
	for(int i = 1; i <= n; i++) a[i] = read();

	solve(1, n);

	sort(edge + 1, edge + cnt + 1, comp);

	for(int i = 1; i <= n; i++) pa[i] = i;

	LL ans = 0;
	for(int i = 1; i <= cnt; i++)
	{
		int x = find(edge[i].from), y = find(edge[i].to);
		if(x == y) continue;
		ans += edge[i].value;
		pa[x] = y;
	}

	printf("%lld", ans);
	return 0;
}
