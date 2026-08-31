#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 5;
vector<long long> g[N];
bool vis[N];
long long child[N];
vector<long long> ans;
void dfs(long long node) {
  vis[node] = true;
  child[node] = 1;
  for (long long x : g[node]) {
    if (!vis[x]) {
      dfs(x);
      child[node] += child[x];
    }
  }
}
void dfs2(long long node) {
  vis[node] = true;
  for (long long x : g[node]) {
    if (!vis[x] && child[x] % 2 == 0) {
      dfs2(x);
    }
  }
  ans.push_back(node);
  for (long long x : g[node]) {
    if (!vis[x] && child[x] % 2 == 1) {
      dfs2(x);
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  set<long long> even, odd;
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long p;
    cin >> p;
    if (p != 0) {
      g[p].push_back(i);
      g[i].push_back(p);
    }
  }
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  dfs(1);
  memset(vis, false, sizeof(vis));
  dfs2(1);
  cout << "YES\n";
  for (long long x : ans) cout << x << "\n";
}
