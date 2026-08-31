#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
template <class T>
ostream& operator<<(ostream& os, vector<T> V) {
  os << "[ ";
  for (auto v : V) os << v << " ";
  return os << "]";
}
template <class L, class R>
ostream& operator<<(ostream& os, pair<L, R> P) {
  return os << "(" << P.first << "," << P.second << ")";
}
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
const long long INF = 0x3f3f3f3f;
const long long M = 1e9 + 7;
const long long N = 2e5 + 5;
vector<long long> g[N];
long long n, m, a, b;
bool d[N];
long long ctr;
bool va, vb;
void dfs(long long z) {
  if (z == a) {
    va = true;
    return;
  }
  if (z == b) {
    vb = true;
    return;
  }
  ctr++;
  for (long long y : g[z]) {
    if (!d[y]) {
      if (y != a && y != b) d[y] = true;
      dfs(y);
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cout << fixed << setprecision(15);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (long long i = 1; i <= n; ++i) g[i].clear();
    for (long long i = 0; i < m; ++i) {
      long long u, v;
      cin >> u >> v;
      g[u].push_back(v);
      g[v].push_back(u);
    }
    memset(d, 0, sizeof(d));
    long long na = 0, nb = 0;
    for (long long i = 1; i <= n; ++i) {
      if (i == a || i == b) continue;
      if (d[i]) continue;
      ctr = 0;
      va = vb = false;
      d[i] = true;
      dfs(i);
      if (va && !vb) na += ctr;
      if (vb && !va) nb += ctr;
    }
    cout << na * nb << '\n';
  }
}
