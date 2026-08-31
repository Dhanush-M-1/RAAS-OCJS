#include <bits/stdc++.h>
using namespace std;
vector<long long> adj[200005];
long long c = 0;
bool vis[200005];
vector<long long> lf;
void dfs(long long v) {
  if (vis[v]) {
    return;
  }
  vis[v] = true;
  if (adj[v].size() == 1) {
    c++;
    lf.push_back(v);
  }
  for (auto u : adj[v]) {
    dfs(u);
  }
}
int main() {
  long long n;
  cin >> n;
  long long x, y;
  for (int i = 0; i < n - 1; i++) {
    cin >> x >> y;
    adj[x].push_back(y);
    adj[y].push_back(x);
  }
  dfs(x);
  for (int i = 1; i <= n; i++) {
    if (adj[i].size() == 2) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
