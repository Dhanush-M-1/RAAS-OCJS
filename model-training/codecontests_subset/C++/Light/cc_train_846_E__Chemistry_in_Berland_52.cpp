#include <bits/stdc++.h>
#pragma GCC optimize("-O2")
using namespace std;
void err(istream_iterator<string> it) { cerr << endl; }
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << "\t";
  err(++it, args...);
}
template <typename T1, typename T2>
ostream& operator<<(ostream& c, pair<T1, T2>& v) {
  c << "(" << v.first << "," << v.second << ")";
  return c;
}
template <template <class...> class TT, class... T>
ostream& operator<<(ostream& out, TT<T...>& c) {
  out << "{ ";
  for (auto& x : c) out << x << " ";
  out << "}";
  return out;
}
const int LIM = 1e5 + 5, MOD = 1e9 + 7;
int t, n, m, k, x, y, w;
long long a[LIM], b[LIM];
vector<pair<int, int> > v[LIM];
long long dfs(int u, long long e) {
  for (auto& it : v[u]) {
    b[u] += dfs(it.first, it.second);
    if (b[u] < -1e18) {
      cout << "NO\n";
      exit(0);
    }
  }
  if (b[u] < a[u]) {
    if ((a[u] - b[u]) > 1e18 / e) {
      cout << "NO\n";
      exit(0);
    }
    return (b[u] - a[u]) * e;
  } else
    return (b[u] - a[u]);
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> b[i];
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < n - 1; ++i) {
    cin >> x >> y;
    --x;
    v[x].push_back({i + 1, y});
  }
  long long res = dfs(0, 1);
  if (res < 0)
    cout << "NO\n";
  else
    cout << "YES\n";
  return 0;
}
