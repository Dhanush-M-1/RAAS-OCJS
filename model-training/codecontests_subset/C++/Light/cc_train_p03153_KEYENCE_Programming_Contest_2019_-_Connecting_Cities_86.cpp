#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <memory.h>
#include <math.h>
#include <assert.h>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <string>
#include <algorithm>
#include <iostream>
#include <functional>
#include <unordered_set>
#include <bitset>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
#define Fi first
#define Se second
#define pb(x) push_back(x)
#define szz(x) (int)x.size()
#define rep(i,n) for(int i=0;i<n;i++)
#define all(x) x.begin(),x.end()
typedef tuple<int, int, int> t3;

int N, D, A[200020];
ll mn_l[200020];
vector <pair<ll, pii> > E;
int p[200020]; int Find(int x) { return p[x] == x ? x : p[x] = Find(p[x]); }

int main() {
	scanf("%d%d", &N, &D);
	for(int i=1;i<=N;i++) {
		scanf("%d", A + i);
	}
	mn_l[N + 1] = 1e18;
	for(int i=N;i;i--) {
		mn_l[i] = min(mn_l[i+1], A[i] + (ll) i * D);
	}
	vector <int> v;
	ll mn = 1e18;
	for(int i=1;i<=N;i++) {
		if(mn > A[i] - (ll)i*D) {
			mn = A[i] - (ll) i*D;
			v.pb(i);
		}
		else {
			int p = v.back();
			ll len = min(mn_l[i+1] + A[i] - (ll)i*D, A[i] + A[p] + (ll)D*(i-p));
			E.pb(make_pair(len, pii(i, v.back())));
		}
	}
	for(int i=0;i<szz(v)-1;i++) {
		int a = v[i], b = v[i+1];
		E.pb(make_pair(mn_l[b] + A[a] - (ll)a*D, pii(a, b)));
	}
	
	sort(all(E));
	for(int i=1;i<=N;i++) p[i] = i;
	ll ans = 0;
	for(auto e : E) {
		int x = Find(e.Se.Fi), y = Find(e.Se.Se);
		if(x != y) p[y] = x, ans += e.Fi;
	}
	printf("%lld\n", ans);
	return 0;
}
