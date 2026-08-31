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
const long long int mod = 1e9 + 7;
const int maxn = 1000005;
vector<long long int> g[maxn];
long long int dp[maxn];
long long int n, k;
pair<long long int, long long int> dfs(long long int u, long long int d = 0) {
  pair<long long int, long long int> now = {1e9, 0};
  dp[u] = -1e9;
  for (auto v : g[u]) {
    pair<long long int, long long int> temp = dfs(v, d + 1);
    if (temp.first <= d) {
      now.first = min(now.first, temp.first);
      now.second += temp.second;
      dp[u] = max(dp[u], dp[v] - temp.second);
    } else {
      dp[u] = max(dp[u], dp[v]);
    }
  }
  if (g[u].size() == 0) {
    now = {d - k, 1};
    dp[u] = 1;
  } else {
    dp[u] += now.second;
  }
  return now;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> k;
  for (long long int i = 1; i <= n - 1; i++) {
    long long int p;
    cin >> p;
    g[p].push_back(i + 1);
  }
  dfs(1);
  cout << dp[1] << '\n';
}
