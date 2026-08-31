#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <string>
#include <fstream>
#include <vector>
#include <queue>
#include <stack>
#include <sstream>
#include <list>
#include <map>
#include <set>
#include <limits>
#include <random>
#include <functional>
#include <unordered_set>
#include <unordered_map>

typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
typedef unsigned int ui;

#define pii pair<int, int>
#define pll pair<ll, ll>
#define vi vector<int>
#define vl vector<ll>

using namespace std;

const int N = 100010;
const int M = 200010;
const int MOD = 1000000007;
const int INF = 1009000999;
const ll LINF = (1ll << 60) + 1337;
const ld EPS = 0.00000001;

void build(vi& a, vi & ans, int l, int r, int depth = 0) {
	if (l >= r) return;
	int id = max_element(a.begin() + l, a.begin() + r) - a.begin();
	ans[id] = depth;
	build(a, ans, l, id, depth + 1);
	build(a, ans, id + 1, r, depth + 1);
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifdef _DEBUG
	freopen("input.txt", "r", stdin); freopen("output.txt", "w", stdout);
#endif
//#ifndef _DEBUG
//	freopen("cubroot.in", "r", stdin); freopen("cubroot.out", "w", stdout);
//#endif
	int tt;
	cin >> tt;
	while (tt--) {
		int n, m;
		cin >> n >> m;
		vl a(n);
		vl ps(n + 1, 0);
		map<ll, ll> imin;
		map<ll, ll> ss;
		for (int i = 0; i < n; i++) {
			cin >> a[i];
			ps[i + 1] = ps[i] + a[i];
			if (imin.find(ps[i + 1]) == imin.end()) imin[ps[i + 1]] = i;
		}
		ll pref = INF;
		for (auto i = imin.rbegin(); i != imin.rend(); i++) {
			ss[i->first] = min(pref, i->second);
			pref = min(pref, i->second);
		}
		while (m--) {
			ll x;
			cin >> x;
			if (ss.lower_bound(x) == ss.end()) {
				if (ps[n] <= 0) cout << "-1 ";
				else {
					ll rotate = (x - ss.rbegin()->first) / ps[n] + ((x - ss.rbegin()->first) % ps[n] ? 1ll : 0ll);
					ll res = rotate * n;
					ll ost = x - rotate * ps[n];
					//if (imin.lower_bound(ost) == imin.end()) {
					//	res += n;
					//	ost -= ps[n];
					//}
					res += ss.lower_bound(ost)->second;
					cout << res << " ";
				}
			}
			else {
				cout << ss.lower_bound(x)->second << " ";
			}
		}
		cout << "\n";
	}
}


/*
	Important stuff
	- int overflow
	- array bounds
	- special cases (n=1, max n) maybe adhoc problem
	- doubles are read for a long time (4 * 10 ^ 5 danger GNU vs MS ICPC 2020 1/4)
	- don't get stuck on one approach
	- don't get stuck on one problem
	- recheck submissions if near the end of the tournament and there is nothing to do
	- do something instead of nothing and stay organized
*/