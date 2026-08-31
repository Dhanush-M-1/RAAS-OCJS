#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 5;
const long long mo = 1e9 + 7;
long long sx, sy, ex, ey, dx[6] = {0, 1, 0, -1, 0, 0},
                          dy[6] = {1, 0, -1, 0, 0, 0}, m, n, k,
                          dz[6]{0, 0, 0, 0, -1, 1}, sg, re;
long long p, no, v, ans, w;
int par[55];
long long a[400005], b[400006], c[500006], d[400006], dp[2005][2005];
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
map<long long, long long> mp, mp1;
pair<long long, long long> a1[400000];
int vis[400005], vis2[406][6];
vector<long long> g[400000], g1[400000];
struct node {
  long long x, y, co, t;
} aa[200005];
int cmp(node a, node b) { return a.co > b.co; }
int cmp1(node a, node b) { return a.t < b.t; }
int main() {
  int t, p2, p3;
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string ss, sss, s;
  long long l, r, n1;
  while (cin >> n) {
    while (n--) {
      cin >> l >> r >> p;
      if (p < l || p > r) {
        cout << p << endl;
      } else {
        cout << r + p - (r % p) << endl;
      }
    }
  }
}
