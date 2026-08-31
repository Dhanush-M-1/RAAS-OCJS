#include <bits/stdc++.h>
using namespace std;
vector<vector<long long> > adj;
vector<long long> util[2];
vector<long long> ht;
vector<long long> res;
long long n, k;
void dfs(long long r) {
  if (adj[r].size() == 0) {
    util[0][r] = ht[r] - k;
    util[1][r] = 1;
    return;
  }
  for (long long i = 0; i < adj[r].size(); i++) {
    long long c = adj[r][i];
    ht[c] = ht[r] + 1;
    dfs(c);
    if (util[0][c] <= ht[r]) {
      util[0][r] = min(util[0][r], util[0][c]);
      util[1][r] += util[1][c];
    }
  }
}
void solve(long long r) {
  res[r] = 1;
  for (long long i = 0; i < adj[r].size(); i++) {
    long long c = adj[r][i];
    solve(c);
    if (util[0][c] <= ht[r]) {
      res[r] = max(res[r], (util[1][r] - util[1][c]) + res[c]);
    } else
      res[r] = max(res[r], util[1][r] + res[c]);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> k;
  adj.clear();
  adj.resize(n);
  ht.clear();
  ht.resize(n, 0);
  res.clear();
  res.resize(n, 0);
  util[0].resize(n, n + 5);
  util[1].resize(n, 0);
  for (long long i = 1; i < n; i++) {
    long long p;
    cin >> p;
    p--;
    adj[p].push_back(i);
  }
  dfs(0);
  solve(0);
  cout << res[0] << endl;
  return 0;
}
