#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 5;
const long long mo = 1e9 + 7;
long long sx, sy, ex, ey, dx[6] = {0, 1, 0, -1, 0, 0},
                          dy[6] = {1, 0, -1, 0, 0, 0}, m, n, k,
                          dz[6]{0, 0, 0, 0, -1, 1};
long long p, sg, no, v, re, ans, w, moo;
int par[500005];
long long b[400005];
long long a[400006], c[500006], dp[400005];
struct mat {
  long long a[40][40];
};
mat init, unit;
long long gcd(long long a, long long b) { return a ? gcd(b % a, a) : b; }
set<long long> se;
long long qu(long long a, long long b, long long m) {
  long long ans = 1;
  while (b) {
    if (b & 1) {
      ans = ans % m * a % m;
    }
    b >>= 1;
    a = a % m * a % m;
  }
  return ans;
}
int su(int n) {
  if (n == 1 || n == 0) return 0;
  for (int i = 2; i <= sqrt(n); i++) {
    if (n % i == 0) return 0;
  }
  return 1;
}
int fi(int a) {
  if (a == par[a])
    return a;
  else
    return par[a] = fi(par[a]);
}
vector<long long> ve, ve1;
string s1;
map<long long, long long> mp, mp1;
long long vis[500005];
int nu = 1, id = 1;
priority_queue<long long> que;
pair<long long, long long> a1[400000];
long long vis1[405][405], vis2[406][6];
int maze[505][505], maze1[505][505];
vector<long long> g[400000], g1[400000];
string s;
int cmp(pair<long long, long long> a, pair<long long, long long> b) {
  return (a.first - a.second) > (b.first - b.second);
}
int main() {
  int t, p2, p3;
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string ss, sss;
  long long l, r, n1;
  while (cin >> n >> m) {
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) {
      cin >> p >> w;
      g[p].push_back(w);
    }
    vis[a[n - 1]] = 1;
    sg = 1;
    ans = 0;
    for (int i = n - 2; i >= 0; i--) {
      int ct = 0;
      for (auto it : g[a[i]]) {
        if (vis[it]) ct++;
      }
      if (ct == sg)
        ans++, vis[a[i]] = 0;
      else {
        vis[a[i]] = 1;
        sg++;
      }
    }
    cout << ans << endl;
    for (int i = 1; i <= n; i++) vis[i] = 0, g[i].clear();
  }
}
