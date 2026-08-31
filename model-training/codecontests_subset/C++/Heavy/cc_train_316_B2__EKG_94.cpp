#include <bits/stdc++.h>
using namespace std;
const long long N = 1010;
long long n, k, a[N], dp[N][N], jolo = 1;
vector<long long> g[N], b;
vector<vector<long long> > comps;
vector<bool> visited(N, 0);
void dfs(long long v) {
  visited[v] = true;
  comps.back().push_back(v);
  for (auto u : g[v]) {
    if (!visited[u]) {
      dfs(u);
    }
  }
}
long long solve(long long n, long long i) {
  if (n < 0) {
    return 0;
  }
  if (n == 0) {
    return dp[n][i] = 1;
  }
  if (i == 0) {
    return dp[n][i] = (n == b[0]);
  }
  if (dp[n][i] != -1) {
    return dp[n][i];
  }
  return dp[n][i] = solve(n, i - 1) | solve(n - b[i], i - 1);
}
signed main() {
  ios::sync_with_stdio(false);
  memset(dp, -1, sizeof dp);
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] != 0) {
      g[i].push_back(a[i]);
      g[a[i]].push_back(i);
    }
  }
  comps.push_back({});
  dfs(k);
  for (long long i = 1; i <= n; i++) {
    if (!visited[i]) {
      comps.push_back({});
      dfs(i);
    }
  }
  long long tmp = k;
  while (a[tmp] != 0) {
    jolo++;
    tmp = a[tmp];
  }
  long long mx = 0;
  for (long long i = 1; i < (long long)(comps.size()); i++) {
    mx += (long long)(comps[i].size());
    b.push_back((long long)(comps[i].size()));
  }
  sort(b.begin(), b.end());
  for (long long i = 0; i <= mx; i++) {
    if (solve(i, (long long)(b.size()) - 1)) {
      cout << jolo + i << "\n";
    }
  }
}
