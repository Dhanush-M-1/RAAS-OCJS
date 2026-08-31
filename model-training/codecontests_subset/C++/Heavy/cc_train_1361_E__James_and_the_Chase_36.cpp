#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
template <class T>
inline bool setmin(T &a, T b) {
  if (a > b) return a = b, 1;
  return 0;
}
template <class T>
inline bool setmax(T &a, T b) {
  if (a < b) return a = b, 1;
  return 0;
}
template <class T>
inline T fast(T a, T b, T mod) {
  long long res = 1;
  while (b) {
    if (b & 1) res = (res * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return res;
}
template <class T>
istream &operator>>(istream &os, vector<T> &container) {
  for (auto &u : container) os >> u;
  return os;
}
template <class T>
ostream &operator<<(ostream &os, const vector<T> &container) {
  for (auto &u : container) os << u << " ";
  return os;
}
template <class T>
inline T gcd(T a, T b) {
  while (b) swap(a %= b, b);
  return a;
}
const long long INF = 1e9 + 7;
const long long mod = 998244353;
const long long BIG_INF = 1e18 + 7;
const long long N = 1e6 + 7;
const long long T = 1 << 20;
const long double inf = 1e18;
long long m, n, k, q;
vector<int> ans, odw, preorder, good, skok;
int cnt;
vector<vector<int> > G(N);
void dodaj(pair<pair<int, int>, pair<int, int> > &akt, pair<int, int> syn,
           int v) {
  if (syn.first >= preorder[v]) return;
  if (syn.first < akt.first.first) {
    akt.second = akt.first;
    akt.first = syn;
  } else if (syn.first < akt.second.first) {
    akt.second = syn;
  }
}
pair<pair<int, int>, pair<int, int> > polacz(
    pair<pair<int, int>, pair<int, int> > akt,
    pair<pair<int, int>, pair<int, int> > syn, int v) {
  dodaj(akt, syn.first, v);
  dodaj(akt, syn.second, v);
  return akt;
}
void dfs3(int v) {
  odw[v] = 1;
  if (!good[v] and skok[v]) good[v] = good[skok[v]];
  for (auto &u : G[v])
    if (!odw[u]) dfs3(u);
}
pair<pair<int, int>, pair<int, int> > dfs2(int v) {
  preorder[v] = cnt++;
  odw[v] = 1;
  pair<pair<int, int>, pair<int, int> > ret = {{INF, 0}, {INF, 0}};
  for (auto &u : G[v])
    if (odw[u] == 0)
      ret = polacz(ret, dfs2(u), v);
    else
      dodaj(ret, {preorder[u], u}, v);
  if (ret.second.second == 0 and ret.first.first != INF)
    skok[v] = ret.first.second;
  return ret;
}
void finish(int v) {
  if (v == 0) return;
  cnt = 0;
  fill((odw).begin(), (odw).end(), 0);
  dfs2(v);
  fill((odw).begin(), (odw).end(), 0);
  fill((good).begin(), (good).end(), 0);
  good[v] = 1;
  dfs3(v);
  int ile = accumulate(good.begin(), good.end(), 0);
  if (ile * 5 < n) {
    cout << -1 << '\n';
    return;
  }
  for (int i = 1; i <= n; i++)
    if (good[i]) cout << i << ' ';
  cout << '\n';
}
int dfs(int v) {
  odw[v] = 1;
  bool ret = 1;
  for (auto &u : G[v]) {
    if (odw[u] == 2)
      return false;
    else if (odw[u] == 0)
      ret &= dfs(u);
  }
  odw[v] = 2;
  return ret;
}
int Find(int v) {
  fill((odw).begin(), (odw).end(), 0);
  return v * dfs(v);
}
void solve() {
  cin >> n >> m;
  odw.resize(n + 1);
  preorder.resize(n + 1);
  good.resize(n + 1);
  skok.resize(n + 1);
  fill((skok).begin(), (skok).end(), 0);
  ans.clear();
  for (int i = 1; i <= n; i++) G[i].clear();
  for (int i = 0; i < (m); i++) {
    int a, b;
    cin >> a >> b;
    G[a].push_back(b);
  }
  bool ok = 0;
  for (int i = 0; i < (100); i++) {
    int v = Find(uniform_int_distribution<long long>(1, n)(rng));
    if (v) {
      ok = 1;
      finish(v);
      break;
    }
  }
  if (!ok) cout << -1 << '\n';
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> q;
  for (int i = 0; i < (q); i++) {
    solve();
  }
}
