#include <bits/stdc++.h>
using namespace std;
long long ans = 0;
const int N = 1e6 + 6;
vector<int> adj[N];
int INF = 1e9, k;
int t[N], sum[N];
void dfs(int u, int p) {
  for (auto v : adj[u])
    if (v != p) {
      dfs(v, u);
      if (t[v] + 1 <= k) sum[u] += sum[v];
      t[u] = min(t[u], t[v] + 1);
    }
  if (t[u] == INF) t[u] = 0, sum[u] = 1;
}
int solve(int u, int p) {
  int ret = 0;
  for (auto v : adj[u])
    if (v != p) {
      if (t[v] + 1 <= k)
        ret = max(ret, sum[u] - sum[v] + solve(v, u));
      else
        ret = max(ret, sum[u] + solve(v, u));
    }
  if (t[u] == 0) ret = 1;
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) t[i] = INF;
  for (int i = 2; i <= n; i++) {
    int x;
    cin >> x;
    adj[i].push_back(x);
    adj[x].push_back(i);
  }
  dfs(1, 1);
  cout << solve(1, 1) << endl;
  return 0;
}
