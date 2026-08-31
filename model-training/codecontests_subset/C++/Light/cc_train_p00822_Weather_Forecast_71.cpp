// template {{{

#include <bits/stdc++.h>
using namespace std;

#define loop(i, a, b) for (int i = (int)(a); i < (int)(b); i++)
#define rep(i, n) loop(i, 0, n)
#define rloop(i, a, b) for (int i = (int)(b) - 1; i >= (int)(a); i--)
#define rrep(i, n) rloop(i, 0, n)
#define eb emplace_back
#define ef emplace_front
#define pb pop_back
#define pf pop_front
#define all(c) std::begin(c), std::end(c)
#define mp std::make_pair
#define mt std::make_tuple
#define fi first
#define se second
#define popcnt __builtin_popcountll

using uint = unsigned;
using ll = long long;
using ull = unsigned long long;
using ld = long double;

template<typename T>
using max_pq = priority_queue<T, vector<T>, less<T>>;

template<typename T>
using min_pq = priority_queue<T, vector<T>, greater<T>>;

const int MOD = 1e9 + 7;
const int INF = 1e9 + 10;
const ll LLINF = 1e18 + 10;

const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, -1, 0, 1};
const int dx8[] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int dy8[] = {0, -1, -1, -1, 0, 1, 1, 1};

template<typename T>
inline T sq(T x){ return x * x; }

template<typename T, typename U>
inline bool chmax(T &x, U y){ if (x >= y) return false; x = y; return true; }

template<typename T, typename U>
inline bool chmin(T &x, U y){ if (x <= y) return false; x = y; return true; }

template<typename T>
inline void sort(T &c){ std::sort(std::begin(c), std::end(c)); }

template<typename T>
inline void reverse(T &c){ std::reverse(std::begin(c), std::end(c)); }

template<typename T>
inline void unique(T &c){ std::sort(std::begin(c), std::end(c)); c.erase(std::unique(all(c)), std::end(c)); }

// }}}

#define R (rand() < RAND_MAX / 2)

const int T1[] = {
	51, 102, 204, 816, 1632, 3264, 13056, 26112, 52224
};

const int T2[][5] = {
	{0, 1, 2, 3, 6},
	{0, 1, 2, 4, 7},
	{0, 1, 2, 5, 8},
	{0, 3, 4, 5, 6},
	{1, 3, 4, 5, 7},
	{2, 3, 4, 5, 8},
	{0, 3, 6, 7, 8},
	{1, 4, 6, 7, 8},
	{2, 5, 6, 7, 8}
};

const int M1 = 9;
const int M7 = 4782969;

int n;
int s[366];
set<int> vis[366][9];

int dfs(int d, int p, int st)
{
	if (vis[d][p].count(st)) return 0;
	if (d >= 7){
		int x = st, y = 0;
		rep(i, 7){
			y |= T1[x % M1];
			x /= 9;
		}
		if (y != (1 << 16) - 1){
			// vis[d][p].insert(st);
			return 0;
		}
	}
	if (d == n) return 1;
	if (s[d] & T1[p]){
		if (R) vis[d][p].insert(st);
		return 0;
	}
	for (int to : T2[p]){
		if (dfs(d + 1, to, (st * 9 + p) % M7)){
			return 1;
		}
	}
	if (R) vis[d][p].insert(st);
	return 0;
}

int main()
{
	while (cin >> n, n){
		rep(i, 366) rep(j, 9) vis[i][j].clear();
		rep(i, n){
			s[i] = 0;
			rrep(j, 16){
				int b;
				cin >> b;
				s[i] = s[i] * 2 + b;
			}
		}
		cout << dfs(0, 4, 0) << endl;
	}
}