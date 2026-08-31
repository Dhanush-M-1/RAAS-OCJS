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
template <typename T, typename U>
pair<T, U> operator+(const pair<T, U>& l, const std::pair<T, U>& r) {
  return {l.first + r.first, l.second + r.second};
}
const long long int md = 998244353;
const long long int maxn = 1e5 + 5;
long long int a[maxn], b[maxn];
vector<pair<long long int, long long int>> g[maxn];
long long int dfs(long long int u, long long int p) {
  for (auto v : g[u]) {
    long long int x = dfs(v.first, u);
    if (x < 0) {
      b[u] += -x;
    } else {
      if ((long double)(v.second) * x > 1e16) {
        cout << "NO" << '\n';
        exit(0);
      }
      b[u] -= v.second * x;
      if (b[u] < -1e16) {
        cout << "NO" << '\n';
        exit(0);
      }
    }
  }
  return a[u] - b[u];
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  vector<long long int> p(n + 1), k(n + 1);
  for (long long int i = 1; i <= n; i++) {
    cin >> b[i];
  }
  for (long long int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (long long int i = 2; i <= n; i++) {
    cin >> p[i] >> k[i];
    g[p[i]].push_back({i, k[i]});
  }
  long long int res = dfs(1, 0);
  if (res > 0)
    cout << "NO" << '\n';
  else
    cout << "YES" << '\n';
}
