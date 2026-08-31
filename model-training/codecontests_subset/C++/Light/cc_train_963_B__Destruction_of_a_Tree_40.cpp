#include <bits/stdc++.h>
using namespace std;
vector<long long> adj[200005];
bool vis[200005] = {false};
long long degree[200005] = {0};
vector<long long> ans;
long long dfs(long long s) {
  vis[s] = true;
  long long i, ans = 0;
  for (i = 0; i < adj[s].size(); i++) {
    if (!vis[adj[s][i]]) ans += dfs(adj[s][i]);
  }
  degree[s] = ans + 1;
  return degree[s];
}
void dfs1(long long s) {
  vis[s] = true;
  long long i;
  for (i = 0; i < adj[s].size(); i++) {
    if (!vis[adj[s][i]] && degree[adj[s][i]] % 2 == 0) dfs1(adj[s][i]);
  }
  ans.push_back(s);
  for (i = 0; i < adj[s].size(); i++) {
    if (!vis[adj[s][i]] && degree[adj[s][i]] % 2 == 1) dfs1(adj[s][i]);
  }
}
int main() {
  long long n, i, j, temp;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> temp;
    if (temp == 0) continue;
    adj[i].push_back(temp);
    adj[temp].push_back(i);
  }
  if (n % 2 == 0) {
    cout << "NO"
         << "\n";
    return 0;
  }
  dfs(1);
  for (i = 1; i <= n; i++) vis[i] = false;
  dfs1(1);
  cout << "YES"
       << "\n";
  for (i = 0; i < ans.size(); i++) cout << ans[i] << "\n";
}
