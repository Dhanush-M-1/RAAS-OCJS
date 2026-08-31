#include <bits/stdc++.h>
using namespace std;
const long long inf = 2e18;
const long long mod = 1e9 + 7;
const long double pi = 3.141592653589793238462643383279502884;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
void print(long long a[], long long n) {
  for (long long i = 0; i < n; i++) {
    cout << a[i] << " ";
  }
  cout << "\n";
}
long long power(long long x, long long y) {
  if (y <= 0) return 1;
  long long ans = 1;
  x %= mod;
  while (y) {
    if (y & 1) ans = (x * ans) % mod;
    x = (x * x) % mod;
    y >>= 1;
  }
  return ans;
}
long long modInverse(long long n) { return power(n, mod - 2); }
inline long long mul(long long a, long long b) { return (a * b) % mod; }
inline long long sub(long long a, long long b) {
  long long c = (a - b);
  if (c < 0) c += mod;
  return c;
}
inline long long add(long long a, long long b) {
  long long c = (a + b);
  if (c >= mod) c -= mod;
  return c;
}
inline long long divi(long long a, long long b) {
  return mul(a, modInverse(b));
}
const long long N = 2e5 + 1;
vector<long long> adj[N];
bool visited1[N];
bool visited2[N];
void dfs1(long long st, long long avoid) {
  visited1[st] = 1;
  for (auto u : adj[st]) {
    if (u != avoid && !visited1[u]) dfs1(u, avoid);
  }
}
void dfs2(long long st, long long avoid) {
  visited2[st] = 1;
  for (auto u : adj[st]) {
    if (u != avoid && !visited2[u]) dfs2(u, avoid);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout << fixed << setprecision(10);
  int t;
  cin >> t;
  while (t--) {
    long long n, m, a, b;
    cin >> n >> m >> a >> b;
    for (int i = 0; i < m; i++) {
      long long u, v;
      cin >> u >> v;
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    dfs1(a, b);
    dfs2(b, a);
    long long c1 = -1, c2 = -1;
    for (int i = 1; i <= n; i++) {
      if (visited1[i] == 1 && visited2[i] == 0) c1++;
      if (visited1[i] == 0 && visited2[i] == 1) c2++;
      visited2[i] = 0;
      visited1[i] = 0;
      adj[i].clear();
    }
    cout << c1 * c2 << "\n";
  }
  return 0;
}
