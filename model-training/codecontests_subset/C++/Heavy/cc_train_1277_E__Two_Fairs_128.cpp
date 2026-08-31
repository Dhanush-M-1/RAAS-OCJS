#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
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
const long long int maxn = 2000001;
long long int sz[maxn], par[maxn];
void init(long long int n) {
  for (long long int i = 1; i <= n; i++) {
    sz[i] = 1;
    par[i] = i;
  }
}
long long int root(long long int x) {
  if (par[x] == x)
    return x;
  else {
    return (par[x] = root(par[x]));
  }
}
void un(long long int u, long long int v) {
  u = root(u);
  v = root(v);
  if (u == v) return;
  if (sz[u] < sz[v]) swap(u, v);
  par[v] = u;
  sz[u] += sz[v];
  return;
}
void solve() {
  long long int n, m, a, b;
  cin >> n >> m >> a >> b;
  vector<pair<long long int, long long int> > e;
  for (long long int i = 0; i < m; i++) {
    long long int u, v;
    cin >> u >> v;
    e.push_back({u, v});
  }
  long long int x1 = 0, x2 = 0, x3 = 0;
  init(n);
  for (long long int i = 0; i < m; i++) {
    if (e[i].first == a || e[i].second == a) continue;
    un(e[i].first, e[i].second);
  }
  set<long long int> s1, s2;
  for (long long int i = 1; i <= n; i++) {
    if (root(i) == root(b)) {
      s1.insert(i);
    }
  }
  init(n);
  for (long long int i = 0; i < m; i++) {
    if (e[i].first == b || e[i].second == b) continue;
    un(e[i].first, e[i].second);
  }
  for (long long int i = 1; i <= n; i++) {
    if (root(i) == root(a)) {
      s2.insert(i);
    }
  }
  long long int ans = (n - s1.size() - 1) * (n - s2.size() - 1);
  cout << ans << endl;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
