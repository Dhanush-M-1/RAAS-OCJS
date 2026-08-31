#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int MOD2 = 1007681537;
const int INF = (int)1e9;
const long long LINF = (long long)1e18;
const long double PI = acos((long double)-1);
const long double EPS = 1e-9;
inline long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long fpow(long long n, long long k, int p = MOD) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
template <class T>
inline int chkmin(T& a, const T& val) {
  return val < a ? a = val, 1 : 0;
}
template <class T>
inline int chkmax(T& a, const T& val) {
  return a < val ? a = val, 1 : 0;
}
inline long long isqrt(long long k) {
  long long r = sqrt(k) + 1;
  while (r * r > k) r--;
  return r;
}
inline long long icbrt(long long k) {
  long long r = cbrt(k) + 1;
  while (r * r * r > k) r--;
  return r;
}
inline void addmod(int& a, int val, int p = MOD) {
  if ((a = (a + val)) >= p) a -= p;
}
inline void submod(int& a, int val, int p = MOD) {
  if ((a = (a - val)) < 0) a += p;
}
inline int mult(int a, int b, int p = MOD) { return (long long)a * b % p; }
inline int inv(int a, int p = MOD) { return fpow(a, p - 2, p); }
inline int sign(long double x) { return x < -EPS ? -1 : x > +EPS; }
inline int sign(long double x, long double y) { return sign(x - y); }
const int maxn = 1e5 + 5;
int n;
long long a[maxn];
long long b[maxn];
int x[maxn];
int k[maxn];
vector<pair<int, int> > adj[maxn];
long long dfs(int u) {
  long long res = 0;
  for (int i = (0); i < (int((adj[u]).size())); i++) {
    int v = adj[u][i].first;
    int w = adj[u][i].second;
    long long t = dfs(v);
    if (t < 0) {
      res += t;
    } else {
      res += min(t, (LINF + LINF) / w) * w;
    }
    chkmin(res, LINF + LINF);
  }
  res += a[u] - b[u];
  return res;
}
void solve() {
  cin >> n;
  for (int i = (0); i < (n); i++) cin >> b[i];
  for (int i = (0); i < (n); i++) cin >> a[i];
  for (int i = (1); i < (n); i++) {
    cin >> x[i] >> k[i], x[i]--;
    adj[x[i]].push_back(make_pair(i, k[i]));
  }
  if (dfs(0) <= 0) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
}
int main() {
  int JUDGE_ONLINE = 1;
  if (fopen("in.txt", "r")) {
    JUDGE_ONLINE = 0;
    assert(freopen("in.txt", "r", stdin));
  } else {
    ios_base::sync_with_stdio(0), cin.tie(0);
  }
  solve();
  if (!JUDGE_ONLINE) {
  }
  return 0;
}
