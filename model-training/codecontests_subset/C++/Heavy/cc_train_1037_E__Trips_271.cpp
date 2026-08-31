#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
string to_string(string s) { return '"' + s + '"'; }
string to_string(char s) { return string(1, s); }
string to_string(const char *s) { return to_string((string)s); }
string to_string(bool b) { return (b ? "true" : "false"); }
template <typename A>
string to_string(A);
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A>
string to_string(A v) {
  bool f = 1;
  string r = "{";
  for (const auto &x : v) {
    if (!f) r += ", ";
    f = 0;
    r += to_string(x);
  }
  return r + "}";
}
void debug_out() { cout << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cout << " " << to_string(H);
  debug_out(T...);
}
inline int add(int a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
  return a;
}
inline int sub(int a, int b) {
  a -= b;
  if (a < 0) a += MOD;
  return a;
}
inline int mul(int a, int b) { return (int)((long long)a * b % MOD); }
inline int binpow(int a, int b) {
  int res = 1;
  while (b > 0) {
    if (b & 1) res = mul(res, a);
    a = mul(a, a);
    b /= 2;
  }
  return res;
}
inline int inv(int a) { return binpow(a, MOD - 2); }
int gcd(int a, int b, int &x, int &y) {
  if (a == 0) {
    x = 0, y = 1;
    return b;
  }
  int x1, y1;
  int d = gcd(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return d;
}
const int N = 2e5 + 5;
int n, m, k, deg[N], ans[N];
vector<pair<int, int> > edges;
set<int> g[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; ++i) {
    int x, y;
    cin >> x >> y;
    edges.push_back({x, y});
    deg[x]++;
    deg[y]++;
    g[x].insert(y);
    g[y].insert(x);
  }
  int rem = n;
  queue<int> q;
  for (int i = 1; i <= n; ++i)
    if (deg[i] < k) {
      q.push(i);
      rem--;
    }
  for (int i = m - 1; i >= 0; --i) {
    while (!q.empty()) {
      int v = q.front();
      q.pop();
      for (int u : g[v]) {
        deg[u]--;
        g[u].erase(v);
        if (deg[u] == k - 1) {
          q.push(u);
          rem--;
        }
      }
      deg[v] = 0;
      g[v].clear();
    }
    ans[i] = rem;
    int x = edges[i].first, y = edges[i].second;
    if (!g[x].count(y)) continue;
    deg[x]--;
    deg[y]--;
    g[x].erase(y);
    g[y].erase(x);
    if (deg[x] == k - 1) {
      q.push(x);
      rem--;
    }
    if (deg[y] == k - 1) {
      q.push(y);
      rem--;
    }
  }
  for (int i = 0; i < m; ++i) cout << ans[i] << "\n";
  return 0;
}
