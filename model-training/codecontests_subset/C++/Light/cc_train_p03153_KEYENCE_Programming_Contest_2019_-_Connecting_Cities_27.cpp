#include <bits/stdc++.h>
#define fi first
#define se second
#define mp make_pair
using namespace std;

typedef pair <int, int> pii;
typedef pair <long long, pii> plii;

const long long INF = 0x3f3f3f3f3f3f3f3f;

int n;
long long d;
long long a[200010];
int fa[200010];
vector <plii> e;

int find(int x){
	return fa[x] == x ? x : fa[x] = find(fa[x]);
}

long long fl(int x){
	return x == -1 ? INF : a[x] - x * d;
}

long long fr(int x){
	return x == -1 ? INF : a[x] + x * d;
}

void add_edge(int l, int r){
	if (l == r) return ;
	int mid = (l + r) >> 1;
	int pos = -1;
	for (int i = l; i <= mid; i++){
		if (fl(i) < fl(pos)) pos = i;
	}
	for (int i = mid + 1; i <= r; i++){
		e.push_back(mp(a[i] + a[pos] + (i - pos) * d, mp(i, pos)));
	}
	pos = -1;
	for (int i = mid + 1; i <= r; i++){
		if (fr(i) < fr(pos)) pos = i;
	}
	for (int i = l; i <= mid; i++){
		e.push_back(mp(a[i] + a[pos] + (pos - i) * d, mp(i, pos)));
	}
	add_edge(l, mid), add_edge(mid + 1, r);
}

int main(){
	scanf("%d%lld", &n, &d);
	for (int i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
	add_edge(0, n - 1);
	sort(e.begin(), e.end());
	for (int i = 0; i < n; i++){
		fa[i] = i;
	}
	long long ans = 0;
	int tot = n - 1;
	for (int i = 0; i < e.size(); i++){
		int u = e[i].se.fi, v = e[i].se.se;
		long long dist = e[i].fi;
		if (find(u) == find(v)) continue;
		fa[find(u)] = find(v);
		ans += dist, tot--;
		if (!tot) break;
	}
	printf("%lld\n", ans);
	return 0;
}
