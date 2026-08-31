#include <bits/stdc++.h>
using namespace std;
string to_string(string s) { return '"' + s + '"'; }
string to_string(char s) { return string(1, s); }
string to_string(const char* s) { return to_string((string)s); }
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
  for (const auto& x : v) {
    if (!f) r += ", ";
    f = 0;
    r += to_string(x);
  }
  return r + "}";
}
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
const int inf = 1e9;
const long long INF = 1e18;
const int mod = 1e9 + 7;
const int bit32 = log2(inf) + 3;
const int bit64 = log2(INF) + 3;
inline int add(int a, int b) {
  a += b;
  if (a >= mod) a -= mod;
  return a;
}
inline int sub(int a, int b) {
  a -= b;
  if (a < 0) a += mod;
  return a;
}
inline int mul(int a, int b) { return (int)((long long)a * b % mod); }
inline int modexpo(int a, int b) {
  int res = 1;
  while (b > 0) {
    if (b & 1) res = mul(res, a);
    a = mul(a, a);
    b /= 2;
  }
  return res;
}
inline int divide(int a, int b) { return mul(a, modexpo(b, mod - 2)); }
clock_t time_p = clock();
void ktj() {
  time_p = clock() - time_p;
  cerr << "Time elapsed : " << (float)(time_p) / CLOCKS_PER_SEC << "\n";
}
const int N = 2e5 + 5;
vector<int> g[N];
bool vis[N];
void pre(int n) {
  for (int i = 1; i <= n; i++) {
    g[i].clear();
    vis[i] = 0;
  }
}
set<int> s, r;
void dfs(int u, int ignore) {
  if (u == ignore) return;
  if (vis[u]) return;
  vis[u] = 1;
  s.insert(u);
  for (auto v : g[u]) {
    dfs(v, ignore);
  }
}
void solve() {
  int n, m, a, b;
  cin >> n >> m >> a >> b;
  pre(n);
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dfs(a, b);
  for (int i = 1; i <= n; i++) {
    vis[i] = 0;
  }
  r = s;
  s.clear();
  dfs(b, a);
  for (int i = 1; i <= n; i++) {
    if (s.count(i) and r.count(i)) {
      s.erase(i);
      r.erase(i);
    }
  }
  s.erase(b);
  r.erase(a);
  cout << (int)s.size() * 1LL * (int)r.size() << '\n';
  s.clear();
  r.clear();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  ktj();
}
