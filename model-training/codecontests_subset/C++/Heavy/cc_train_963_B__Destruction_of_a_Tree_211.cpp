#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& a) {
  in >> a.first >> a.second;
  return in;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& out, pair<T1, T2> a) {
  out << a.first << " " << a.second;
  return out;
}
template <typename T, typename T1>
T maxs(T& a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T mins(T& a, T1 b) {
  if (b < a) a = b;
  return a;
}
long long solve() {
  long long n;
  cin >> n;
  vector<long long> g[n + 1];
  long long r;
  for (long long i = 1; i < n + 1; i++) {
    long long p;
    cin >> p;
    if (p) g[p].push_back(i);
    if (!p) r = i;
  }
  vector<long long> dp(n + 1), h(n + 1);
  vector<long long> vec;
  function<void(long long)> dfs = [&](long long u) {
    long long d = 0;
    if (u != r) d++;
    for (auto i : g[u]) {
      h[i] = h[u] + 1;
      dfs(i);
      if (dp[i] == 0) d++;
    }
    if (d % 2 == 0) {
      vec.push_back(u);
      dp[u] = 1;
    } else
      dp[u] = 0;
  };
  dfs(r);
  if (dp[r]) {
    cout << "YES"
         << "\n";
    vector<pair<long long, long long> > p;
    for (long long i = 1; i < n + 1; i++) {
      if (dp[i] == 0) p.push_back({h[i], i});
    }
    sort(p.begin(), p.end());
    for (auto i : vec) cout << i << "\n";
    for (auto i : p) cout << i.second << "\n";
  } else {
    cout << "NO"
         << "\n";
  }
  return 0;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
