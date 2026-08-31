#include <bits/stdc++.h>
using namespace std;
const long long max_n = 1e6 + 20;
long long n, m, k, ans, sum;
long long a[max_n];
long long mark[max_n];
vector<long long> v, adj[max_n], jda[max_n];
void dfs(long long v) {
  mark[v] = 1;
  if (adj[v].size() == 2) ans = -1;
  for (auto i : adj[v]) {
    if (!mark[i]) {
      dfs(i);
    }
  }
}
int32_t main() {
  cin >> n;
  for (long long i = 1; i < n; i++) {
    long long u, v;
    cin >> u >> v;
    u--, v--;
    adj[v].push_back(u);
    adj[u].push_back(v);
  }
  if (n == 2) {
    cout << "YES";
    return 0;
  }
  for (long long i = 0; i < n; i++) {
    if (adj[i].size() == 1 && !mark[i]) dfs(i);
  }
  if (ans == -1) {
    cout << "NO";
  } else
    cout << "YES";
  return 0;
}
