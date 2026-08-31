#include <bits/stdc++.h>
using namespace std;
long long MOD = 1000000007;
vector<vector<long long> > g;
long long INF = (long long)1e9;
long long N, K;
long long res = 1;
vector<long long> path;
vector<long long> dp1;
vector<long long> dp2;
long long dfs(long long a) {
  path.push_back(a);
  long long ans = 0;
  long long mx = 0;
  long long base = 0;
  for (long long i = 0; i < g[a].size(); i++) {
    long long t = dfs(g[a][i]);
    base += dp2[g[a][i]];
    dp2[a] += dp2[g[a][i]];
    mx = max(mx, t - dp2[g[a][i]]);
  }
  for (long long i = 0; i < g[a].size(); i++) {
    dp1[a] += dp1[g[a][i]];
  }
  if (dp1[a] == 0) {
    dp2[a] = 0;
  }
  ans = base + mx;
  if ((long long)g[a].size() == 0) {
    ans = 1;
    long long t = (long long)path.size() - K - 1;
    if (t >= 0) {
      dp1[path[t]]--;
    }
    dp1[a]++;
    dp2[a] = 1;
  }
  path.pop_back();
  return ans;
}
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  cin >> N >> K;
  g.resize(N);
  dp1.resize(N, 0);
  dp2.resize(N, 0);
  long long a;
  for (long long i = 0; i < N - 1; i++) {
    cin >> a;
    a--;
    g[a].push_back(i + 1);
  }
  cout << dfs(0) << endl;
}
